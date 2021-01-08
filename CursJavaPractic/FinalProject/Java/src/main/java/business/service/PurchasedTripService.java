package business.service;

import business.dto.CustomerDTO;
import business.dto.PurchasedTripDTO;
import business.dto.TripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    CustomerDAO customerDAO;
    @Autowired
    TripDAO tripDAO;
    @Autowired
    FlightDAO flightDAO;
    @Autowired
    TripService tripService;
    @Autowired
    CustomerService customerService;


    public void insertPurchasedTrip(PurchasedTripDTO purchasedTripDTO) {
        PurchasedTrip purchasedTrip = new PurchasedTrip();
        purchasedTrip.setCustomer(customerDAO.findCustomerByEmail(purchasedTripDTO.getCustomerDTO().getEmail()));
        purchasedTrip.setTrip(tripDAO.findTripByName(purchasedTripDTO.getTripDTO().getName()));


        Calendar calendar = Calendar.getInstance();
        java.util.Date dateUtil = calendar.getTime();
        java.sql.Date dateOfPurchase = new Date(dateUtil.getTime());
        purchasedTrip.setDateOfPurchase(dateOfPurchase);

        purchasedTrip.setTotalPrice(calculateTripsPrice(purchasedTripDTO, purchasedTrip.getTrip()));
        applyDiscount(purchasedTrip);
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
            purchasedTripDTO.setTripDTO(tripDTO);
            CustomerDTO customerDTO = customerService.findCustomerByEmail(p.getCustomer().getEmail());
            purchasedTripDTO.setCustomerDTO(customerDTO);
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
            purchasedTripDTO.setTripDTO(tripDTO);
            CustomerDTO customerDTO = customerService.findCustomerByEmail(p.getCustomer().getEmail());
            purchasedTripDTO.setCustomerDTO(customerDTO);
            purchasedTripDTOList.add(purchasedTripDTO);
        }
        return purchasedTripDTOList;
    }

}
