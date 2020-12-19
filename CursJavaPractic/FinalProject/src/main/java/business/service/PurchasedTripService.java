package business.service;

import business.dto.PurchasedTripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.*;
import persistence.entities.PurchasedTrip;
import persistence.entities.Trip;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

@Service
public class PurchasedTripService {
    @Autowired
    PurchasedTripDAO purchasedTripDAO;
    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    TripDAO tripDAO;
    @Autowired
    FlightDAO flightDAO;


    public void insertPurchasedTrip(PurchasedTripDTO purchasedTripDTO) {
        PurchasedTrip purchasedTrip = new PurchasedTrip();
        purchasedTrip.setCustomer(customerDAO.findCustomerByEmail(purchasedTripDTO.getCustomerDTO().getEmail()));
        purchasedTrip.setTrip(tripDAO.findTripByName(purchasedTripDTO.getTripDTO().getName()));


        LocalDateTime dateOfPurchase = LocalDateTime.now();
        purchasedTrip.setDateOfPurchase(dateOfPurchase);

        purchasedTrip.setTotalPrice(calculateTripsPrice(purchasedTripDTO, purchasedTrip.getTrip()));
        purchasedTripDAO.insertPurchasedTrip(purchasedTrip);

        tripDAO.updateNumberOfTripsAvailable();
        flightDAO.updateSeatsAvailable((purchasedTripDTO.getTripDTO().getNumberOfAdults() + purchasedTripDTO.getTripDTO().getNumberOfChildren()), purchasedTrip.getTrip().getDepartureFlight().getFlightNumber());
        flightDAO.updateSeatsAvailable((purchasedTripDTO.getTripDTO().getNumberOfAdults() + purchasedTripDTO.getTripDTO().getNumberOfChildren()), purchasedTrip.getTrip().getReturningFlight().getFlightNumber());

    }

    private double calculateTripsPrice(PurchasedTripDTO purchasedTripDTO, Trip trip) {
        double totalFlightPrice = (trip.getDepartureFlight().getPrice() * (purchasedTripDTO.getTripDTO().getNumberOfAdults() + purchasedTripDTO.getTripDTO().getNumberOfChildren()))
                + (trip.getReturningFlight().getPrice() * (purchasedTripDTO.getTripDTO().getNumberOfAdults() + purchasedTripDTO.getTripDTO().getNumberOfChildren()));

        double totalPrice = purchasedTripDTO.getTotalPrice() + ((trip.getPriceForAdult() * purchasedTripDTO.getTripDTO().getNumberOfAdults() + (trip.getPriceForChild() * purchasedTripDTO.getTripDTO().getNumberOfChildren())) + totalFlightPrice);
        return totalPrice;
    }

}
