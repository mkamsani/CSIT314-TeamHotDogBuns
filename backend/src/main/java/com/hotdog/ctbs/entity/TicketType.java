package com.hotdog.ctbs.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hotdog.ctbs.repository.TicketTypeRepository;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ticket_type")
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid", nullable = false)
    protected UUID uuid;

    @Column(name = "type_name", length = 7)
    protected String typeName;

    @Column(name = "type_price", nullable = false, precision = 10, scale = 2)
    protected Double typePrice;

    @Column(name = "is_active")
    protected Boolean isActive;

    @Transient
    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    //////////////////////////////// Service /////////////////////////////////

    public static void createTicketType(TicketTypeRepository ticketTypeRepository, String typeName, Double typePrice) {
        if (typeName == null)
            throw new IllegalArgumentException("Type name cannot be null.");

        if (typeName.equals("adult") ||
            typeName.equals("child") ||
            typeName.equals("senior") ||
            typeName.equals("student") ||
            typeName.equals("redemption"))
            throw new IllegalArgumentException("Type name is reserved.");

        for (String typeNameFromRepository : ticketTypeRepository.findAllTypeName())
            if (typeName.equalsIgnoreCase(typeNameFromRepository)) //
                throw new IllegalArgumentException("Type name already exists.");

        TicketType ticketType = new TicketType();
        ticketType.typeName = typeName;
        ticketType.typePrice = typePrice;
        ticketType.isActive = true;
        ticketTypeRepository.save(ticketType);
    }

    public static void updateTicketType(TicketTypeRepository ticketTypeRepository, String targetTypeName, String newTypeName, Double typePrice){
        TicketType ticketType = ticketTypeRepository.findByTypeName(targetTypeName).orElse(null);
        if (ticketType == null)
            throw new IllegalArgumentException("Ticket Type not found");
        if (newTypeName == null)
            throw new IllegalArgumentException("Invalid Type Name");

        if (targetTypeName.equals("adult") ||
                targetTypeName.equals("child") ||
                targetTypeName.equals("senior") ||
                targetTypeName.equals("student") ||
                targetTypeName.equals("redemption")||
                newTypeName.equals("adult") ||
                newTypeName.equals("child") ||
                newTypeName.equals("senior") ||
                newTypeName.equals("student") ||
                newTypeName.equals("redemption")) {
            throw new IllegalArgumentException("Reserved Ticket Types");
        }

        for (String typeNameFromRepository : ticketTypeRepository.findAllTypeName())
            if (newTypeName.equalsIgnoreCase(typeNameFromRepository))
                throw new IllegalArgumentException("Type name already exists.");

        System.out.println(typePrice);
        if (typePrice == null || typePrice < 0)
            throw new IllegalArgumentException();
        else if(typePrice == 0.0)
            System.out.println("No change to typePrice");
        else
            ticketType.typePrice = typePrice;

        ticketType.typeName = newTypeName;


        ticketTypeRepository.save(ticketType);
    }

    public static String readTicketType(TicketTypeRepository ticketTypeRepository, String param) {
        List<TicketType> ticketTypeList;
        if (param.equals("all"))
            ticketTypeList = ticketTypeRepository.findAll();
        else if (param.equals("active"))
            ticketTypeList = ticketTypeRepository.findAllByIsActiveTrue();
        else
            throw new IllegalArgumentException("Invalid parameter.");

        ArrayNode an = objectMapper.createArrayNode();
        for (TicketType ticketType : ticketTypeList) {
            ObjectNode on = objectMapper.createObjectNode();
            on.put("typename", ticketType.typeName);
            on.put("typeprice", ticketType.typePrice);
            on.put("isactive", ticketType.isActive.toString());
            an.add(on);
        }
        return an.toString();
    }
    // suspend no issue
    public static void suspendTicketType(TicketTypeRepository ticketTypeRepository , String targettypename) {
        TicketType ticketType = ticketTypeRepository.findByTypeName(targettypename).orElseThrow(
                () -> new IllegalArgumentException("Ticket Type not found.")
        );
        ticketType.isActive = false;
        ticketTypeRepository.save(ticketType);
    }
}