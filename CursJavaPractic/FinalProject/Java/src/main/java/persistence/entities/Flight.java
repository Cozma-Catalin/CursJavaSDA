package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NamedQueries({
        @NamedQuery(name = "findFlightByFlightNumber",query = "select flight from Flight flight where flightNumber= :flightNumber"),
        @NamedQuery(name = "countFlightNumber",query = "select count(flightNumber) from Flight where flightNumber= :flightNumber"),
        @NamedQuery(name = "updateSeatsAvailable",query = "update from Flight set seatsAvailable= seatsAvailable - :numberOfPersons where flightNumber= :flightNumber")
})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "departure_time")
    private Timestamp departureTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_airport")
    private Airport departureAirport;

    @Column(name = "arriving_date")
    private Date arrivingDate;

    @Column(name = "arriving_time")
    private Timestamp arrivingTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arriving_airport")
    private Airport arrivingAirport;

    @Column(name = "price")
    private double price;

    @Column(name = "seats_available")
    private int seatsAvailable;



}
