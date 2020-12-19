package business.service;

import business.dto.AccountDTO;
import business.dto.CustomerDTO;
import business.dto.TripDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CustomerDAO;
import persistence.dao.FlightDAO;
import persistence.dao.TripDAO;
import persistence.entities.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;


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

    public static void main(String[] args) throws IOException {


        readFile();
    }

    public static void readFile() throws IOException {
        String filePath = "C:\\Users\\Catalin\\Desktop\\Travel_Agency.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);
        XSSFSheet sheet = workbook.getSheet("Trips");

        try {
            Iterator<Row> rowIterator = sheet.iterator();
            Row row = rowIterator.next();
            while (rowIterator.hasNext()) {
               row = rowIterator.next();


                Iterator<Cell> cellIterator = row.cellIterator();
                DataFormatter dataFormatter = new DataFormatter();

                Cell cell = cellIterator.next();


                cell = cellIterator.next();
                System.out.println(cell);
                Object cellData = dataFormatter.formatCellValue(cell);
                Trip trip = new Trip();
                trip.setName((String) cellData);
                cell = cellIterator.next();
                System.out.println(cell);
                trip.setMealType(cell.getStringCellValue());
                cell = cellIterator.next();
                System.out.println(cell);
                cellData = dataFormatter.formatCellValue(cell);


                cell = cellIterator.next();
                System.out.println(cell);
                Flight flight = new Flight();
                flight.setFlightNumber(cell.getStringCellValue());
                cell = cellIterator.next();
                System.out.println(cell);

                cell = cellIterator.next();System.out.println(cell);
                Airport departAirport = new Airport();
                departAirport.setName(cell.getStringCellValue());
                cell = cellIterator.next();System.out.println(cell);
                City city = new City();
                city.setName(cell.getStringCellValue());
                cell = cellIterator.next();System.out.println(cell);
                Country country = new Country();
                country.setName(cell.getStringCellValue());
                cell = cellIterator.next();System.out.println(cell);
                Continent continent = new Continent();
                continent.setName(cell.getStringCellValue());
                country.setContinent(continent);
                city.setCountry(country);
                departAirport.setCity(city);
                flight.setDepartureAirport(departAirport);
                trip.setDepartureFlight(flight);
                System.out.println(trip);
            }
            workbook.close();

        } catch (IOException e) {
            System.out.println(e.getCause());
        }

    }
}


