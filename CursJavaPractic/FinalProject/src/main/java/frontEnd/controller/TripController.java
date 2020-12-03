package frontEnd.controller;

import business.dto.TripDTO;
import business.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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

}
