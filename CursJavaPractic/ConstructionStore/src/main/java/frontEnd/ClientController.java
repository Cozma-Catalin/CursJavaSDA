package frontEnd;

import bussiness.service.products.CementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    CementService cementService;


}
