package frontEnd.controller;

import business.dto.PurchasedTripDTO;
import business.dto.TripDTO;
import business.service.PurchasedTripService;
import business.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/trip")
public class TripController {

    @Autowired
    TripService tripService;
    @Autowired
    PurchasedTripService purchasedTripService;


    @GetMapping(path = "/findAll")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findAllTrips() {
        List<TripDTO> tripDTOList = tripService.findAllTrips();
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found in database. ");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @PostMapping(path = "/insert")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity insertTrip(@RequestBody @Valid TripDTO trip) {
        long result = tripService.countTrips(trip.getName(), trip.getDepartureDate());
        if (result != 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(trip.getName() + " already added for date: " + trip.getDepartureDate());
        }
        tripService.insertTrip(trip);
        return ResponseEntity.ok(trip.getName() + " added.");
    }

    @DeleteMapping(path = "/deleteByName")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity deleteTripsByName(@RequestParam String name) {
        int result = tripService.deleteTripsByName(name);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find a trip by the name: " + name);
        }
        tripService.deleteTripsByName(name);
        return ResponseEntity.ok(name + " deleted.");
    }

    @GetMapping(path = "/findPromoted")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findPromotedTrips(@RequestParam boolean promoted) {
        List<TripDTO> tripDTOList = tripService.findPromotedTrips(promoted);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found.");
        }
        return ResponseEntity.ok(tripDTOList);
    }

    @GetMapping(path = "/findByDepartureContinent")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByDepartureContinent(@RequestParam String continentName) {
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureContinent(continentName);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found departing from Continent: " + continentName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByArrivingContinent")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByArrivingContinent(@RequestParam String continentName) {
        List<TripDTO> tripDTOList = tripService.findTripsByArrivingContinent(continentName);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found arriving on Continent: " + continentName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByDepartureCountry")
 //   @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByDepartureCountry(@RequestParam String countryName) {
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureCountry(countryName);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found departing from Country: " + countryName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByArrivingCountry")
 //   @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByArrivingCountry(@RequestParam String countryName) {
        List<TripDTO> tripDTOList = tripService.findTripsByArrivingCountry(countryName);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found arriving in Country: " + countryName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByDepartureCity")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByDepartureCity(@RequestParam String cityName) {
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureCity(cityName);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found departing from City: " + cityName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByArrivingCity")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByArrivingCity(@RequestParam String cityName) {
        List<TripDTO> tripDTOList = tripService.findTripsByArrivingCity(cityName);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found arriving in City: " + cityName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByHotel")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByHotel(@RequestParam String hotelName) {
        List<TripDTO> tripDTOList = tripService.findTripsByHotel(hotelName);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with staying hotel: " + hotelName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByDepartureAirport")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByDepartureAirport(@RequestParam String airportName) {
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureAirport(airportName);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found departing from airport: " + airportName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }

    @GetMapping(path = "/findByArrivingAirport")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByArrivingAirport(@RequestParam String airportName) {
        List<TripDTO> tripDTOList = tripService.findTripsByArrivingAirport(airportName);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found arriving at airport: " + airportName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByDepartureDate")
   //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByDepartureDate(@RequestParam Date departureDate) {
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureDate(departureDate);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with departing date: " + departureDate + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByReturnDate")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByReturnDate(@RequestParam Date returnDate) {
        List<TripDTO> tripDTOList = tripService.findTripsByReturnDate(returnDate);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with returning date: " + returnDate + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByDepartureTimeFrame")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByDepartureTimeFrame(@RequestParam Date beginTimeFrame, Date endTimeFrame) {
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureTimeFrame(beginTimeFrame, endTimeFrame);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found departing between date: " + beginTimeFrame + ", " + endTimeFrame + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByReturnTimeFrame")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByReturnTimeFrame(@RequestParam Date beginTimeFrame, Date endTimeFrame) {
        List<TripDTO> tripDTOList = tripService.findTripsByReturnTimeFrame(beginTimeFrame, endTimeFrame);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found returning between date: " + beginTimeFrame + ", " + endTimeFrame + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByMealType")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByMealType(@RequestParam String mealType) {
        List<TripDTO> tripDTOList = tripService.findTripsByMealType(mealType);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with meal type: " + mealType + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }

    @GetMapping(path = "/findByHotelStars")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByHotelStars(@RequestParam double numberOfStars) {
        List<TripDTO> tripDTOList = tripService.findTripsByHotelStars(numberOfStars);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found were hotel has: " + numberOfStars + " stars.");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByNumberOfDays")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByNumberOfDays(@RequestParam int numberOfDays) {
        List<TripDTO> tripDTOList = tripService.findTripsByNumberOfDays(numberOfDays);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with: " + numberOfDays + " number of days.");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByNameAndDepartureDate")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripByNameAndDepartureDate(@RequestParam String name, Date departureDate) {
        TripDTO tripDTOList = tripService.findTripByNameAndDepartureDate(name, departureDate);
        if (tripDTOList == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with name: " + name + ",on this date:" + departureDate + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findByName")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity findTripsByName(@RequestParam String name) {
        List<TripDTO> tripDTOList = tripService.findTripsByName(name);
        if (tripDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with name: " + name + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping("/showPurchasedTripsByCustomer")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity showPurchasedTripsByCustomer(@RequestParam String name){
        List<PurchasedTripDTO> purchasedTripDTOList = purchasedTripService.showPurchasedTrips(name);
        if(purchasedTripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips purchased recently.");
        }
        return ResponseEntity.ok(purchasedTripDTOList);
    }



    @GetMapping("/showPurchasedTripsByDate")
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity showPurchasedTripsByDate(@RequestParam Date date){
        List<PurchasedTripDTO> purchasedTripDTOList = purchasedTripService.showPurchasedTripsByDate(date);
        if(purchasedTripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips purchased recently.");
        }
        return ResponseEntity.ok(purchasedTripDTOList);
    }



}
