package com.company.Controller;

import com.company.Collections.Lista;
import com.company.Collections.Node;
import com.company.Model.AirlineBooking;
import com.company.Model.AirlineBookingRegular;
import com.company.Model.AirlineBookingVip;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerBooking {

    private Lista<AirlineBooking> listaBooking;
    private String path;

    public ControllerBooking(String path){
        listaBooking = new Lista<>();
        this.path = path;
        load();
    }

    public void add(AirlineBooking booking){
        listaBooking.add(booking);
    }

    public void load(){
        try {

            File file = new File(path);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {

                String linie = scanner.nextLine();

                if (linie.equals("") == false) {
                    String tipCont = linie.split(",")[2];

                    switch (tipCont) {

                        case "regular":
                            listaBooking.add(new AirlineBookingRegular(linie));
                            break;
                        case "VIP":
                            listaBooking.add(new AirlineBookingVip(linie));
                            break;
                    }

                }

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void afisare() {

      listaBooking.traverse();
    }
    public int getPozitie(int pozitie) {

        Node<AirlineBooking> it = this.listaBooking.iterator();

        while (it!=null){
            it = it.getNext();
        }
        return pozitie;

    }

    public int updateId(int id, int bookingId){

        int pozitie = getPozitie(id);

        if (pozitie != -1){

            AirlineBooking ab = listaBooking.get(pozitie);
            ab.setAirlinesBookingId(bookingId);

        }
        return bookingId;
    }

    public String updatePaxId(int id, String paxId){

        int pozitie = getPozitie(id);

        if (pozitie != -1){

            AirlineBooking ab = listaBooking.get(pozitie);

            ab.setAirlinePassengerId(paxId);

        }
        return paxId;
    }

    public String updateBookingType(int id, String bookingType){

        int pozitie = getPozitie(id);

        if (pozitie != -1) {
            AirlineBooking ab = listaBooking.get(pozitie);

            ab.setAirlineBookingType(bookingType);
        }
        return bookingType;
    }

    public String updateBookingDate(int id, String bookingDate){

        int pozitie = getPozitie(id);

        if (pozitie != -1) {
            AirlineBooking ab = listaBooking.get(pozitie);

            ab.setAirlineBookingDate(bookingDate);
        }
        return bookingDate;
    }

    public void remove(int id){
        listaBooking.remove(id);
    }

    public void save(){

        try {

            File file  = new File(path);
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(this);
            pw.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public String toString(){

        String text = "";

        Node it = this.listaBooking.iterator();

        while (it != null){

            text += it.getData()+"\n";
        }
        return text;

    }

}
