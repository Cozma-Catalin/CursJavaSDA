package persistence.entities;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "countTrips", query = "select count(name) from Trip trip where trip.name= :name and trip.departureDate= :departureDate"),
        @NamedQuery(name = "deleteTripsByName",query = "delete from Trip where name= :name"),
        @NamedQuery(name = "findPromotedTrips",query = "select trip from Trip trip where promoted= :promoted")

})

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_flight")
    private Flight departureFlight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "returning_flight")
    private Flight returningFlight;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "staying_hotel")
    private Hotel stayingHotel;

    @Column(name = "meal_type")
    private String mealType;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "number_of_days")
    private int numberOfDays;

    @Column(name = "promoted")
    private boolean promoted;

    @Column(name = "price_for_adults")
    private double priceForAdult;

    @Column(name = "price_for_child")
    private double priceForChild;

    @Column(name = "number_of_adults")
    private int numberOfAdults;

    @Column(name = "number_of_children")
    private int numberOfChildren;

    @Column(name = "trip_price")
    private double tripsPrice;

    @Column(name = "number_of_trips_available")
    private int numberOfTripsAvailable;


    public Trip(String name, Flight departureFlight, Flight returningFlight, Hotel stayingHotel, String mealType, Date departureDate,
                Date returnDate, int numberOfDays, boolean promoted, double priceForAdult, double priceForChild,
                int numberOfAdults, int numberOfChildren, double tripsPrice, int numberOfTripsAvailable) {
        this.name = name;
        this.departureFlight = departureFlight;
        this.returningFlight = returningFlight;
        this.stayingHotel = stayingHotel;
        this.mealType = mealType;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfDays = numberOfDays;
        this.promoted = promoted;
        this.priceForAdult = priceForAdult;
        this.priceForChild = priceForChild;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.tripsPrice = tripsPrice;
        this.numberOfTripsAvailable = numberOfTripsAvailable;
    }

    public Trip() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flight getDepartureFlight() {
        return departureFlight;
    }

    public void setDepartureFlight(Flight departureFlight) {
        this.departureFlight = departureFlight;
    }

    public Flight getReturningFlight() {
        return returningFlight;
    }

    public void setReturningFlight(Flight returningFlight) {
        this.returningFlight = returningFlight;
    }

    public Hotel getStayingHotel() {
        return stayingHotel;
    }

    public void setStayingHotel(Hotel stayingHotel) {
        this.stayingHotel = stayingHotel;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
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
        return "Trip: " + name + "departure flight: " + departureFlight + " returning flight: " + returningFlight
                + ", staying Hotel:" + stayingHotel + ", meal type:" + mealType + ", departure date:" + departureDate
                + ", return date:" + returnDate + ", number of days:" + numberOfDays + ", promoted:" + promoted
                + ", price for adult:" + priceForAdult + ", price for child:" + priceForChild
                + ", number of adults:" + numberOfAdults + ", number of children:" + numberOfChildren
                + ", trips price:" + tripsPrice + ", number of trips available: " + numberOfTripsAvailable;
    }
}
