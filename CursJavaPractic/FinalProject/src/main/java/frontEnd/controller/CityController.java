package frontEnd.controller;

import business.dto.CityDTO;
import business.service.CityService;
import business.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CityController {
    @Autowired
    CityService cityService;
    @Autowired
    CountryService countryService;

    @PostMapping(path = "/insertCity")
    public ResponseEntity insertCity(@RequestBody @Valid CityDTO cityDTO) {
        if (cityService.countCityDTO(cityDTO.getName()) != 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("This city is already in the database.");
        }
        cityService.insertCityDTO(cityDTO);
        return ResponseEntity.ok(cityDTO.getName() + " added.");
    }

    @GetMapping(path = "/findCity")
    public ResponseEntity findCity(@RequestParam String name) {
        CityDTO cityDTO = cityService.findCityDTO(name);
        if (cityDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(name + " can't be found in database.");
        }
        return ResponseEntity.ok(cityDTO);
    }

    @GetMapping(path = "/findCities")
    public ResponseEntity findCities(String countryName){
        if(countryService.countCountryDTO(countryName)==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(countryName + " isn't in the database.");
        }
        List<CityDTO> cityDTOList = cityService.findCitiesDTO(countryName);
        if(cityDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No cities found for country '" + countryName + "'.");
        }
        return ResponseEntity.ok(cityDTOList);
    }



    @DeleteMapping(path = "/deleteCity")
    public ResponseEntity deleteCity(@RequestParam String name) {
        if (cityService.countCityDTO(name) == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(name + " can't be found in database.");
        }
        if (cityService.deleteCityDTO(name) == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(name + " can't be found in database.");
        }
        return ResponseEntity.ok(name + " deleted.");
    }


}
