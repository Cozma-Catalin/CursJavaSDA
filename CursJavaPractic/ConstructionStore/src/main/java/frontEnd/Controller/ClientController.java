package frontEnd.Controller;

import business.service.products.CementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    CementService cementService;


    public void addCementToCart(String brand,double quantity){
        cementService.addCementDTOtoCart(brand,quantity);
    }
}
