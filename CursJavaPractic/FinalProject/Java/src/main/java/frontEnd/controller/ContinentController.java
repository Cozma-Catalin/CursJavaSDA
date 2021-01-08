package frontEnd.controller;

import business.dto.ContinentDTO;
import business.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class ContinentController {
    @Autowired
    ContinentService continentService;


    @PostMapping(path = "/insertContinent")
    public ResponseEntity insertContinent(@RequestBody @Valid ContinentDTO continentDTO) {
        if (continentService.countContinentDTO(continentDTO.getName()) != 0){
            return  ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(continentDTO.getName() + " already exists in database");
        }
        continentService.insertContinentDTO(continentDTO);
        return ResponseEntity.ok("Continent '" + continentDTO.getName() + "' added.");
    }

    @GetMapping(path = "/findContinent")
    public ResponseEntity findContinent(@RequestParam String name){
        ContinentDTO continentDTO = continentService.findContinentDTO(name);
        if(continentDTO==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(name + " can't be found in database.");
        }
        return ResponseEntity.ok(continentDTO);
    }


    @DeleteMapping(path = "/deleteContinent")
    public ResponseEntity deleteContinent(String name){
        if(continentService.countContinentDTO(name)==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Continent '" + name + "' can't be found in database.");
        }
        continentService.deleteContinentDTO(name);
        return ResponseEntity.ok("Continent '" + name + "' deleted.");
    }


}
