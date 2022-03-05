package com.company.Model;

public class TicketVip extends Ticket{

    public TicketVip(int ticketId, int ticketCustomerId, String ticketType, String ticketDate) {
        super(ticketId, ticketCustomerId, "VIP", ticketDate);
    }

    public TicketVip(String text) {
        super(text);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public boolean equals(Object o){
        TicketVip tv = (TicketVip) o;

        return super.equals(tv);
    }
}
