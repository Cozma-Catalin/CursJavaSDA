package frontEnd;

import bussiness.dto.products.CementDTO;
import bussiness.dto.products.PaintDTO;
import bussiness.dto.products.ScrewdriverDTO;
import bussiness.dto.structures.DepartmentDTO;
import bussiness.service.products.CementService;
import bussiness.service.products.PaintService;
import bussiness.service.products.ScrewdriverService;
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
    @Autowired
    PaintService paintService;
    @Autowired
    ScrewdriverService screwdriverService;

    @PostMapping(path = "/insertCement")
    public String insertCement(@RequestBody @Valid CementDTO cementDTOToInsert) {
        if (cementService.countCementDTOByBrand(cementDTOToInsert.getBrand()) == 0) {
            cementService.insertCementDTO(cementDTOToInsert);
            return cementDTOToInsert.getBrand() + " added successfully.";
        }
        return cementDTOToInsert.getBrand() + " already exists.";
    }

    @GetMapping("/findCementByBrand")
    public ResponseEntity<CementDTO> findCementByBrand(@RequestParam String brand) {
        CementDTO cementDTO = cementService.findCementDTOByBrand(brand);
        if (!cementDTO.getBrand().equalsIgnoreCase(brand)) {
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
    public String updateCementPrice(@RequestParam String brand, double price) {
        int result = cementService.updateCementDTOPrice(brand, price);
        if (result == 0) {
            return "No items with this brand found.";
        }
        return result + " items updated.";
    }

    @PostMapping("/updateCementQuantity")
    public String updateCementQuantity(@RequestParam String brand, double quantity) {
        int result = cementService.updateCementDTOQuantity(brand, quantity);
        if (result == 0) {
            return "No items with this brand found.";
        }
        return result + " items were updated.";
    }

    @PostMapping(path = "/insertPaint")
    public String insertPaint(@RequestBody @Valid PaintDTO paintDTOToInsert) {
        if (paintService.countPaintDTOByBrand(paintDTOToInsert.getBrand()) == 0) {
            paintService.insertPaintDTO(paintDTOToInsert);
            return paintDTOToInsert.getBrand() + " added successfully.";
        }
        return paintDTOToInsert.getBrand() + " already exists.";
    }

    @DeleteMapping("/deletePaintByBrand")
    public String deletePaintByBrand(@RequestParam String brand) {
        int result = paintService.deletePaintByBrand(brand);
        if (result == 0) {
            return "No item found with this brand.";
        }
        return result + " items deleted.";
    }

    @GetMapping("/findPaintByBrand")
    public ResponseEntity<PaintDTO> findPaintByBrand(@RequestParam String brand) {
        PaintDTO paintDTO = paintService.findPaintDTOByBrand(brand);
        if (paintDTO == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paintDTO);
    }

    @PostMapping("/updatePaintPrice")
    public String updatePaintPrice(@RequestParam double price, String brand) {
        int result = paintService.updatePaintPrice(price, brand);
        if (result == 0) {
            return "No items found with this brand.";
        }
        return result + " items updated";
    }

    @PostMapping("/updatePaintQuantity")
    public String updatePaintQuantity(@RequestParam double quantity, String brand) {
        int result = paintService.updatePaintQuantity(quantity, brand);
        if (result == 0) {
            return "No items found with this brand.";
        }
        return result + " items updated.";
    }

    @PostMapping(path = "/insertScrewdriver")
    public String insertScrewdriverDTO(@RequestBody @Valid ScrewdriverDTO screwdriverDTOToInsert) {
        if (screwdriverService.countScrewdriverDTOByBrand(screwdriverDTOToInsert.getBrand()) == 0) {
            screwdriverService.insertScrewdriverDTO(screwdriverDTOToInsert);
            return screwdriverDTOToInsert.getBrand() + " added successfully.";
        }
        return screwdriverDTOToInsert.getBrand() + " already exists.";
    }

    @GetMapping("/findScrewdriverByBrand")
    public ResponseEntity<ScrewdriverDTO> findScrewdriverByBrand(@RequestParam String brand) {
        ScrewdriverDTO screwdriverDTO = screwdriverService.findScrewdriverDTOByBrand(brand);
        if (screwdriverDTO == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(screwdriverDTO);
    }

    @PostMapping("/updateScrewdriverPrice")
    public String updateScrewdriverPrice(double price,String brand){
        int result = screwdriverService.updateScrewdriverDTOPrice(price,brand);
        if(result == 0){
            return "No items found with this brand.";
        }
        return result + " items updated.";
    }

    @PostMapping("/updateScrewdriverQuantity")
    public String updateScrewdriverQuantity(double quantity,String brand){
        int result = screwdriverService.updateScrewdriverDTOQuantity(quantity,brand);
        if(result == 0){
            return  "No items found with this brand.";
        }
        return result + " items updated.";
    }



    @DeleteMapping("/deleteDepartmentByName")
    public String deleteDepartmentByName(String name) {
        int result = departmentService.deleteDepartmentByName(name);
        if (result == 0) {
            return "No department with this name found.";
        }
        return result + " items deleted.";
    }

    @GetMapping("/findDepartmentByName")
    public ResponseEntity<DepartmentDTO> findDepartmentByName(String name) {
        DepartmentDTO departmentDTO = departmentService.findDepartmentDTOByName(name);
        if (departmentDTO == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(departmentDTO);

    }

    @PostMapping("/renameDepartment")
    public String renameDepartment(String newName, String name) {
        int result = departmentService.renameDepartment(newName, name);
        if (result == 0) {
            return "No department with that name found.";
        }
        return result + " department name updated.";
    }


}
