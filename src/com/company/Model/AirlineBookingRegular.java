package com.company.Model;

import java.sql.ClientInfoStatus;

public class AirlineBookingRegular extends AirlineBooking{

    public AirlineBookingRegular(int airlineBookingId, String airlinePassengerId, String airlineBookingType,String airlineBookingDate){
        super(airlineBookingId,airlinePassengerId,"regular",airlineBookingDate);

    }

    public AirlineBookingRegular(String text){

        super(Integer.parseInt(text.split(",")[0]),text.split(",")[1],text.split(",")[2],text.split(",")[3]);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public boolean equals(Object o){
        AirlineBookingRegular ar = (AirlineBookingRegular) o;

        return super.equals(ar);
    }
}
