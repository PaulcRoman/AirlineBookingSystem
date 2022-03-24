package com.company.View;

import com.company.Controller.ControllerBooking;
import com.company.Controller.ControllerPersoane;
import com.company.Controller.ControllerTicket;
import com.company.Model.Pasager;
import com.company.Model.Persoana;

import java.util.Scanner;

public class ViewLogin {

    private ControllerPersoane controllerPersoane;
    private ControllerBooking controllerBooking;
    private ControllerTicket controllerTicket;
    private Scanner scanner;
    private Pasager pasager;

    public ViewLogin(){

        controllerPersoane = new ControllerPersoane("D:\\Full Stack JAVA\\JavaBasics\\AirlineBookingSystem II\\src\\com\\company\\resorces\\persoane");
        scanner = new Scanner(System.in);
        controllerBooking = new ControllerBooking("D:\\Full Stack JAVA\\JavaBasics\\AirlineBookingSystem II\\src\\com\\company\\resorces\\persoane");
        controllerTicket = new ControllerTicket("D:\\Full Stack JAVA\\JavaBasics\\AirlineBookingSystem II\\src\\com\\company\\resorces\\tickets");

    }

    public void meniu(){

        System.out.println("Apasati tasta 1 pentru a va loga");
        System.out.println("Apasati tasta 2 pentru a iesi");

    }

    public void go(){

        boolean running = true;

        while (running == true){
            meniu();

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    login();
                    break;
                case 2:
                    controllerPersoane.save();
                    controllerBooking.save();
                    controllerTicket.save();
                    System.out.println("La reverede");
                    running=false;
                    break;
            }

        }

    }

    public void login(){

        System.out.println("Introduceti emailul: ");
        String email = scanner.nextLine();

        System.out.println("Introduceti parola: ");
        String parola = scanner.nextLine();

        Persoana persoana = controllerPersoane.login(email,parola);

        if (persoana != null && persoana instanceof Pasager){

            ViewUsers viewUsers = new ViewUsers((Pasager) persoana);
            viewUsers.go();

        }else {
            System.out.println("Credentiale incorecte");
        }

    }

}
