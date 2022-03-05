package com.company.Model;

public class AirlineBooking implements Comparable<AirlineBooking>{

    private int airlinesBookingId;
    private String airlinePassengerId;
    private String airlineBookingType;
    private String airlineBookingDate;

    public AirlineBooking(int airlinesBookingId, String airlinePassengerId, String airlineBookingType, String airlineBookingDate) {
        this.airlinesBookingId = airlinesBookingId;
        this.airlinePassengerId = airlinePassengerId;
        this.airlineBookingType = airlineBookingType;
        this.airlineBookingDate = airlineBookingDate;
    }

    public AirlineBooking(String text){
        this(Integer.parseInt(text.split(",")[0]),text.split(",")[1],text.split(",")[2],text.split(",")[2]);
    }

    public int getAirlinesBookingId() {
        return airlinesBookingId;
    }

    public void setAirlinesBookingId(int airlinesBookingId) {
        this.airlinesBookingId = airlinesBookingId;
    }

    public String getAirlinePassengerId() {
        return airlinePassengerId;
    }

    public void setAirlinePassengerId(String airlinePassengerId) {
        this.airlinePassengerId = airlinePassengerId;
    }

    public String getAirlineBookingType() {
        return airlineBookingType;
    }

    public void setAirlineBookingType(String airlineBookingType) {
        this.airlineBookingType = airlineBookingType;
    }

    public String getAirlineBookingDate() {
        return airlineBookingDate;
    }

    public void setAirlineBookingDate(String airlineBookingDate) {
        this.airlineBookingDate = airlineBookingDate;
    }

    @Override
    public String toString(){
        return this.airlinesBookingId+","+this.airlinePassengerId+","+this.airlineBookingType+","+this.airlineBookingDate;
    }

    @Override
    public boolean equals(Object o){
        AirlineBooking airlineBooking = (AirlineBooking) o;

        if (airlineBooking.getAirlinesBookingId() == airlinesBookingId){
            return true;
        }

        return false;
    }

    @Override
    public int compareTo(AirlineBooking a){

      if (this.airlinesBookingId > a.airlinesBookingId){
          return 1;
      }else if (this.airlinesBookingId < a.airlinesBookingId){
          return -1;
      }else{
          return 0;
      }

    }


}
