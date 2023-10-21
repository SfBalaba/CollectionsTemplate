package ru.naumen.collection.task2;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Task2Test{
    @Test
    public void defaultAddition() {
        Ticket t = new Ticket(123, "client1");
        Assert.assertEquals("Kombo colletion contain null when ticket been initialize and nothing be added", null, BartenderInterface.kombo.get(t));
    }

    @Test
    public void getWithoutUpdateAdditionsList() {
        Ticket t = new Ticket(123, "client1");
        Assert.assertEquals("If items were not added to the ticket, then nothing was ordered. Returns addition.No", List.of(additions.No), BartenderInterface.scanTicket(t));
    }

    @Test
    public void getAdditionsDublicatTicket() {
        Ticket t = new Ticket(123, "client1");
        TicketInterface.updateAdditions(t, List.of(additions.Drinks, additions.Eat));
        Ticket t1 = new Ticket(123, "client");
        TicketInterface.updateAdditions(t1, List.of(additions.Eat));
        Assert.assertEquals("If Equals and hashCode overrided", 1, BartenderInterface.kombo.size());
    }
    @Test
    public void testOverrideEquals() {
        Ticket t = new Ticket(123, "client1");
        Ticket t1 = new Ticket(123, "client");
        Assert.assertTrue("Ticket with same id equals", t1.equals(t));
    }

    @Test
    public void changeAdditionsTicket() {
        Ticket t = new Ticket(123, "client1");
        TicketInterface.updateAdditions(t, List.of(additions.Eat, additions.Drinks));
        Assert.assertEquals("Addition No not remove. List of Addition not update", List.of(additions.Eat, additions.Drinks), BartenderInterface.scanTicket(t));
    }
    @Test
    public void CreateMoreOneTicket() {
        Ticket t = new Ticket(123, "client1");
        Ticket t1 = new Ticket(133, "client1");
        Assert.assertEquals("Add 2 ticket", 2, BartenderInterface.kombo.size());
        TicketInterface.updateAdditions(t, List.of(additions.Eat, additions.Drinks));
        Assert.assertEquals("Size Additions when updateAdditions call", 2, BartenderInterface.scanTicket(t).size());
        Assert.assertEquals("Addition No not remove", List.of(additions.Eat, additions.Drinks), BartenderInterface.scanTicket(t));
    }
}