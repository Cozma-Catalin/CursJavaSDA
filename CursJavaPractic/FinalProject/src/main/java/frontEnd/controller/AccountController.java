package frontEnd.controller;


import business.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;


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
