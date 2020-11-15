package frontEnd.controller;

import business.dto.GymDTO;
import business.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GymController {


    @Autowired
    GymService gymService;

    @GetMapping(path = "/findGym")
    public ResponseEntity<GymDTO> findGym(@RequestParam String address) {
        GymDTO gymDTO = gymService.findGymDTO(address);
        if (!gymDTO.getAddress().equals(address)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(gymDTO);
    }

    @PostMapping(path = "/insertGym")
    public String insertGym(@RequestBody @Valid GymDTO gymDTO) {
        if (gymService.countGym(gymDTO.getAddress()) != 0){
            return "This gym is already in the database.";
        }
        gymService.insertGymDTO(gymDTO);
        return gymDTO.getName() + " added.";

    }

    @DeleteMapping(path = "/deleteGym")
    public String deleteGym(@RequestParam String address){
        int result = gymService.deleteGymDTO(address);
        if(result == 0){
            return "No gym found at this address.";
        }
        return "Gym at this address deleted.";
    }

    @PostMapping(path = "/changeGymName")
    public String changeGymName(@RequestParam String name,String address){
        int result = gymService.changeGymDTOName(name,address);
        if(result == 0){
            return "No gym found at this address.";
        }
        return "Gym's name changed successfully.";
    }

}
