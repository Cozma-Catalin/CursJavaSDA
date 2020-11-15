package frontEnd.controller;

import business.dto.AccountDTO;
import business.dto.CustomerDTO;
import business.dto.GymDTO;
import business.service.AccountService;
import business.service.CustomerService;
import business.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    AccountService accountService;
    @Autowired
    GymService gymService;

    @PostMapping(path = "/registerCustomer")
    public String registerCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        customerDTO.getAccountDTO().setPassword(accountService.cryptPass(customerDTO.getAccountDTO().getPassword()));

        if (accountService.countUserName(customerDTO.getAccountDTO().getUserName()) != 0) {
            return "This user_name already registered.";
        } else if (customerService.countEmail(customerDTO.getEmail()) != 0) {
            return "This email already registered.";
        }
        for(GymDTO g : customerDTO.getGymDTOSet()){
            if (gymService.countGym(g.getAddress()) == 0){
                return "This gym doesn't exist.Where do you want to workout...?";
            }
            break;
        }

        customerService.registerCustomerDTO(customerDTO);
        return "Account added.";
    }

    @GetMapping(path = "/findCustomer")
    public ResponseEntity<CustomerDTO> findCustomer(@RequestParam String email){
        CustomerDTO customerDTO = customerService.findCustomerByEmail(email);
        if(customerDTO == null){
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customerDTO);
    }

}
