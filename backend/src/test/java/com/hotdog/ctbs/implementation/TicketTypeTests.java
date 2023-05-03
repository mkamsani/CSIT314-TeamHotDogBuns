package com.hotdog.ctbs.implementation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hotdog.ctbs.service.implementation.*;
import java.time.LocalDate;
import java.util.UUID;
import java.math.BigDecimal;

@SpringBootTest
public class TicketTypeTests {

    @Autowired
    private TicketTypeImpl ticketTypeImpl;

    @Test
    void getter()
    {
        //test getter methods
        System.out.println("ticketTypeImpl.getAllTicketTypeNames()");
        System.out.println(ticketTypeImpl.getAllTicketTypeNames());
        System.out.println();

        System.out.println("ticketTypeImpl.getAllTicketTypePrices()");
        System.out.println(ticketTypeImpl.getAllTicketTypePrices());
        System.out.println();

        System.out.println("ticketTypeImpl.getAllTicketTypeIsActives()");
        System.out.println(ticketTypeImpl.getAllTicketTypeIsActives());
        System.out.println();

        System.out.println("ticketTypeImpl.getAllTicketTypePricesFromTicketTypeIsActives()");
        System.out.println(ticketTypeImpl.getAllTicketTypePricesFromTicketTypeIsActives());
        System.out.println();

        System.out.println("ticketTypeImpl.getAllTicketTypeNamesFromTicketTypeIsActives()");
        System.out.println(ticketTypeImpl.getAllTicketTypeNamesFromTicketTypeIsActives());
        System.out.println();

        System.out.println("ticketTypeImpl.getAllTicketTypeNamesAndPricesFromTicketTypeIsActives()");
        System.out.println(ticketTypeImpl.getAllTicketTypeNamesAndPricesFromTicketTypeIsActives());
        System.out.println();

        /*
        System.out.println("ticketTypeImpl.getTicketTypeByUUID(UUID.fromString(\"690464fc-5beb-4ed8-90b3-cd2454b53496\"))");
        System.out.println(ticketTypeImpl.getTicketTypeByUUID(UUID.fromString("690464fc-5beb-4ed8-90b3-cd2454b53496")));
        System.out.println();

        */

        System.out.println("ticketTypeImpl.getTicketTypeByTypeName(\"testType\")");
        System.out.println(ticketTypeImpl.getTicketTypeByTypeName("testType"));
        System.out.println();
    }

    @Test
    void createMethod()
    {
        //test create method
        System.out.println("ticketTypeImpl.createTicketType(\"test1\", 10.00, true)");
        ticketTypeImpl.createTicketType("test1", 10.00, true);
        System.out.println();
        System.out.println(ticketTypeImpl.getAllTicketTypeNames());
    }

    @Test
    void updateMethod()
    {
        //test update method (using typename)
        System.out.println("The list of existing ticket type names before an update made");
        System.out.println(ticketTypeImpl.getAllTicketTypeNames());
        System.out.println();

        System.out.println("ticketTypeImpl.updateTicketTypeByTypeName(\"test\", \"test2\")");
        ticketTypeImpl.updateTicketTypeByTypeName("test", "test2");
        System.out.println();

        System.out.println("The list of existing ticket type names after an update made");
        System.out.println(ticketTypeImpl.getAllTicketTypeNames());
        System.out.println("Done for update ticket type name method");

        //
        //test update method (using typeprice)
        System.out.println("The list of existing ticket type prices before an update made");
        System.out.println(ticketTypeImpl.getAllTicketTypePrices());
        System.out.println();

        System.out.println("ticketTypeImpl.updateTicketTypeByTypePrice(\"student\", 20.00)");
        ticketTypeImpl.updateTicketTypeByTypePrice("student", 20.00);
        System.out.println();

        System.out.println("The list of existing ticket type prices after an update made");
        System.out.println(ticketTypeImpl.getAllTicketTypePrices());
        System.out.println("Done for update ticket type price method");

        //
        //test update method (using isactive)
        System.out.println("The list of existing ticket type isactives before an update made");
        System.out.println(ticketTypeImpl.getAllTicketTypeIsActives());
        System.out.println();

        System.out.println("ticketTypeImpl.updateTicketTypeByIsActive(\"test\", false)");
        ticketTypeImpl.updateTicketTypeByIsActive("senior", false);
        System.out.println();

        System.out.println("The list of existing ticket type isactives after an update made");
        System.out.println(ticketTypeImpl.getAllTicketTypeIsActives());
        System.out.println("Done for update ticket type isactive method");

        // test update method using all fields
        System.out.println("The list of existing ticket type names and prices before an update made");
        System.out.println(ticketTypeImpl.getAllTicketTypesDetails());
        System.out.println();

        System.out.println("ticketTypeImpl.updateTicketTypeByAllFields(\"child\", \"child1\", 30.00, false)");
        ticketTypeImpl.updateTicketTypeByAllFields("child", "child1", 30.00, false);
        System.out.println();

        System.out.println("The list of existing ticket type names and prices after an update made");
        System.out.println(ticketTypeImpl.getAllTicketTypesDetails());
        System.out.println("Done for update ticket type name and price method");
    }

}
