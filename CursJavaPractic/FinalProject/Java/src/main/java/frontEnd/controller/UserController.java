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
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TripService tripService;
    @Autowired
    FlightService flightService;
    @Autowired
    PurchasedTripService purchasedTripService;
    @Autowired
    RoomService roomService;


    @PostMapping(path = "/insert")
 //   @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity insert(@RequestBody @Valid UserDTO userDTO) {
        userDTO.setPassword(userService.cryptPass(userDTO.getPassword()));

        if (userService.countEmail(userDTO.getEmail()) != 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("This email already registered.");
        }
        userService.insertUserDTO(userDTO);
        return ResponseEntity.ok("User added.");
    }


    @PutMapping(path = "/logOut")
    public ResponseEntity logOut(@RequestParam String email) {
        int result = userService.updateUserLogIn(false, email);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find an account with this email '" + email + "'.");
        }
        return ResponseEntity.ok("Logged out successfully.");
    }


    @PutMapping(path = "/logIn")
    public ResponseEntity logIn(@RequestParam String email, String password) {
        String cryptedPassword = userService.cryptPass(password);
        if (userService.findUserByEmail(email) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong input for email!");
        }
        if (!cryptedPassword.equals(userService.checkRegistration(email, cryptedPassword))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong password!");
        }
        userService.updateUserLogIn(true, email);
        UserDTO userDTO = userService.findUserAccount(email, cryptedPassword);
        return ResponseEntity.ok("Logged in successfully." + userDTO);
    }

    @GetMapping(path = "/findByEmail")
 //   @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findByEmail(@RequestParam String email) {
        UserDTO userDTO = userService.findUserByEmail(email);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find user with email: " + email);
        }
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping(path = "/checkEmail")
    public ResponseEntity checkEmail(@RequestParam String email) {
        UserDTO userDTO = userService.findUserByEmail(email);
        if (userDTO != null) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body( email + " already registered.");
        }else {
            return ResponseEntity.ok(email + " is available.");
        }
    }


    @GetMapping(path = "/findUserAccount")
    public ResponseEntity findCustomerAccount(@RequestParam String email, String password) {
        String cryptedPassword = userService.cryptPass(password);
        UserDTO userDTO = userService.findUserAccount(email, cryptedPassword);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find account with email:" + email);
        }
        return ResponseEntity.ok(userDTO);
    }



    @PostMapping(path = "/purchaseTrip")
    public ResponseEntity purchaseTrip(@RequestParam String email, String tripToPurchase, int numberOfAdults, int numberOfChildren, int singleRooms, int doubleRooms) {
        TripDTO tripDTO = tripService.findTripByName(tripToPurchase);
        if (tripDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips with name:" + tripToPurchase);
        }

        UserDTO userDTO = userService.findUserByEmail(email);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user with email: " + email + " found!");
        }
        if (!userDTO.isLoggedIn()) {
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
        purchasedTripDTO.setUser(userDTO);
        purchasedTripDTO.setTrip(tripDTO);
        purchasedTripDTO.getTrip().getStayingHotel().setRooms(roomDTOSet);
        purchasedTripDTO.setTotalPrice((singleRoomDTO.getPrice() * singleRooms)+(doubleRoomDTO.getPrice() * doubleRooms));

        purchasedTripService.insertPurchasedTrip(purchasedTripDTO);

        roomService.updateRoomAvailability(singleRoomDTO.getRoomType(), (singleRoomDTO.getRoomsAvailable() - singleRooms));
        roomService.updateRoomAvailability(doubleRoomDTO.getRoomType(), (doubleRoomDTO.getRoomsAvailable() - doubleRooms));
        return ResponseEntity.ok("Trip purchased.");
    }

}
