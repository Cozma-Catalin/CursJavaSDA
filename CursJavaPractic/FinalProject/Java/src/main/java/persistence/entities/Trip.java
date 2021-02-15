package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
        @NamedQuery(name = "findTripsByArrivingAirport", query = "select trip from Trip trip inner join trip.departureFlight departureFlight " +
                "inner join departureFlight.arrivingAirport arrivingAirport where arrivingAirport.name= :name"),
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
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private java.sql.Date returnDate;

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

}
