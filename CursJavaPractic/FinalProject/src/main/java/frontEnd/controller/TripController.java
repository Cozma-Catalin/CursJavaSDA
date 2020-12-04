package frontEnd.controller;

import business.dto.TripDTO;
import business.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
public class TripController {

    @Autowired
    TripService tripService;

    @PostMapping(path = "/insertTrip")
    public ResponseEntity insertTrip(@RequestBody @Valid TripDTO tripDTO){
        long result = tripService.countTrips(tripDTO.getName(),tripDTO.getDepartureDate());
        if(result !=0){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(tripDTO.getName() + " already added for date: " + tripDTO.getDepartureDate());
        }
        tripService.insertTrip(tripDTO);
        return ResponseEntity.ok(tripDTO.getName() + " added.");
    }

    @DeleteMapping(path = "/deleteTripsByName")
    public ResponseEntity deleteTripsByName(@RequestParam String name){
        int result = tripService.deleteTripsByName(name);
        if(result == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find a trip by the name: " + name);
        }
        tripService.deleteTripsByName(name);
        return ResponseEntity.ok(name + " deleted.");
    }

    @GetMapping(path = "/findPromotedTrips")
    public ResponseEntity findPromotedTrips(@RequestParam boolean promoted){
        List<TripDTO> tripDTOList = tripService.findPromotedTrips(promoted);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found.");
        }
        return ResponseEntity.ok(tripDTOList);
    }

    @GetMapping(path = "/findTripsByDepartureContinent")
    public ResponseEntity findTripsByDepartureContinent(@RequestParam String continentName){
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureContinent(continentName);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found departing from Continent: " + continentName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByArrivingContinent")
    public ResponseEntity findTripsByArrivingContinent(@RequestParam String continentName){
        List<TripDTO> tripDTOList = tripService.findTripsByArrivingContinent(continentName);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found arriving on Continent: " + continentName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }



    @GetMapping(path = "/findTripsByDepartureCountry")
    public ResponseEntity findTripsByDepartureCountry(@RequestParam String countryName){
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureCountry(countryName);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found departing from Country: " + countryName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByArrivingCountry")
    public ResponseEntity findTripsByArrivingCountry(@RequestParam String countryName){
        List<TripDTO> tripDTOList = tripService.findTripsByArrivingCountry(countryName);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found arriving in Country: " + countryName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByDepartureCity")
    public ResponseEntity findTripsByDepartureCity(@RequestParam String cityName){
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureCity(cityName);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found departing from City: " + cityName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByArrivingCity")
    public ResponseEntity findTripsByArrivingCity(@RequestParam String cityName){
        List<TripDTO> tripDTOList = tripService.findTripsByArrivingCity(cityName);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found arriving in City: " + cityName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByHotel")
    public ResponseEntity findTripsByHotel(@RequestParam String hotelName){
        List<TripDTO> tripDTOList = tripService.findTripsByHotel(hotelName);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with staying hotel: " + hotelName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByDepartureAirport")
    public ResponseEntity findTripsByDepartureAirport(@RequestParam String airportName){
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureAirport(airportName);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found departing from airport: " + airportName + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByDepartureDate")
    public ResponseEntity findTripsByDepartureDate(@RequestParam Date departureDate){
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureDate(departureDate);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with departing date: " + departureDate + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByReturnDate")
    public ResponseEntity findTripsByReturnDate(@RequestParam Date returnDate){
        List<TripDTO> tripDTOList = tripService.findTripsByReturnDate(returnDate);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with returning date: " + returnDate + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByDepartureTimeFrame")
    public ResponseEntity findTripsByDepartureTimeFrame(@RequestParam Date departureDate,Date returnDate){
        List<TripDTO> tripDTOList = tripService.findTripsByDepartureTimeFrame(departureDate,returnDate);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found departing between date: " + departureDate + ", " + returnDate + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByReturnTimeFrame")
    public ResponseEntity findTripsByReturnTimeFrame(@RequestParam Date departureDate,Date returnDate){
        List<TripDTO> tripDTOList = tripService.findTripsByReturnTimeFrame(departureDate,returnDate);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found returning between date: " + departureDate + ", " + returnDate + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByMealType")
    public ResponseEntity findTripsByMealType(@RequestParam String mealType){
        List<TripDTO> tripDTOList = tripService.findTripsByMealType(mealType);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with meal type: " + mealType + ".");
        }
        return ResponseEntity.ok(tripDTOList);
    }

    @GetMapping(path = "/findTripsByHotelStars")
    public ResponseEntity findTripsByHotelStars(@RequestParam double numberOfStars){
        List<TripDTO> tripDTOList = tripService.findTripsByHotelStars(numberOfStars);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found were hotel has: " + numberOfStars + " stars.");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findTripsByNumberOfDays")
    public ResponseEntity findTripsByNumberOfDays(@RequestParam int numberOfDays){
        List<TripDTO> tripDTOList = tripService.findTripsByNumberOfDays(numberOfDays);
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found with: " + numberOfDays + " number of days.");
        }
        return ResponseEntity.ok(tripDTOList);
    }


    @GetMapping(path = "/findAllTrips")
    public ResponseEntity findAllTrips(){
        List<TripDTO> tripDTOList = tripService.findAllTrips();
        if(tripDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No trips found in database. ");
        }
        return ResponseEntity.ok(tripDTOList);
    }

}
