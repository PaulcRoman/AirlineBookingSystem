package com.company.View;

import com.company.Controller.ControllerBooking;
import com.company.Controller.ControllerPersoane;
import com.company.Controller.ControllerTicket;
import com.company.Model.AirlineBooking;
import com.company.Model.Pasager;
import com.company.Model.Persoana;
import com.company.Model.Ticket;

import javax.swing.text.View;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class ViewUsers {

    private ControllerPersoane controllerPersoane;
    private ControllerBooking controllerBooking;
    private ControllerTicket controllerTicket;
    private Scanner scanner;
    private Pasager pasager;
    private AirlineBooking airlineBooking;
    private Ticket ticket;


    public ViewUsers(Pasager pasager){
        controllerPersoane = new ControllerPersoane("D:\\Full Stack JAVA\\JavaBasics\\AirlineBookingSystem II\\src\\com\\company\\resorces\\persoane");
        controllerBooking = new ControllerBooking("D:\\Full Stack JAVA\\JavaBasics\\AirlineBookingSystem II\\src\\com\\company\\resorces\\airlineBookings");
        controllerTicket = new ControllerTicket("D:\\Full Stack JAVA\\JavaBasics\\AirlineBookingSystem II\\src\\com\\company\\resorces\\airlineBookings");
        this.pasager = pasager;
        scanner = new Scanner(System.in);
        airlineBooking = new AirlineBooking(airlineBooking.getAirlinesBookingId(),airlineBooking.getAirlineBookingDate(),airlineBooking.getAirlineBookingType(),
                airlineBooking.getAirlinePassengerId());
        this.ticket = new Ticket(ticket.getTicketId(),ticket.getTicketCustomerId(),ticket.getTicketDate(),ticket.getTicketType());

    }

    public void meniu(){

        System.out.println("============Meniu Pasager===========");
        System.out.println("Apasati tasta 1 pentru a vedea biletele disponibile");
        System.out.println("Apasati tasta 2 pentru a va rezerva biletul");


    }

    public void go(){
        meniu();

        int alegere = Integer.parseInt(scanner.nextLine());

        switch (alegere){
            case 1:
                
        }

    }



}
