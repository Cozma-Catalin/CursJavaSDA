package business.service;

import business.dto.AirportDTO;
import business.dto.CityDTO;
import business.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AirportDAO;
import persistence.dao.CityDAO;
import persistence.dao.CountryDAO;
import persistence.entities.Airport;
import persistence.entities.City;
import persistence.entities.Country;

import java.util.LinkedList;
import java.util.List;

@Service
public class AirportService {
    @Autowired
    AirportDAO airportDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    CountryDAO countryDAO;


    public void insertAirport(AirportDTO airportDTO) {
        Airport airport = new Airport();
        airport.setName(airportDTO.getName());
        setCityForAirport(airportDTO, airport);
        airportDAO.insertAirport(airport);
    }

    private void setCityForAirport(AirportDTO airportDTO, Airport airport) {
        City cityFound = cityDAO.findCity(airportDTO.getCity().getName());
        if (cityFound == null) {
            City city = new City();
            city.setName(airportDTO.getCity().getName());
            setCountryForCity(airportDTO, city);
            airport.setCity(city);
        } else {
            setCountryForCity(airportDTO, cityFound);
            airport.setCity(cityFound);
        }
    }

    private void setCountryForCity(AirportDTO airportDTO, City cityFound) {
        Country countryFound = countryDAO.findCountry(airportDTO.getCity().getCountry().getName());
        if (countryFound == null) {
            Country country = new Country();
            country.setName(airportDTO.getCity().getCountry().getName());
            cityFound.setCountry(country);
        } else {
            cityFound.setCountry(countryFound);
        }
    }

    public List<String> getAirportNameByCityName(String cityName) {
        return airportDAO.getAirportNameByCityName(cityName);
    }

    public int deleteAirportByName(String name){
        return airportDAO.deleteAirportByName(name);
    }

    public long countAirportName(String name){
        return airportDAO.countAirportName(name);
    }

    public void changeAirportName(String newName, String name){
        airportDAO.changeAirportName(newName,name);
    }

    public AirportDTO findAirportByName(String name){
        AirportDTO airportDTO = new AirportDTO();
        Airport airport = airportDAO.findAirportByName(name);
        airportDTO.setName(airport.getName());
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(airport.getCity().getName());
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(airport.getCity().getCountry().getName());
        cityDTO.setCountry(countryDTO);
        airportDTO.setCity(cityDTO);
        return airportDTO;
    }

    public List<AirportDTO> findAirportsInCity(String cityName){
        List<AirportDTO> airportDTOList = new LinkedList<>();
        List<Airport> airportList = airportDAO.findAirportsInCity(cityName);
        if(airportList.isEmpty()){
            return null;
        }
        for(Airport airport:airportList){
            AirportDTO airportDTO = new AirportDTO();
            airportDTO.setName(airport.getName());
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(airport.getCity().getName());
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setName(airport.getCity().getCountry().getName());
            cityDTO.setCountry(countryDTO);
            airportDTO.setCity(cityDTO);
            airportDTOList.add(airportDTO);
        }
        return airportDTOList;
    }
}
