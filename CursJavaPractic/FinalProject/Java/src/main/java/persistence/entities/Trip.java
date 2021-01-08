package persistence.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "countTrips", query = "select count(name) from Trip trip where trip.name= :name and trip.departureDate= :departureDate"),
        @NamedQuery(name = "deleteTripsByName", query = "delete from Trip where name= :name "),
        @NamedQuery(name = "findPromotedTrips", query = "select trip from Trip trip where promoted= :promoted"),
        @NamedQuery(name = "findTripsByDepartureContinent", query = "select trip from Trip trip inner join trip.departureFlight departureFlight " +
                "inner join departureFlight.departureAirport departureAirport inner join departureAirport.city city inner join city.country country " +
                "inner join country.continent continent where continent.name= :name"),
        @NamedQuery(name = "findTripsByArrivingContinent", query = "select trip from Trip trip inner join trip.departureFlight departureFlight " +
                "inner join departureFlight.arrivingAirport arrivingAirport inner join arrivingAirport.city city inner join city.country country " +
                "inner join country.continent continent where continent.name= :name"),
        @NamedQuery(name = "findTripsByDepartureCountry", query = "select trip from Trip trip inner join trip.departureFlight departureFlight " +
                "inner join departureFlight.departureAirport departureAirport inner join departureAirport.city city inner join city.country country where country.name= :name"),
        @NamedQuery(name = "findTripsByArrivingCountry", query = "select trip from Trip trip inner join trip.departureFlight departureFlight " +
                "inner join departureFlight.arrivingAirport arrivingAirport inner join arrivingAirport.city city inner join city.country country where country.name= :name"),
        @NamedQuery(name = "findTripsByDepartureCity", query = "select trip from Trip trip inner join trip.departureFlight departureFlight " +
                "inner join departureFlight.departureAirport departureAirport inner join departureAirport.city city where city.name= :name"),
        @NamedQuery(name = "findTripsByArrivingCity", query = "select trip from Trip trip inner join trip.departureFlight departureFlight " +
                "inner join departureFlight.arrivingAirport arrivingAirport inner join arrivingAirport.city city where city.name= :name"),
        @NamedQuery(name = "findTripsByDepartureAirport", query = "select trip from Trip trip inner join trip.departureFlight departureFlight " +
                "inner join departureFlight.departureAirport departureAirport where departureAirport.name= :name"),
        @NamedQuery(name = "findTripsByHotel", query = "select trip from Trip trip inner join trip.stayingHotel stayingHotel where stayingHotel.name= :name"),
        @NamedQuery(name = "findTripsByDepartureDate", query = "select trip from Trip trip where departureDate= :departureDate"),
        @NamedQuery(name = "findTripsByReturnDate", query = "select trip from Trip trip where returnDate= :returnDate"),
        @NamedQuery(name = "findTripsByDepartureTimeFrame", query = "select trip from Trip trip where departureDate>= :beginTimeFrame and departureDate<= :endTimeFrame"),
        @NamedQuery(name = "findTripsByReturnTimeFrame", query = "select trip from Trip trip where returnDate>= :beginTimeFrame and returnDate<= :endTimeFrame"),
        @NamedQuery(name = "findTripsByMealType" ,query = "select trip from Trip trip where mealType= :mealType"),
        @NamedQuery(name = "findTripsByHotelStars" , query = " select trip from Trip trip inner join trip.stayingHotel stayingHotel where stayingHotel.numberOfStars= :numberOfStars"),
        @NamedQuery(name = "findTripsByNumberOfDays",query = "select trip from Trip trip where numberOfDays= :numberOfDays"),
        @NamedQuery(name = "findAllTrips" ,query = "select trip from Trip trip"),
        @NamedQuery(name = "findTripByNameAndDepartureDate",query = "select trip from Trip trip where name= :name and departureDate= :departureDate"),
        @NamedQuery(name = "findTripByName",query = "select trip from Trip trip where name= :name"),
        @NamedQuery(name = "updateNumberOfTripsAvailable",query = "update from Trip set numberOfTripsAvailable= numberOfTripsAvailable - 1")

})

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "departure_date")
    private java.sql.Date departureDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_flight")
    private Flight departureFlight;

    @Column(name = "return_date")
    private Date returnDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "returning_flight")
    private Flight returningFlight;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "staying_hotel")
    private Hotel stayingHotel;

    @Column(name = "meal_type")
    private String mealType;

    @Column(name = "number_of_days")
    private int numberOfDays;

    @Column(name = "promoted")
    private boolean promoted;

    @Column(name = "price_for_adults")
    private double priceForAdult;

    @Column(name = "price_for_child")
    private double priceForChild;


    @Column(name = "number_of_trips_available")
    private int numberOfTripsAvailable;

    @OneToMany(mappedBy = "trip")
    private Set<PurchasedTrip> purchasedTripSet;

    public Trip(String name, Flight departureFlight, Flight returningFlight, Hotel stayingHotel, String mealType, java.sql.Date departureDate,
                Date returnDate, int numberOfDays, boolean promoted, double priceForAdult, double priceForChild, int numberOfTripsAvailable) {
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
                + ", number of trips available: " + numberOfTripsAvailable;
    }
}
