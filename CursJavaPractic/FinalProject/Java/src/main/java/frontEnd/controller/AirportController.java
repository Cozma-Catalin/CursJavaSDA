package frontEnd.controller;

import business.dto.AirportDTO;
import business.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AirportController {
    @Autowired
    AirportService airportService;

    @PostMapping(path = "/insertAirport")
    public ResponseEntity insertAirport(@RequestBody @Valid AirportDTO airportDTO) {
        List<String> airportNameList = airportService.getAirportNameByCityName(airportDTO.getCityDTO().getName());
        if (airportNameList.contains(airportDTO.getName())) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(airportDTO.getName() + ", in " + airportDTO.getCityDTO().getName() + " already in database.");
        }
        airportService.insertAirport(airportDTO);
        return ResponseEntity.ok(airportDTO.getName() + " added.");
    }

    @DeleteMapping(path = "/deleteAirportByName")
    public ResponseEntity deleteAirportByName(@RequestParam String name) {
        int result = airportService.deleteAirportByName(name);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(name + " airport can't be found in database.");
        }
        return ResponseEntity.ok(name + " deleted.");
    }

    @GetMapping(path = "/findAirportByName")
    public ResponseEntity findAirportByName(@RequestParam String name) {

        if (airportService.countAirportName(name) == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No airport found by this name.");
        }
        AirportDTO airportDTO = airportService.findAirportByName(name);
        return ResponseEntity.ok(airportDTO);
    }

    @GetMapping(path = "/findAirportsInCity")
    public ResponseEntity findAirportInCity(@RequestParam String cityName){
        List<AirportDTO> airportDTOList = airportService.findAirportsInCity(cityName);
        if(airportDTOList == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No airport found in city: '" + cityName + "'.");
        }
        return ResponseEntity.ok(airportDTOList);
    }


    @PutMapping(path = "/changeAirportName")
    public ResponseEntity changeAirportName(@RequestParam String newName, String name) {
        if (airportService.countAirportName(newName) != 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(newName + " already exists in database.");
        }
        if(airportService.countAirportName(name)==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(name + " airport can't be found.");
        }
        airportService.changeAirportName(newName,name);
        return ResponseEntity.ok(name + " changed name to '" + newName + "'.");
    }

}
