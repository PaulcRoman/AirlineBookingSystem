package com.company.Comparator;

import com.company.Model.Ticket;

import java.util.Comparator;

public class ComparatorTicketCustomerId implements Comparator<Ticket> {

    public int compare(Ticket t1, Ticket t2){

        if (t1.getTicketCustomerId() > t2.getTicketCustomerId()){
            return 1;
        }else if (t1.getTicketCustomerId()<t2.getTicketCustomerId()){
            return -1;
        }else {
            return 0;
        }

    }

}
