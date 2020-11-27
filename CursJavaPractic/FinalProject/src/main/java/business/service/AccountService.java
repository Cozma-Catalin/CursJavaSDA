package business.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AccountDAO;


@Service
public class AccountService {

    @Autowired
    AccountDAO accountDAO;


    public int deleteAccount(String userName) {
        int result = accountDAO.deleteAccount(userName);
        return result;
    }

    public int updateUserLogIn(boolean loggedIn,String userName){
        int result = accountDAO.updateUserLogIn(loggedIn,userName);
        return result;
    }


    public String cryptPass(String password) {
        char[] chars = password.toCharArray();
        String newPassword = " ";
        for (char c : chars) {
            c += 3;
            newPassword += c;
        }
        return newPassword;
    }

    public String checkRegistration(String userName, String password) {
        String retrievedPassword = accountDAO.checkRegistration(userName, password);
        return retrievedPassword;
    }

    public long countUserName(String userName) {
        long result = accountDAO.countUserName(userName);
        return result;
    }

    public int changeUsername(String newUsername, String userName) {
        int result = accountDAO.changeUserName(newUsername, userName);
        return result;
    }
}
