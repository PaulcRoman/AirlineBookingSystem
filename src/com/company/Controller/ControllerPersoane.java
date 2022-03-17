package com.company.Controller;

import com.company.Collections.Lista;
import com.company.Collections.Node;
import com.company.Model.Admin;
import com.company.Model.Pasager;
import com.company.Model.Persoana;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ControllerPersoane {

    private Lista<Persoana> listaPersoane;

    private String path;

    public ControllerPersoane(String path){

        listaPersoane = new Lista<>();

        this.path = path;

        load();
    }

    public void add(Persoana persoana) {

        listaPersoane.add(persoana);
    }

    public void load(){

        try {
            File file = new File(path);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){

                String linie = scanner.nextLine();

                if (linie.equals("")==false){
                    Boolean isAdmin = Boolean.parseBoolean(linie.split(",")[5]);

                    if (isAdmin) {
                        listaPersoane.add(new Admin(linie));
                    } else if (!(isAdmin)) {
                        listaPersoane.add(new Pasager(linie));
                    }
                }

            }


        }catch (Exception e){

        }

    }

    public void afisare() {

    listaPersoane.traverse();

    }

    public int getPozitie(int pozitie){

        Node<Persoana> iterator = this.listaPersoane.iterator();

        while (iterator != null){

            iterator = iterator.getNext();

        }
        return pozitie;
    }

    public String updateNume(int id, String nume){

        int index = getPozitie(id);

        if (index != -1){

            Persoana p = listaPersoane.get(index);

            p.setName(nume);

        }
        return nume;

    }

    public String updateEmail(int id, String email){

        int index = getPozitie(id);

        if (index != -1){

            Persoana p = listaPersoane.get(index);

            p.setEmail(email);
        }
        return email;
    }

    public String updateUsername(int id, String username){

        int index = getPozitie(id);

        if (index != -1){

            Persoana p = listaPersoane.get(index);

            p.setUsername(username);

        }
        return username;
    }

    public String updateParola(int id, String parola){

        int index = getPozitie(id);

        if (index != -1){

            Persoana p = listaPersoane.get(index);

            p.setPassword(parola);
        }
        return parola;
    }

    public  Boolean isAdmin(int id, boolean isAdmin){

        int index = getPozitie(id);

        if (index != -1){

            Persoana p = listaPersoane.get(index);

            p.setAdmin(isAdmin);
        }
        return isAdmin;
    }

    public boolean delete(int id){

        if (id != -1) {

            listaPersoane.remove(id);
            return true;
        }
        return false;
    }

    public void save(){

        try {

            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(this);
            printWriter.close();

        }catch (Exception e){

        }

    }

    @Override
    public String toString(){

        String text = "";

        Node<Persoana> it = this.listaPersoane.iterator();

        while (it != null){

            text += it.getData()+"\n";
            it = it.getNext();
        }

        return text;

    }

    public void clear(){
        listaPersoane.clear();
    }

    public int nextId(){

        if (listaPersoane.size()>0){

            return listaPersoane.get(listaPersoane.size()-1).getId()+1;
        }
        return -1;
    }

//    public Persoana login(String email, String parola){
//
//        Node<Persoana> it = listaPersoane.iterator();
//
//        while (it !=null){
//            Lista<Persoana> p = listaPersoane;//?
//            if (p.getEmail().equals(email) && p.getPassword().equals(parola)) {
//                return p;
//            }
//            it = it.getNext();
//        }
//
//        return null;
//
//        for (Persoana p : listaPersoane){
//
//            if (p.getEmail().equals(email) && p.getPassword().equals(parola)) {
//                return p;
//            }
//
//        }
//        return null;
//    }

}
