package com.company.Controller;


import com.company.Collections.Lista;
import com.company.Collections.Node;
import com.company.Model.AirlineBookingRegular;
import com.company.Model.Ticket;
import com.company.Model.TicketRegular;
import com.company.Model.TicketVip;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.TooManyListenersException;

public class ControllerTicket {

    private Lista<Ticket> listaBilete;

    private String path;

    public ControllerTicket(String path) {
        this.listaBilete = new Lista<>();
        this.path = path;
        load();
    }

    public void add(Ticket ticket){
        listaBilete.add(ticket);
    }

    public void load(){

        try {
            File file = new File(path);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){

                String linie = scanner.nextLine();

                if (linie.equals("")==false){
                    String tip = linie.split(",")[2];

                    switch (tip){
                        case "regular":
                            listaBilete.add(new TicketRegular(linie));
                            break;

                        case "VIP":
                            listaBilete.add(new TicketVip(linie));
                            break;
                    }


                }
            }



        }catch (Exception e){


        }
    }

    public void afisare(){

        listaBilete.traverse();

    }

    public int getPozitie(int pozitie){

        Node it = this.listaBilete.iterator();

        while (it != null){
            it = it.getNext();
        }
        return pozitie;
    }

    public int getSize(){

        return listaBilete.size();

    }

    public void clear(){//nu e ok

        listaBilete.clear();
    }

    public int updateId(int id, int ticketId){

        int pozitie = getPozitie(id);

        if (pozitie != -1){

            Ticket t = listaBilete.get(pozitie);

            t.setTicketId(ticketId);

        }

        return ticketId;

    }

    public void updateCustomerId(int id, int custId){
        int pozitie = getPozitie(id);

        if (pozitie != -1){

            Ticket t = listaBilete.get(pozitie);

            t.setTicketCustomerId(custId);
        }

    }

    public String updateTicketType(int id, String type){
        int pozitie = getPozitie(id);

        if (pozitie!=-1){
            Ticket t = listaBilete.get(pozitie);
            t.setTicketType(type);
        }
        return type;
    }

    public String updateTicketData(int id, String date){

        int pozitie = getPozitie(id);

        if (pozitie != -1){

            Ticket t = listaBilete.get(pozitie);

            t.setTicketDate(date);
        }
        return date;
    }

    public void remove(int id){
        listaBilete.stergePozitie(id);
    }

   public void save(){

        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(this);
            printWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }

   }

   @Override
    public String  toString(){

        String text = "";

        Node it = this.listaBilete.iterator();

        while (it != null){

            text += it.getData()+"\n";
            it = it.getNext();
        }

        return text;
   }

}

