package business.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AccountDAO;


@Service
public class AccountService {

    @Autowired
    AccountDAO accountDAO;


    public int deleteAccount(String userName) {
        return accountDAO.deleteAccount(userName);
    }

    public int updateUserLogIn(boolean loggedIn,String userName){
        return accountDAO.updateUserLogIn(loggedIn,userName);
    }


    public String cryptPass(String password) {
        char[] chars = password.toCharArray();
        StringBuilder newPassword = new StringBuilder(" ");
        for (char c : chars) {
            c += 3;
            newPassword.append(c);
        }
        return newPassword.toString();
    }

    public String checkRegistration(String userName, String password) {
        return accountDAO.checkRegistration(userName, password);
    }

    public long countUserName(String userName) {
        return accountDAO.countUserName(userName);
    }

    public int changeUsername(String newUsername, String userName) {
        return accountDAO.changeUserName(newUsername, userName);
    }
}
