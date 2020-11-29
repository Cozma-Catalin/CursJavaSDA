package persistence.entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "findFlightByFlightNumber",query = "select flight from Flight flight where flightNumber= :flightNumber")
})


@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "departure_date_and_time")
    private String departureDateAndTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_airport")
    private Airport departureAirport;

    @Column(name = "arriving_date_and_time")
    private String arrivingDateAndTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arriving_airport")
    private Airport arrivingAirport;

    @Column(name = "price")
    private double price;

    @Column(name = "seats_available")
    private int seatsAvailable;



    public Flight(String flightNumber, String departureDateAndTime, Airport departureAirport,
                  String arrivingDateAndTime, Airport arrivingAirport, double price, int seatsAvailable) {
        this.flightNumber = flightNumber;
        this.departureDateAndTime = departureDateAndTime;
        this.departureAirport = departureAirport;
        this.arrivingDateAndTime = arrivingDateAndTime;
        this.arrivingAirport = arrivingAirport;
        this.price = price;
        this.seatsAvailable = seatsAvailable;
    }

    public Flight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getArrivingDateAndTime() {
        return arrivingDateAndTime;
    }

    public void setArrivingDateAndTime(String arrivingDateAndTime) {
        this.arrivingDateAndTime = arrivingDateAndTime;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivingAirport() {
        return arrivingAirport;
    }

    public void setArrivingAirport(Airport arrivingAirport) {
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
        return "Flight: " + flightNumber + "departure date and time: " + departureDateAndTime + ", " +
                ",departing from airport: " + departureAirport + " ,arriving date and time: " + arrivingDateAndTime +
                " arriving in airport: " + arrivingAirport + ", price:" + price +
                ",number of seats available:" + seatsAvailable ;
    }
}
