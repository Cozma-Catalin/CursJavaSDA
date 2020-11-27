package business.dto;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class FlightDTO {
    @NotNull
    private String flightNumber;
    @NotNull
    private String departureDateAndTime;

    private AirportDTO departureAirport;
    @NotNull
    private String arrivingDateAndTime;

    private AirportDTO arrivingAirport;
    @NotNull
    private double price;
    @NotNull
    private int seatsAvailable;

    public FlightDTO(String flightNumber,String departureDateAndTime, AirportDTO departureAirport,String arrivingDateAndTime ,
                     AirportDTO arrivingAirport, double price, int seatsAvailable) {
        this.flightNumber = flightNumber;
        this.departureDateAndTime = departureDateAndTime;
        this.departureAirport = departureAirport;
        this.arrivingDateAndTime = arrivingDateAndTime;
        this.arrivingAirport = arrivingAirport;
        this.price = price;
        this.seatsAvailable = seatsAvailable;
    }

    public FlightDTO() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureDateAndTime() {
        return departureDateAndTime;
    }

    public void setDepartureDateAndTime(String departureDateAndTime) {
        this.departureDateAndTime = departureDateAndTime;
    }

    public AirportDTO getDepartureAirport() {
        return departureAirport;
    }

    public void setArrivingDateAndTime(String arrivingDateAndTime) {
        this.arrivingDateAndTime = arrivingDateAndTime;
    }

    public void setDepartureAirport(AirportDTO departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivingDateAndTime() {
        return arrivingDateAndTime;
    }

    public AirportDTO getArrivingAirport() {
        return arrivingAirport;
    }

    public void setArrivingAirport(AirportDTO arrivingAirport) {
        this.arrivingAirport = arrivingAirport;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    @Override
    public String toString() {
        return "FlightDTO: " + flightNumber + " departure date and time:" + departureDateAndTime +
                ", departing from Airport:" + departureAirport +
                ", arriving in Airport:" + arrivingAirport + ", price:" + price +
                ", number of seats available:" + seatsAvailable ;
    }
}
