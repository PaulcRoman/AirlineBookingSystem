package com.company.Model;

public class TicketRegular extends Ticket{

    public TicketRegular(int ticketId, int ticketCustomerId, String ticketType, String ticketDate) {
        super(ticketId, ticketCustomerId, "regular", ticketDate);
    }

    public TicketRegular(String text) {
        super(text);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public boolean equals(Object o){
        TicketRegular tr = (TicketRegular) o;
        return super.equals(tr);
    }
}
