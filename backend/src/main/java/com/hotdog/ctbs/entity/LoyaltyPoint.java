package com.hotdog.ctbs.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "loyalty_point")
public class LoyaltyPoint {
    @Id
    @Column(name = "uuid", nullable = false)
    protected UUID id;

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "uuid", nullable = false)
    protected UserAccount userAccount;

    @Column(name = "points_redeemed", nullable = false)
    protected Integer pointsRedeemed;

    @Column(name = "points_total", nullable = false)
    protected Integer pointsTotal;

    @Transient
    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override // TODO : Remove
    public String toString()
    {
        ObjectNode json = objectMapper.createObjectNode();
        json.put("userName", userAccount.getUsername());
        json.put("pointsRedeemed", pointsRedeemed);
        json.put("pointsTotal", pointsTotal);
        return json.toString();
    }

    protected Integer pointsBalance()
    {
        return pointsTotal - pointsRedeemed;
    }

    //////////////////////////////// Service /////////////////////////////////

}