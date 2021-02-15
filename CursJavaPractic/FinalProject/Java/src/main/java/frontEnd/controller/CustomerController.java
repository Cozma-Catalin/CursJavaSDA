package frontEnd.controller;

import business.dto.*;
import business.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
@CrossOrigin
@RestController
@RequestMapping(path = "/api/customer")
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
    @Autowired
    RoomService roomService;


    @PostMapping(path = "/insert")
    public ResponseEntity insertCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        customerDTO.getAccount().setPassword(accountService.cryptPass(customerDTO.getAccount().getPassword()));

        if (accountService.countUserName(customerDTO.getAccount().getUserName()) != 0) {
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

    @GetMapping(path = "/findByEmail")
    public ResponseEntity findCustomerByEmail(@RequestParam String email) {
        CustomerDTO customerDTO = customerService.findCustomerByEmail(email);
        if (customerDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find customer with email: " + email);
        }
        return ResponseEntity.ok(customerDTO);
    }

    @GetMapping(path = "/checkEmail")
    public ResponseEntity checkEmail(@RequestParam String email) {
        CustomerDTO customerDTO = customerService.findCustomerByEmail(email);
        if (customerDTO != null) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body( email + " already registered.");
        }else {
            return ResponseEntity.ok(email + " is available.");
        }
    }


    @GetMapping(path = "/findAccount")
    public ResponseEntity findCustomerAccount(@RequestParam String userName, String password) {
        String cryptedPassword = accountService.cryptPass(password);
        CustomerDTO customerDTO = customerService.findCustomerAccount(userName, cryptedPassword);
        if (customerDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find account with user name:" + userName);
        }
        return ResponseEntity.ok(customerDTO);
    }


    @GetMapping(path = "/checkUserName")
    public ResponseEntity checkUserName(@RequestParam String userName) {
        CustomerDTO customerDTO = customerService.findCustomerByUserName(userName);
        if (customerDTO != null) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body( userName + " already used." );
        }else {
            return ResponseEntity.ok(userName + " is available.");
        }
    }


    @PostMapping(path = "/purchaseTrip")
    public ResponseEntity purchaseTrip(@RequestParam String userName, String tripToPurchase, int numberOfAdults, int numberOfChildren, int singleRooms, int doubleRooms) {
        TripDTO tripDTO = tripService.findTripByName(tripToPurchase);
        if (tripDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips with name:" + tripToPurchase);
        }

        CustomerDTO customerDTO = customerService.findCustomerByUserName(userName);
        if (customerDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customer with user name: " + userName + " found!");
        }
        if (!customerDTO.getAccount().isLoggedIn()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not logged in!");
        }
        if (!tripService.checkAvailability(tripDTO)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Trip sold out!");
        }

        tripDTO.setNumberOfAdults(numberOfAdults);
        tripDTO.setNumberOfChildren(numberOfChildren);
        if (!flightService.checkAvailability((tripDTO.getNumberOfAdults() + tripDTO.getNumberOfChildren()), tripDTO.getDepartureFlight().getSeatsAvailable())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No seats available for departure flight!");
        }

        if (!flightService.checkAvailability((tripDTO.getNumberOfAdults() + tripDTO.getNumberOfChildren()), tripDTO.getReturningFlight().getSeatsAvailable())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No seats available for returning flight!");
        }

        if (!tripService.checkSingleRoomAvailability(tripDTO, singleRooms)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No single rooms available!");
        }

        if (!tripService.checkDoubleRoomAvailability(tripDTO, doubleRooms)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No double rooms available!");
        }

        Set<RoomDTO> roomDTOSet = new HashSet<>();
        RoomDTO singleRoomDTO = roomService.findRoomByType("single");
        roomDTOSet.add(singleRoomDTO);
        RoomDTO doubleRoomDTO = roomService.findRoomByType("double");
        roomDTOSet.add(doubleRoomDTO);

        PurchasedTripDTO purchasedTripDTO = new PurchasedTripDTO();
        purchasedTripDTO.setCustomer(customerDTO);
        purchasedTripDTO.setTrip(tripDTO);
        purchasedTripDTO.getTrip().getStayingHotel().setRooms(roomDTOSet);
        purchasedTripDTO.setTotalPrice((singleRoomDTO.getPrice() * singleRooms)+(doubleRoomDTO.getPrice() * doubleRooms));

        purchasedTripService.insertPurchasedTrip(purchasedTripDTO);

        roomService.updateRoomAvailability(singleRoomDTO.getRoomType(), (singleRoomDTO.getRoomsAvailable() - singleRooms));
        roomService.updateRoomAvailability(doubleRoomDTO.getRoomType(), (doubleRoomDTO.getRoomsAvailable() - doubleRooms));
        return ResponseEntity.ok("Trip purchased.");
    }

}
