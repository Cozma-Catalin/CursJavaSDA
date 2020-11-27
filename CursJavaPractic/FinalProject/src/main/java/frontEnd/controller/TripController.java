package frontEnd.controller;

import business.dto.TripDTO;
import business.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TripController {

    @Autowired
    TripService tripService;

    @PostMapping(path = "/insertTrip")
    public ResponseEntity insertTrip(@RequestBody @Valid TripDTO tripDTO){
        tripService.insertTrip(tripDTO);
        return ResponseEntity.ok(tripDTO.getName() + " added.");
    }

}
