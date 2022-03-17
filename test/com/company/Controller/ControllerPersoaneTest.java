package com.company.Controller;

import com.company.Model.Pasager;
import com.company.Model.Persoana;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ControllerPersoaneTest {

    ControllerPersoane controlPersoane;

    @BeforeEach
    public void initiere(){

        controlPersoane  = new ControllerPersoane(Path.of("test","com","company","data","persoaneTest").toString());

    }

    @Test
    public void testAfisare(){

        controlPersoane.add(new Persoana("1,Andrei,andrei@email.com,andreicont,parola1,true"));
        controlPersoane.add(new Persoana("2,Marius,marius@email.com,mariuscont,parola2,false"));
        controlPersoane.add(new Persoana("4,Ducu,demail@email.com,ducucont,parola4,false"));
        controlPersoane.afisare();

    }

    @Test
    public void testAdd(){

        controlPersoane.add(new Persoana("1,Andrei,andrei@email.com,andreicont,parola1,true"));
        controlPersoane.add(new Persoana("2,Marius,marius@email.com,mariuscont,parola2,false"));
        controlPersoane.add(new Persoana("4,Ducu,demail@email.com,ducucont,parola4,false"));
        Persoana persoana = new Persoana("3,Ion,ion@gmail.com,ioncont,parola2,false");
        controlPersoane.add(persoana);

        controlPersoane.afisare();

        assertEquals(2,controlPersoane.getPozitie(2));
        assertEquals(1,controlPersoane.getPozitie(1));
    }

    @Test
    public void testGetPozitie(){

        controlPersoane.add(new Persoana("1,Andrei,andrei@email.com,andreicont,parola1,true"));
        controlPersoane.add(new Persoana("2,Marius,marius@email.com,mariuscont,parola2,false"));
        controlPersoane.add(new Persoana("4,Ducu,demail@email.com,ducucont,parola4,false"));
        assertEquals(1,controlPersoane.getPozitie(1));

    }

    @Test
    public void testUpdateName(){
        controlPersoane.add(new Persoana("1,Andrei,andrei@email.com,andreicont,parola1,true"));
        controlPersoane.add(new Persoana("2,Marius,marius@email.com,mariuscont,parola2,false"));
        controlPersoane.add(new Persoana("4,Ducu,demail@email.com,ducucont,parola4,false"));

        assertEquals("mariana",controlPersoane.updateNume(0,"mariana"));
    }

    @Test
    public void testisAdmin(){
        controlPersoane.add(new Persoana("1,Andrei,andrei@email.com,andreicont,parola1,true"));
        controlPersoane.add(new Persoana("2,Marius,marius@email.com,mariuscont,parola2,false"));
        controlPersoane.add(new Persoana("4,Ducu,demail@email.com,ducucont,parola4,false"));
        assertEquals(false,controlPersoane.isAdmin(2,false));

    }

    @Test
    public void testUpdateEmail(){
        controlPersoane.add(new Persoana("1,Andrei,andrei@email.com,andreicont,parola1,true"));
        controlPersoane.add(new Persoana("2,Marius,marius@email.com,mariuscont,parola2,false"));
        controlPersoane.add(new Persoana("4,Ducu,demail@email.com,ducucont,parola4,false"));
        assertEquals("mariana@email.co",controlPersoane.updateEmail(0,"mariana@email.co"));
    }

    @Test
    public void testUsername(){
        controlPersoane.add(new Persoana("1,Andrei,andrei@email.com,andreicont,parola1,true"));
        controlPersoane.add(new Persoana("2,Marius,marius@email.com,mariuscont,parola2,false"));
        controlPersoane.add(new Persoana("4,Ducu,demail@email.com,ducucont,parola4,false"));
        assertEquals("username1",controlPersoane.updateUsername(2,"username1"));
    }

    @Test
    public void testUpdateparola(){
        controlPersoane.add(new Persoana("1,Andrei,andrei@email.com,andreicont,parola1,true"));
        controlPersoane.add(new Persoana("2,Marius,marius@email.com,mariuscont,parola2,false"));
        controlPersoane.add(new Persoana("4,Ducu,demail@email.com,ducucont,parola4,false"));
        assertEquals("parolauser001",controlPersoane.updateParola(1,"parolauser001"));
    }

    @Test
    public void testDelete(){
        controlPersoane.add(new Persoana("1,Andrei,andrei@email.com,andreicont,parola1,true"));
        controlPersoane.add(new Persoana("2,Marius,marius@email.com,mariuscont,parola2,false"));
        controlPersoane.add(new Persoana("4,Ducu,demail@email.com,ducucont,parola4,false"));

        controlPersoane.delete(1);

        assertEquals(true,controlPersoane.delete(1));

    }

    @Test
    public void testLogin(){

        Pasager client = new Pasager("4,Ion,ion@email.com,ioncont,parola9,false");
        controlPersoane.add(client);
//        assertEquals("ion@email.com", controlPersoane.login("ion@email.com","parola9").getEmail());
    }

    @AfterEach
    public void postConditie(){

        controlPersoane.clear();

        controlPersoane.add(new Persoana("1,Andrei,andrei@email.com,andreicont,parola1,true"));
        controlPersoane.add(new Persoana("2,Marius,marius@email.com,mariuscont,parola2,false"));
        controlPersoane.add(new Persoana("4,Ducu,demail@email.com,ducucont,parola4,false"));
        controlPersoane.save();
    }

}