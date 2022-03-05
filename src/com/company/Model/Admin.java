package com.company.Model;

public class Admin extends Persoana{

    public Admin(int id, String name,String email, String username,String password, boolean isAdmin){
        super(id, name, email,username,password, true);

    }

    public Admin(String text){

        super(Integer.parseInt(text.split(",")[0]),text.split(",")[1],text.split(",")[2],
                text.split(",")[3],text.split(",")[4], Boolean.parseBoolean(text.split(",")[5]));

    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public boolean equals(Object o){

        Admin a = (Admin) o;

        return super.equals(a);
    }
}
