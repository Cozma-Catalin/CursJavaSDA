package business.service;

import business.dto.AccountDTO;
import business.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CustomerDAO;
import persistence.entities.*;


@Service
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;


    public void insertCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = getCustomerFromDTO(customerDTO);

        setAccount(customerDTO, customer);

        customerDAO.insertCustomer(customer);
    }

    private Customer getCustomerFromDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setBirthDate(customerDTO.getBirthDate());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }

    private void setAccount(CustomerDTO customerDTO, Customer customer) {
        Account account = new Account();
        account.setUserName(customerDTO.getAccountDTO().getUserName());
        account.setPassword(customerDTO.getAccountDTO().getPassword());
        customer.setAccount(account);
    }


    public long countEmail(String email) {
        return customerDAO.countEmail(email);
    }

    public CustomerDTO findCustomerByEmail(String email) {
        Customer customer = customerDAO.findCustomerByEmail(email);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setBirthDate(customer.getBirthDate());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setEmail(customer.getEmail());

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserName(customer.getAccount().getUserName());
        accountDTO.setPassword(customer.getAccount().getPassword());
        accountDTO.setLoggedIn(customer.getAccount().isLoggedIn());
        customerDTO.setAccountDTO(accountDTO);
        return customerDTO;
    }


    public CustomerDTO findCustomerAccount(String userName, String password) {
        Customer customer = customerDAO.findCustomerAccount(userName, password);
        if (customer == null) {
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setBirthDate(customer.getBirthDate());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setEmail(customer.getEmail());
        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setUserName(customer.getAccount().getUserName());
        accountDTO.setPassword(customer.getAccount().getPassword());
        accountDTO.setLoggedIn(customer.getAccount().isLoggedIn());
        customerDTO.setAccountDTO(accountDTO);

        return customerDTO;
    }


    public CustomerDTO findCustomerByUserName(String userName) {
        CustomerDTO customerDTO = new CustomerDTO();
        Customer customer = customerDAO.findCustomerByUserName(userName);

        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setBirthDate(customer.getBirthDate());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setEmail(customer.getEmail());
        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setUserName(customer.getAccount().getUserName());
        accountDTO.setPassword(customer.getAccount().getPassword());
        accountDTO.setLoggedIn(customer.getAccount().isLoggedIn());
        customerDTO.setAccountDTO(accountDTO);
        return customerDTO;
    }

}


