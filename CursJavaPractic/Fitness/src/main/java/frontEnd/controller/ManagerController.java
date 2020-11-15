package frontEnd.controller;

import business.dto.GymDTO;
import business.dto.ManagerDTO;
import business.service.GymService;
import business.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ManagerController {

    @Autowired
    ManagerService managerService;
    @Autowired
    GymService gymService;

    @PostMapping(path = "/insertManager")
    public String insertManager(@RequestBody @Valid ManagerDTO managerDTO){
        if(managerService.countManager(managerDTO.getName())!= 0){
            return "This manager is already in database.";
        }
        if(gymService.countGym(managerDTO.getGymDTO().getAddress())!=0){
            return "This gym has a manager.";
        }
        managerService.insertManagerDTO(managerDTO);
        return managerDTO.getName() + ", " + managerDTO.getSurname() + " added.";
    }

    @DeleteMapping(path = "/deleteManager")
    public String deleteManager(String name){
      int result = managerService.deleteManager(name);
        if(result==0){
            return "No manager found by this name.";
        }
        return name + " deleted from database.";
    }

    @GetMapping(path = "/findManager")
    public ResponseEntity<ManagerDTO> findManager(String name){
        ManagerDTO managerDTO = managerService.findManager(name);
        if(managerDTO==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(managerDTO);
    }




}
