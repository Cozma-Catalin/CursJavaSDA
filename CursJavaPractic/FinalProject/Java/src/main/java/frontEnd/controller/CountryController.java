package frontEnd.controller;

import business.dto.CountryDTO;
import business.service.ContinentService;
import business.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CountryController {
    @Autowired
    CountryService countryService;
    @Autowired
    ContinentService continentService;

    @PostMapping(path = "/insertCountry")
    public ResponseEntity insertCountry(@RequestBody @Valid CountryDTO countryDTO) {

        if (countryService.countCountryDTO(countryDTO.getName()) != 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("'" + countryDTO.getName() + "' already exists in database.");
        }
        countryService.insertCountry(countryDTO);
        return ResponseEntity.ok("Country '" + countryDTO.getName() + "' added.");
    }

    @GetMapping(path = "/findCountry")
    public ResponseEntity findCountry(@RequestParam String name) {
        CountryDTO countryDTO = countryService.findCountryDTO(name);
        if (countryDTO == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(name + " can't be found in database.");
        }
        return ResponseEntity.ok(countryDTO);
    }

    @GetMapping(path = "/findCountriesInContinent")
    public ResponseEntity findCountriesInContinent(@RequestParam String continentName){
        if(continentService.countContinentDTO(continentName)==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(continentName+ " can't be found in database.");
        }
        List<CountryDTO> countryDTOList = countryService.findCountriesInContinent(continentName);
        if(countryDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body( "No countries found for continent '" + continentName + "'.");
        }
        return ResponseEntity.ok(countryDTOList);
    }


    @DeleteMapping(path = "/deleteCountry")
    public ResponseEntity deleteCountry(@RequestParam String name) {
        if(countryService.countCountryDTO(name)==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(name + " can't be found in database to be deleted.");
        }
        countryService.deleteCountry(name);
        return ResponseEntity.ok("Country '" + name + "' deleted.");
    }

    @PutMapping(path = "/changeCountryName")
    public ResponseEntity changeCountryName(@RequestParam String newName, String name) {
        if (countryService.countCountryDTO(newName) != 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(newName + " already exists in database.");
        }
        if (countryService.changeCountryName(newName, name) == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(name + " can't be found in database to be changed.");
        }
        return ResponseEntity.ok("Country '" + name + "' became '" + newName + "'.");
    }
}
