package com.company.Model;

public class Persoana implements Comparable<Persoana>{

    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private boolean isAdmin;

    public Persoana(int id, String name, String email, String username, String password,boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isAdmin =  isAdmin;
    }

    public Persoana(String text){

        this(Integer.parseInt(text.split(",")[0]),text.split(",")[1],text.split(",")[2],
                text.split(",")[3],text.split(",")[4],Boolean.parseBoolean(text.split(",")[5]));

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString(){
        return this.id+","+this.name+","+this.email+","+this.username+","+isAdmin;
    }

    @Override
    public boolean equals(Object o){

        Persoana p = (Persoana) o;

        if (p.getId() == id){
            return true;
        }
        return false;

    }

    @Override
    public  int compareTo(Persoana p){

        if (this.id > p.id){
            return 1;
        }else if (this.id < p.id){
            return -1;
        }else {
            return 0;
        }

    }
}
