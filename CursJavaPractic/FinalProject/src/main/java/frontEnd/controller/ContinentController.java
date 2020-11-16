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
        long result = continentService.countContinentDTO(continentDTO.getName());
        if (result != 0){
            return  ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        }
        continentService.insertContinentDTO(continentDTO);
        return ResponseEntity.ok("Continent '" + continentDTO.getName() + "' added.");
    }

    @GetMapping(path = "/findContinent")
    public ResponseEntity findContinent(@RequestParam String name){
        ContinentDTO continentDTO = continentService.findContinentDTO(name);
        if(continentDTO==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(continentDTO);
    }

}
