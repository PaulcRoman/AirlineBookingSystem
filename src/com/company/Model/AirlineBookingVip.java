package com.company.Model;

public class AirlineBookingVip extends AirlineBooking {

    public AirlineBookingVip(int airlineBookingId, String airlinePassengerId, String airlineBookingType,String airlineBookingDate){
        super(airlineBookingId,airlinePassengerId,"VIP",airlineBookingDate);

    }

        public AirlineBookingVip(String text) {

            super(Integer.parseInt(text.split(",")[0]), text.split(",")[1], text.split(",")[2], text.split(",")[3]);
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public boolean equals(Object o) {
            AirlineBookingVip av = (AirlineBookingVip) o;

            return super.equals(av);
        }

    }

