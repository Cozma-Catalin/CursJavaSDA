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
    public String insertCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        customerDTO.getAccountDTO().setPassword(accountService.cryptPass(customerDTO.getAccountDTO().getPassword()));

        if (accountService.countUserName(customerDTO.getAccountDTO().getUserName()) != 0) {
            return "This user_name already registered.";
        } else if (customerService.countEmail(customerDTO.getEmail()) != 0) {
            return "This email already registered.";
        }

        customerService.insertCustomerDTO(customerDTO);
        return "Account added.";
    }

    @PutMapping(path = "/logOut")
    public ResponseEntity<String> logOut(@RequestParam String userName){
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
    public ResponseEntity<CustomerDTO> findCustomerByEmail(@RequestParam String email){
        CustomerDTO customerDTO = customerService.findCustomerByEmail(email);
        if(customerDTO == null){
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customerDTO);
    }

}
