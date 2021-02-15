package frontEnd.controller;

import business.dto.FlightDTO;
import business.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin
@RestController
@RequestMapping(path = "/api/flight")
public class FlightController {
    @Autowired
    FlightService flightService;

    @PostMapping(path = "/insert")
    public ResponseEntity insertFlight(@RequestBody @Valid FlightDTO flightDTO){
        if(flightService.countFlightNumber(flightDTO.getFlightNumber())!=0){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(flightDTO.getFlightNumber() + " already in database.");
        }
        flightService.insertFlight(flightDTO);
        return ResponseEntity.ok(flightDTO.getFlightNumber() + " added.");
    }

    @GetMapping(path = "/findByFlightNumber")
    public ResponseEntity findFlightByFlightNumber(@RequestParam String flightNumber){
        FlightDTO flightDTO = flightService.findFlightByFlightNumber(flightNumber);
        if(flightDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flight found by flight number:" + flightNumber + ".");
        }
        return ResponseEntity.ok(flightDTO);
    }

}
