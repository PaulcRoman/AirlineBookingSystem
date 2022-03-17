package com.company.Controller;

import com.company.Controller.ControllerTicket;
import com.company.Model.Ticket;
import com.company.Model.TicketVip;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class ControllerTicketTest {

    ControllerTicket controllerTicket;

    @BeforeEach
    public void initiere(){
        controllerTicket = new ControllerTicket("D:\\Full Stack JAVA\\JavaBasics\\AirlineBookingSystem II\\test\\com\\company\\data\\ticketTest");

    }

    @Test
    public void afisare(){

        controllerTicket.afisare();

    }

    @Test
    public void testGetPozitie(){

        assertEquals(1,controllerTicket.getPozitie(1));


    }


    @Test
    public void testUpdateTicketType(){

        assertEquals("VIP",controllerTicket.updateTicketType(2,"VIP"));

    }

    @AfterEach
    public void postConditie(){

        controllerTicket.clear();

        controllerTicket.add(new Ticket("1,1,VIP,2 May 2022"));
        controllerTicket.add(new Ticket("2,2,regular,1 Jan 2019"));
        controllerTicket.add(new Ticket("3,3,regular,13 June2021"));
        controllerTicket.add(new Ticket("4,4,VIP,1 Feb 2021"));

        controllerTicket.save();


    }



}