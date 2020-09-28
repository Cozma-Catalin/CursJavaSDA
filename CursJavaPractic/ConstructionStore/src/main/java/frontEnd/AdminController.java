package frontEnd;

import bussiness.dto.products.chemicals.CementDTO;
import bussiness.service.products.CementService;
import bussiness.service.structures.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class AdminController {
    @Autowired
    CementService cementService;
    @Autowired
    DepartmentService departmentService;

    @PostMapping(path = "/insertCement")
    public String insertCement(@RequestBody @Valid CementDTO cementDTOToInsert) {
        if (cementService.countCementDTO(cementDTOToInsert.getBrand()) == 0) {

            cementService.insertCementDTO(cementDTOToInsert);

            return cementDTOToInsert.getBrand() + " added successfully.";
        }
        return "This " + cementDTOToInsert.getBrand() + " already exists.";
    }

    @GetMapping("/findCementByBrand")
    public ResponseEntity<CementDTO> findCementByBrand(String brand) {
        CementDTO cementDTO = cementService.findCementDTOByBrand(brand);
        if (cementDTO == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cementDTO);
    }

    @DeleteMapping("/deleteCementByBrand")
    public String deleteCementByBrand(@RequestParam String brand) {
        int result = cementService.deleteCementDTOByBrand(brand);
        if (result == 0) {
            return "No cement with this brand found.";
        }
        return result + " items were deleted";
    }

    @PostMapping("/updateCementPrice")
    public String updateCementPrice(@RequestParam String brand,double price){
       int result = cementService.updateCementPrice(brand,price);
        if(result == 0){
            return "No items with this brand found.";
        }
        return result + " items updated.";
    }

    @PostMapping("/updateCementQuantity")
    public String updateCementQuantity(@RequestParam String brand,double quantity){
        int result = cementService.updateCementQuantity(brand,quantity);
        if(result == 0){
            return "No items with this brand found.";
        }
        return result + " items were updated.";
    }

    @DeleteMapping("/deleteDepartmentByName")
    public String deleteDepartmentByName(String name){
        int result = departmentService.deleteDepartmentByName(name);
        if(result == 0){
            return "No department with this name found.";
        }
        return result + " items deleted.";
    }

    @PostMapping("/updateDepartmentName")
    public String updateDepartmentName(String newName,String name){
        int result = departmentService.updateDepartmentName(newName,name);
        if(result == 0){
            return "No department with that name found.";
        }
        return result + " department name updated.";
    }
}
