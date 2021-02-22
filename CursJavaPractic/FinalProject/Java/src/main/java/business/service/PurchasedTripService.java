package business.service;

import business.dto.UserDTO;
import business.dto.PurchasedTripDTO;
import business.dto.TripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.*;
import persistence.entities.PurchasedTrip;
import persistence.entities.Trip;

import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

@Service
public class PurchasedTripService {
    @Autowired
    PurchasedTripDAO purchasedTripDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    TripDAO tripDAO;
    @Autowired
    FlightDAO flightDAO;
    @Autowired
    TripService tripService;
    @Autowired
    UserService userService;


    public void insertPurchasedTrip(PurchasedTripDTO purchasedTripDTO) {
        PurchasedTrip purchasedTrip = new PurchasedTrip();
        purchasedTrip.setUser(userDAO.findUserByEmail(purchasedTripDTO.getUser().getEmail()));
        purchasedTrip.setTrip(tripDAO.findTripByName(purchasedTripDTO.getTrip().getName()));


        Calendar calendar = Calendar.getInstance();
        java.util.Date dateUtil = calendar.getTime();
        java.sql.Date dateOfPurchase = new Date(dateUtil.getTime());
        purchasedTrip.setDateOfPurchase(dateOfPurchase);

        purchasedTrip.setTotalPrice(calculateTripsPrice(purchasedTripDTO, purchasedTrip.getTrip()));
        applyDiscount(purchasedTrip);
        purchasedTripDAO.insertPurchasedTrip(purchasedTrip);

        tripDAO.updateNumberOfTripsAvailable();
        flightDAO.updateSeatsAvailable((purchasedTripDTO.getTrip().getNumberOfAdults() + purchasedTripDTO.getTrip().getNumberOfChildren()), purchasedTrip.getTrip().getDepartureFlight().getFlightNumber());
        flightDAO.updateSeatsAvailable((purchasedTripDTO.getTrip().getNumberOfAdults() + purchasedTripDTO.getTrip().getNumberOfChildren()), purchasedTrip.getTrip().getReturningFlight().getFlightNumber());

    }

    private double calculateTripsPrice(PurchasedTripDTO purchasedTripDTO, Trip trip) {
        double totalFlightPrice = (trip.getDepartureFlight().getPrice() * (purchasedTripDTO.getTrip().getNumberOfAdults() + purchasedTripDTO.getTrip().getNumberOfChildren()))
                + (trip.getReturningFlight().getPrice() * (purchasedTripDTO.getTrip().getNumberOfAdults() + purchasedTripDTO.getTrip().getNumberOfChildren()));

        double totalPrice = purchasedTripDTO.getTotalPrice() + ((trip.getPriceForAdult() * purchasedTripDTO.getTrip().getNumberOfAdults() + (trip.getPriceForChild() * purchasedTripDTO.getTrip().getNumberOfChildren())) + totalFlightPrice);
        return totalPrice;
    }


    private void applyDiscount(PurchasedTrip purchasedTrip) {
        double totalPrice = purchasedTrip.getTotalPrice();
        if (totalPrice > 10000) {
            double discount = 0.1 * totalPrice;
            totalPrice -= discount;
            purchasedTrip.setTotalPrice(totalPrice);
            purchasedTrip.setDiscount(discount);
        } else if (totalPrice > 20000) {
            double discount = 0.2 * totalPrice;
            totalPrice -= discount;
            purchasedTrip.setTotalPrice(totalPrice);
            purchasedTrip.setDiscount(discount);
        }
    }


    public List<PurchasedTripDTO> showPurchasedTrips(String name) {
        List<PurchasedTripDTO> purchasedTripDTOList = new LinkedList<>();

        List<PurchasedTrip> purchasedTrips = purchasedTripDAO.showPurchasedTrips(name);
        for (PurchasedTrip p : purchasedTrips) {
            PurchasedTripDTO purchasedTripDTO = new PurchasedTripDTO();
            purchasedTripDTO.setDateOfPurchase(p.getDateOfPurchase());
            purchasedTripDTO.setTotalPrice(p.getTotalPrice());
            purchasedTripDTO.setDiscount(p.getDiscount());
            TripDTO tripDTO = tripService.findTripByName(p.getTrip().getName());
            purchasedTripDTO.setTrip(tripDTO);
            UserDTO userDTO = userService.findUserByEmail(p.getUser().getEmail());
            purchasedTripDTO.setUser(userDTO);
            purchasedTripDTOList.add(purchasedTripDTO);
        }
        return purchasedTripDTOList;
    }


    public List<PurchasedTripDTO> showPurchasedTripsByDate(Date date) {
        List<PurchasedTripDTO> purchasedTripDTOList = new LinkedList<>();

        List<PurchasedTrip> purchasedTrips = purchasedTripDAO.showPurchasedTripsByDate(date);
        for (PurchasedTrip p : purchasedTrips) {
            PurchasedTripDTO purchasedTripDTO = new PurchasedTripDTO();
            purchasedTripDTO.setDateOfPurchase(p.getDateOfPurchase());
            purchasedTripDTO.setTotalPrice(p.getTotalPrice());
            purchasedTripDTO.setDiscount(p.getDiscount());
            TripDTO tripDTO = tripService.findTripByName(p.getTrip().getName());
            purchasedTripDTO.setTrip(tripDTO);
            UserDTO userDTO = userService.findUserByEmail(p.getUser().getEmail());
            purchasedTripDTO.setUser(userDTO);
            purchasedTripDTOList.add(purchasedTripDTO);
        }
        return purchasedTripDTOList;
    }

}
