package business.service;

import business.dto.AccountDTO;
import business.dto.CustomerDTO;
import business.dto.GymDTO;
import business.dto.SubscriptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CustomerDAO;
import persistence.dao.GymDAO;
import persistence.entities.Account;
import persistence.entities.Customer;
import persistence.entities.Gym;
import persistence.entities.Subscription;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    GymDAO gymDAO;


    public void registerCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setBirthDate(customerDTO.getBirthDate());
        customer.setEmail(customerDTO.getEmail());

        setAccount(customerDTO, customer);
        transferGymDTOInfoToCustomer(customerDTO, customer);
        transferSubscriptionDTOInfoToCustomer(customerDTO, customer);

        customerDAO.insertCustomer(customer);
    }

    private void setAccount(CustomerDTO customerDTO, Customer customer) {
        Account account = new Account();
        account.setUserName(customerDTO.getAccountDTO().getUserName());
        account.setPassword(customerDTO.getAccountDTO().getPassword());
        customer.setAccount(account);
    }

    private void transferSubscriptionDTOInfoToCustomer(CustomerDTO customerDTO, Customer customer) {
        Set<Subscription> subscriptionSet = new HashSet<>();
        Subscription subscription = new Subscription();
        for (SubscriptionDTO s : customerDTO.getSubscriptionDTOSet()) {
            subscription.setName(s.getName());
            subscription.setSubscriptionType(s.getSubscriptionType());
            subscription.setNrOfCourses(s.getNrOfCourses());
            subscription.setEnroll(s.getEnroll());
            subscription.setEndOfEnrollment(s.getEndOfEnrollment());
            subscription.setPrice(s.getPrice());
            subscriptionSet.add(subscription);
        }
        customer.setSubscriptionSet(subscriptionSet);
    }

    private void transferGymDTOInfoToCustomer(CustomerDTO customerDTO, Customer customer) {
        Set<Gym> gymSet = new HashSet<>();
        for (GymDTO g : customerDTO.getGymDTOSet()) {
            Gym gym = gymDAO.findGym(g.getAddress());
            gymSet.add(gym);
        }
        customer.setGymSet(gymSet);
    }

    public long countEmail(String email) {
        long result = customerDAO.countEmail(email);
        return result;
    }

    public CustomerDTO findCustomerByEmail(String email) {
        Customer customer = customerDAO.findCustomerByEmail(email);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setBirthDate(customer.getBirthDate());
        customerDTO.setEmail(customer.getEmail());

        setGymInfoToCustomerDTO(customer, customerDTO);
        transferSubscriptionInfoToCustomerDTO(customer, customerDTO);
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserName(customer.getAccount().getUserName());
        accountDTO.setPassword(customer.getAccount().getPassword());
        accountDTO.setLoggedIn(customer.getAccount().isLoggedIn());
        customerDTO.setAccountDTO(accountDTO);
        return customerDTO;
    }

    private void transferSubscriptionInfoToCustomerDTO(Customer customer, CustomerDTO customerDTO) {
        Set<SubscriptionDTO> subscriptionDTOSet = new HashSet<>();
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        for (Subscription s : customer.getSubscriptionSet()) {
            subscriptionDTO.setName(s.getName());
            subscriptionDTO.setSubscriptionType(s.getSubscriptionType());
            subscriptionDTO.setNrOfCourses(s.getNrOfCourses());
            subscriptionDTO.setEnroll(s.getEnroll());
            subscriptionDTO.setEndOfEnrollment(s.getEndOfEnrollment());
            subscriptionDTO.setPrice(s.getPrice());
            subscriptionDTOSet.add(subscriptionDTO);
        }

        customerDTO.setSubscriptionDTOSet(subscriptionDTOSet);
    }

    private void setGymInfoToCustomerDTO(Customer customer, CustomerDTO customerDTO) {
        Set<GymDTO> gymDTOSet = new HashSet<>();
        GymDTO gymDTO = new GymDTO();
        for (Gym g : customer.getGymSet()) {
            gymDTO.setName(g.getName());
            gymDTO.setAddress(g.getAddress());
            gymDTO.setCity(g.getCity());
            gymDTOSet.add(gymDTO);
        }
        customerDTO.setGymDTOSet(gymDTOSet);
    }

    public CustomerDTO findCustomerAccount(String userName, String password) {

        Customer customer = customerDAO.findCustomerAccount(userName, password);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setBirthDate(customer.getBirthDate());
        customerDTO.setEmail(customer.getEmail());
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setLoggedIn(customer.getAccount().isLoggedIn());
        accountDTO.setUserName(customer.getAccount().getUserName());
        accountDTO.setPassword(customer.getAccount().getPassword());
        customerDTO.setAccountDTO(accountDTO);
        setGymInfoToCustomerDTO(customer, customerDTO);
        transferSubscriptionInfoToCustomerDTO(customer, customerDTO);


        return customerDTO;

    }
}
