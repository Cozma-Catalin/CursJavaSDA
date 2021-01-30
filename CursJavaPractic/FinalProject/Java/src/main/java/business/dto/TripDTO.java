package business.dto;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



public class TripDTO {
    @NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z A-Z])*")
    private String name;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date departureDate;
    @Valid
    private FlightDTO departureFlight;
    @NotNull
    private java.sql.Date returnDate;
    @Valid
    private FlightDTO returningFlight;
    @Valid
    private HotelDTO stayingHotel;
    @NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z A-Z])*")
    private String mealType;
    @NotNull
    private int numberOfDays;
    @NotNull
    private boolean promoted;
    @NotNull
    private double priceForAdult;
    @NotNull
    private double priceForChild;
    @NotNull
    private int numberOfAdults;
    @NotNull
    private int numberOfChildren;

    @NotNull
    private int numberOfTripsAvailable;



    public TripDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HotelDTO getStayingHotel() {
        return stayingHotel;
    }

    public void setStayingHotel(HotelDTO stayingHotel) {
        this.stayingHotel = stayingHotel;
    }

    public FlightDTO getDepartureFlight() {
        return departureFlight;
    }

    public void setDepartureFlight(FlightDTO departureFlight) {
        this.departureFlight = departureFlight;
    }

    public FlightDTO getReturningFlight() {
        return returningFlight;
    }

    public void setReturningFlight(FlightDTO returningFlight) {
        this.returningFlight = returningFlight;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public java.sql.Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(java.sql.Date departureDate) {
        this.departureDate = departureDate;
    }

    public java.sql.Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(java.sql.Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public double getPriceForAdult() {
        return priceForAdult;
    }

    public void setPriceForAdult(double priceForAdult) {
        this.priceForAdult = priceForAdult;
    }

    public double getPriceForChild() {
        return priceForChild;
    }

    public void setPriceForChild(double priceForChild) {
        this.priceForChild = priceForChild;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }


    public int getNumberOfTripsAvailable() {
        return numberOfTripsAvailable;
    }

    public void setNumberOfTripsAvailable(int numberOfTripsAvailable) {
        this.numberOfTripsAvailable = numberOfTripsAvailable;
    }


    @Override
    public String toString() {
        return "TripDTO: " + name + ", staying Hotels:" + stayingHotel + ", meal type='" + mealType +
                ", departure date:" + departureDate + departureFlight + ", return date:" + returnDate +
                returningFlight + ", number of days=" + numberOfDays + ", promoted:" + promoted +
                ", price for adult=" + priceForAdult + ", price for child=" + priceForChild +
                ", number of adults=" + numberOfAdults + ", number of children=" + numberOfChildren +
                ", number of trips available: " + numberOfTripsAvailable;
    }
}
