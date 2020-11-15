package frontEnd.controller;

import business.dto.TrainerDTO;
import business.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TrainerController {
    @Autowired
    TrainerService trainerService;

    @PostMapping(path = "/addTrainer")
    public String addTrainerDTO(@RequestBody @Valid TrainerDTO trainerDTO){
        long result = trainerService.countTrainerDTO(trainerDTO.getName(),trainerDTO.getSurname());
        System.out.println(trainerDTO);
        if(result!=0){
            return "This trainer already registered.";
        }
        trainerService.addTrainerDTO(trainerDTO);
        return trainerDTO.getName() + ", "+ trainerDTO.getSurname() + " added.";
    }

    @DeleteMapping(path = "/deleteTrainer")
    public String deleteTrainer(@RequestParam String name,String surname){
        int result = trainerService.deleteTrainerDTO(name,surname);
        return result + " trainer deleted.";
    }
}
