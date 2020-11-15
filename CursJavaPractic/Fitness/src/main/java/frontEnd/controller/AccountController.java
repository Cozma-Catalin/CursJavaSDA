package frontEnd.controller;

import business.dto.CustomerDTO;
import business.service.AccountService;
import business.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    CustomerService customerService;

    @PutMapping(path = "/logOut")
    public ResponseEntity<String> logOut(@RequestParam String userName){
        int result = accountService.updateUserLogIn(false,userName);
        if(result == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok("LoggedOut successfully.");
    }


    @GetMapping(path = "/logIn")
    public ResponseEntity<CustomerDTO> logIn(@RequestParam String userName, String password) {
        String cryptedPassword = accountService.cryptPass(password);

        if (cryptedPassword.equals(accountService.checkRegistration(userName, cryptedPassword))) { // Redirect to site homepage
            // ca sa vad ca functioneaza --> afisez contul
            accountService.updateUserLogIn(true,userName);
            CustomerDTO customerDTO = customerService.findCustomerAccount(userName, cryptedPassword);
            if (customerDTO != null) {
                return ResponseEntity.ok(customerDTO);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Redirect to registration page
    }



    @PostMapping(path = "/changeUserName")
    public String changeUserName(String newUserName, String userName) {
        int result = accountService.changeUsername(newUserName, userName);
        if (result == 0) {
            return "There's no account with that user name.";
        }
        return "User name changed;";
    }

    @DeleteMapping(path = "/deleteAccount")
    public String deleteAccount(@RequestParam String userName) {
        int result = accountService.deleteAccount(userName);
        if (result == 0) {
            return "No account found with that user name.";
        }
        return " Account for user " + userName + " deleted.";
    }
}
