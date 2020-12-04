package business.dto;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;


public class TripDTO {
    @NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z A-Z])*")
    private String name;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date departureDate;
    @Valid
    private FlightDTO departureFlightDTO;
    @NotNull
    private Date returnDate;
    @Valid
    private FlightDTO returningFlightDTO;
    @Valid
    private HotelDTO stayingHotelDTO;
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
    private double tripsPrice;
    @NotNull
    private int numberOfTripsAvailable;

    public TripDTO(String name, HotelDTO stayingHotelDTO, String mealType, java.sql.Date departureDate,
                   FlightDTO departureFlightDTO, Date returnDate,FlightDTO returningFlightDTO,
                   int numberOfDays, boolean promoted, double priceForAdult, double priceForChild, int numberOfAdults,
                   int numberOfChildren, double tripsPrice, int numberOfTripsAvailable) {
        this.name = name;
        this.stayingHotelDTO = stayingHotelDTO;
        this.mealType = mealType;
        this.departureDate = departureDate;
        this.departureFlightDTO = departureFlightDTO;
        this.returnDate = returnDate;
        this.returningFlightDTO = returningFlightDTO;
        this.numberOfDays = numberOfDays;
        this.promoted = promoted;
        this.priceForAdult = priceForAdult;
        this.priceForChild = priceForChild;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.tripsPrice = tripsPrice;
        this.numberOfTripsAvailable = numberOfTripsAvailable;
    }

    public TripDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HotelDTO getStayingHotelDTO() {
        return stayingHotelDTO;
    }

    public void setStayingHotelDTO(HotelDTO stayingHotelDTO) {
        this.stayingHotelDTO = stayingHotelDTO;
    }

    public FlightDTO getDepartureFlightDTO() {
        return departureFlightDTO;
    }

    public void setDepartureFlightDTO(FlightDTO departureFlightDTO) {
        this.departureFlightDTO = departureFlightDTO;
    }

    public FlightDTO getReturningFlightDTO() {
        return returningFlightDTO;
    }

    public void setReturningFlightDTO(FlightDTO returningFlightDTO) {
        this.returningFlightDTO = returningFlightDTO;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
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

    public double getTripsPrice() {
        return tripsPrice;
    }

    public void setTripsPrice(double tripsPrice) {
        this.tripsPrice = tripsPrice;
    }

    public int getNumberOfTripsAvailable() {
        return numberOfTripsAvailable;
    }

    public void setNumberOfTripsAvailable(int numberOfTripsAvailable) {
        this.numberOfTripsAvailable = numberOfTripsAvailable;
    }

    @Override
    public String toString() {
        return "TripDTO: " + name + ", staying Hotels:" + stayingHotelDTO + ", meal type='" + mealType +
                ", departure date:" + departureDate + departureFlightDTO + ", return date:" + returnDate +
                returningFlightDTO + ", number of days=" + numberOfDays + ", promoted:" + promoted +
                ", price for adult=" + priceForAdult + ", price for child=" + priceForChild +
                ", number of adults=" + numberOfAdults + ", number of children=" + numberOfChildren +
                ", trips price=" + tripsPrice + ", number of trips available: " + numberOfTripsAvailable;
    }
}
