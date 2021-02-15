package frontEnd.controller;


import business.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/account")
public class AccountController {
    @Autowired
    AccountService accountService;


    @PutMapping(path = "/changeUserName")
    public ResponseEntity changeUserName(@RequestParam String newUserName, String userName) {
        int result = accountService.changeUsername(newUserName, userName);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There's no account with that user name.");
        }
        return ResponseEntity.ok("User name changed to " + newUserName + ".");
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity deleteAccount(@RequestParam String userName) {
        int result = accountService.deleteAccount(userName);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No account found with that user name.");
        }
        return ResponseEntity.ok(" Account for user " + userName + " deleted.");
    }
}
