package business.service;

import business.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.UserDAO;
import persistence.entities.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Service
public class UserService {

    @Autowired
    UserDAO userDAO;


    public void insertUserDTO(UserDTO userDTO) {
        User user = getUserFromDTO(userDTO);
        userDAO.insertUser(user);
    }

    private User getUserFromDTO(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setBirthDate(userDTO.getBirthDate());
        user.setAddress(userDTO.getAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setLoggedIn(userDTO.isLoggedIn());
        return user;
    }


    public long countEmail(String email) {
        return userDAO.countEmail(email);
    }

    public UserDTO findUserByEmail(String email) {
        User user = userDAO.findUserByEmail(email);
        if(user ==null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setAddress(user.getAddress());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setEmail(user.getEmail());
        userDTO.setLoggedIn(user.isLoggedIn());
        return userDTO;
    }


    public UserDTO findUserAccount(String email, String password) {
        User user = userDAO.findUserAccount(email, password);
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setLoggedIn(user.isLoggedIn());

        return userDTO;
    }



    public int updateUserLogIn(boolean loggedIn, String email) {
        return userDAO.updateUserLogIn(loggedIn, email);
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

    public String checkRegistration(String email, String password) {
        return userDAO.checkRegistration(email, password);
    }


}


