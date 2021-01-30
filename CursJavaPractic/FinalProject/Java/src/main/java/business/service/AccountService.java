package business.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AccountDAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Service
public class AccountService {

    @Autowired
    AccountDAO accountDAO;


    public int deleteAccount(String userName) {
        return accountDAO.deleteAccount(userName);
    }

    public int updateUserLogIn(boolean loggedIn, String userName) {
        return accountDAO.updateUserLogIn(loggedIn, userName);
    }


    public String cryptPass(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInteger = new BigInteger(1, messageDigest.digest(password.getBytes()));
        String cryptedPassword = bigInteger.toString();

        return cryptedPassword;
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
