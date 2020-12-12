package business.service;

import business.dto.PurchasedTripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CustomerDAO;
import persistence.dao.FlightDAO;
import persistence.dao.PurchasedTripDAO;
import persistence.dao.TripDAO;
import persistence.entities.PurchasedTrip;

import java.sql.Date;
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
    CustomerService customerService;
    @Autowired
    FlightDAO flightDAO;


    public void insertPurchasedTrip(PurchasedTripDTO purchasedTripDTO){
        PurchasedTrip purchasedTrip = new PurchasedTrip();
        purchasedTrip.setCustomer(customerDAO.findCustomerByEmail(purchasedTripDTO.getCustomerDTO().getEmail()));
        purchasedTrip.setTrip(tripDAO.findTripByName(purchasedTripDTO.getTripDTO().getName()));

        Calendar calendar = Calendar.getInstance();
        java.util.Date dateUtil = calendar.getTime();
        java.sql.Date dateOfPurchase = new Date(dateUtil.getTime());
        purchasedTrip.setDateOfPurchase(dateOfPurchase);

        purchasedTrip.setTotalPrice(customerService.calculateTripsPrice(purchasedTripDTO.getTripDTO(),purchasedTrip.getTrip()));
        purchasedTripDAO.insertPurchasedTrip(purchasedTrip);

        tripDAO.updateNumberOfTripsAvailable();
        flightDAO.updateSeatsAvailable((purchasedTripDTO.getTripDTO().getNumberOfAdults() + purchasedTripDTO.getTripDTO().getNumberOfChildren()), purchasedTrip.getTrip().getDepartureFlight().getFlightNumber());
        flightDAO.updateSeatsAvailable((purchasedTripDTO.getTripDTO().getNumberOfAdults() + purchasedTripDTO.getTripDTO().getNumberOfChildren()), purchasedTrip.getTrip().getReturningFlight().getFlightNumber());

    }

}
