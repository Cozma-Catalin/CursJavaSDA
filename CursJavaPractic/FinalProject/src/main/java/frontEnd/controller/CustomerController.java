package frontEnd.controller;

import business.dto.CustomerDTO;
import business.service.AccountService;
import business.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    AccountService accountService;


    @PostMapping(path = "/insertCustomer")
    public ResponseEntity insertCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        customerDTO.getAccountDTO().setPassword(accountService.cryptPass(customerDTO.getAccountDTO().getPassword()));

        if (accountService.countUserName(customerDTO.getAccountDTO().getUserName()) != 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("This user_name already registered.");
        } else if (customerService.countEmail(customerDTO.getEmail()) != 0) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("This email already registered.");
        }
        customerService.insertCustomerDTO(customerDTO);
        return ResponseEntity.ok("Customer added.");
    }

    @PutMapping(path = "/logOut")
    public ResponseEntity logOut(@RequestParam String userName){
        int result = accountService.updateUserLogIn(false,userName);
        if(result == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userName + " can't find an account with this user name.");
        }
        return ResponseEntity.ok(userName + " logged out successfully.");
    }


    @PutMapping(path = "/logIn")
    public ResponseEntity logIn(@RequestParam String userName, String password) {
        String cryptedPassword = accountService.cryptPass(password);

        if (cryptedPassword.equals(accountService.checkRegistration(userName, cryptedPassword))) {
            accountService.updateUserLogIn(true,userName);
            return ResponseEntity.ok(userName + " logged in successfully.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping(path = "/findCustomerByEmail")
    public ResponseEntity findCustomerByEmail(@RequestParam String email){
        CustomerDTO customerDTO = customerService.findCustomerByEmail(email);
        if(customerDTO == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find customer with email: " + email);
        }
        return ResponseEntity.ok(customerDTO);
    }


    @GetMapping(path = "/findCustomerAccount")
    public ResponseEntity findCustomerAccount(@RequestParam String userName,String password){
        String cryptedPassword = accountService.cryptPass(password);
        CustomerDTO customerDTO = customerService.findCustomerAccount(userName,cryptedPassword);
        if(customerDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't find account with user name:" + userName);
        }
        return ResponseEntity.ok(customerDTO);
    }

}
