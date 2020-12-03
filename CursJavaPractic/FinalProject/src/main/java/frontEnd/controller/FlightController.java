package frontEnd.controller;

import business.dto.FlightDTO;
import business.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class FlightController {
    @Autowired
    FlightService flightService;

    @PostMapping(path = "/insertFlight")
    public ResponseEntity insertFlight(@RequestBody @Valid FlightDTO flightDTO){
        if(flightService.countFlightNumber(flightDTO.getFlightNumber())!=0){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(flightDTO.getFlightNumber() + " already in database.");
        }
        flightService.insertFlight(flightDTO);
        return ResponseEntity.ok(flightDTO.getFlightNumber() + " added.");
    }


}
