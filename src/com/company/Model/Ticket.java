package com.company.Model;

public class Ticket implements Comparable<Ticket>{

    private int ticketId;
    private int ticketCustomerId;
    private String ticketType;
    private String ticketDate;

    public Ticket(int ticketId, int ticketCustomerId, String ticketType, String ticketDate) {
        this.ticketId = ticketId;
        this.ticketCustomerId = ticketCustomerId;
        this.ticketType = ticketType;
        this.ticketDate = ticketDate;
    }

    public Ticket(String text) {
        this(Integer.parseInt(text.split(",")[0]), Integer.parseInt(text.split(",")[1]),text.split(",")[2],
        text.split(",")[3]);
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketCustomerId() {
        return ticketCustomerId;
    }

    public void setTicketCustomerId(int ticketCustomerId) {
        this.ticketCustomerId = ticketCustomerId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    @Override
    public String toString(){
        return this.ticketId+","+this.ticketCustomerId+","+this.ticketType+","+this.ticketDate;
    }

    @Override
    public boolean equals(Object o){

        Ticket ticket = (Ticket) o;

        if (ticket.getTicketId() == ticketId){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public int compareTo(Ticket t){

        if (this.ticketId > t.ticketId){
            return 1;
        }else if (this.ticketId < t.ticketId){
            return -1;
        }else {
            return 0;
        }

    }

}
