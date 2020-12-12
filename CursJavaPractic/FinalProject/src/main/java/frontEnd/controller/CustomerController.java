package frontEnd.controller;

import business.dto.CustomerDTO;
import business.dto.PurchasedTripDTO;
import business.dto.TripDTO;
import business.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import persistence.entities.Trip;

import javax.validation.Valid;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    AccountService accountService;
    @Autowired
    TripService tripService;
    @Autowired
    FlightService flightService;
    @Autowired
    PurchasedTripService purchasedTripService;


    @PostMapping(path = "/insertCustomer")
    public ResponseEntity insertCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        customerDTO.getAccountDTO().setPassword(accountService.cryptPass(customerDTO.getAccountDTO().getPassword()));

        if (accountService.countUserName(customerDTO.getAccountDTO().getUserName()) != 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("This user_name already registered.");
        } else if (customerService.countEmail(customerDTO.getEmail()) != 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("This email already registered.");
        }
        customerService.insertCustomerDTO(customerDTO);
        return ResponseEntity.ok("Customer added.");
    }

    @PutMapping(path = "/logOut")
    public ResponseEntity logOut(@RequestParam String userName) {
        int result = accountService.updateUserLogIn(false, userName);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userName + " can't find an account with this user name.");
        }
        return ResponseEntity.ok(userName + " logged out successfully.");
    }


    @PutMapping(path = "/logIn")
    public ResponseEntity logIn(@RequestParam String userName, String password) {
        String cryptedPassword = accountService.cryptPass(password);
        if (customerService.findCustomerAccount(userName, cryptedPassword) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong input for 'UserName' or 'password'!");
        }
        if (cryptedPassword.equals(accountService.checkRegistration(userName, cryptedPassword))) {
            accountService.updateUserLogIn(true, userName);
            return ResponseEntity.ok(userName + " logged in successfully.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping(path = "/findCustomerByEmail")
    public ResponseEntity findCustomerByEmail(@RequestParam String email) {
        CustomerDTO customerDTO = customerService.findCustomerByEmail(email);
        if (customerDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find customer with email: " + email);
        }
        return ResponseEntity.ok(customerDTO);
    }


    @GetMapping(path = "/findCustomerAccount")
    public ResponseEntity findCustomerAccount(@RequestParam String userName, String password) {
        String cryptedPassword = accountService.cryptPass(password);
        CustomerDTO customerDTO = customerService.findCustomerAccount(userName, cryptedPassword);
        if (customerDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find account with user name:" + userName);
        }
        return ResponseEntity.ok(customerDTO);
    }


    @PostMapping(path = "/purchaseTrip")
    public ResponseEntity purchaseTrip(@RequestParam String userName,int numberOfAdults,int numberOfChildren,String tripToPurchase) {
        TripDTO tripDTO = tripService.findTripByName(tripToPurchase);
        if (tripDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips with name:" + tripToPurchase);
        }

        CustomerDTO customerDTO = customerService.findCustomerByUserName(userName);
        if(customerDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customer with user name: " + userName + " found!");
        }
        if(!customerDTO.getAccountDTO().isLoggedIn()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not logged in.");
        }

        tripDTO.setNumberOfAdults(numberOfAdults);
        tripDTO.setNumberOfChildren(numberOfChildren);
        if(!flightService.checkAvailability((tripDTO.getNumberOfAdults()+tripDTO.getNumberOfChildren()), tripDTO.getDepartureFlightDTO().getSeatsAvailable())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No seats available for departure flight.");
        }

        if(!flightService.checkAvailability((tripDTO.getNumberOfAdults()+tripDTO.getNumberOfChildren()), tripDTO.getReturningFlightDTO().getSeatsAvailable())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No seats available for returning flight.");
        }

        PurchasedTripDTO purchasedTripDTO = new PurchasedTripDTO();
        purchasedTripDTO.setCustomerDTO(customerDTO);
        purchasedTripDTO.setTripDTO(tripDTO);

        purchasedTripService.insertPurchasedTrip(purchasedTripDTO);
        return ResponseEntity.ok("Trip purchased.");
    }

}
