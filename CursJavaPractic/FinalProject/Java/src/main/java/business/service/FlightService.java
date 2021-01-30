package business.service;

import business.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AirportDAO;
import persistence.dao.CityDAO;
import persistence.dao.CountryDAO;
import persistence.dao.FlightDAO;
import persistence.entities.Airport;
import persistence.entities.City;
import persistence.entities.Country;
import persistence.entities.Flight;

@Service
public class FlightService {
    @Autowired
    FlightDAO flightDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    AirportDAO airportDAO;


    public void insertFlight(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setDepartureDate(flightDTO.getDepartureDate());
        flight.setDepartureTime(flightDTO.getDepartureTime());
        setDepartureAirport(flightDTO, flight);
        setArrivingAirport(flightDTO, flight);
        flight.setArrivingDate(flightDTO.getArrivingDate());
        flight.setArrivingTime(flightDTO.getArrivingTime());
        flight.setPrice(flightDTO.getPrice());
        flight.setSeatsAvailable(flightDTO.getSeatsAvailable());
        flightDAO.insertFlight(flight);
    }

    private void setArrivingAirport(FlightDTO flightDTO, Flight flight) {
        Airport arrivingAirportFound = airportDAO.findAirportByName(flightDTO.getArrivingAirport().getName());
        if (arrivingAirportFound == null) {
            Airport arrivingAirport = new Airport();
            arrivingAirport.setName(flightDTO.getArrivingAirport().getName());
            setArrivingCity(flightDTO, null, arrivingAirport);
            flight.setArrivingAirport(arrivingAirport);
        } else {
            setArrivingCity(flightDTO, arrivingAirportFound, arrivingAirportFound);
            flight.setArrivingAirport(arrivingAirportFound);
        }
    }

    private void setArrivingCity(FlightDTO flightDTO, Airport arrivingAirportFound, Airport arrivingAirport) {
        City arrivingCityFound = cityDAO.findCity(flightDTO.getArrivingAirport().getCity().getName());
        if (arrivingCityFound == null) {
            City arrivingCity = new City();
            arrivingCity.setName(flightDTO.getArrivingAirport().getCity().getName());
            setArrivingCountry(flightDTO, arrivingCity);
            arrivingAirport.setCity(arrivingCity);
        } else {
            setArrivingCountry(flightDTO, arrivingCityFound);
            arrivingAirportFound.setCity(arrivingCityFound);
        }
    }

    private void setArrivingCountry(FlightDTO flightDTO, City arrivingCity) {
        Country arrivingCountryFound = countryDAO.findCountry(flightDTO.getArrivingAirport().getCity().getCountry().getName());
        if (arrivingCountryFound == null) {
            Country arrivingCountry = new Country();
            arrivingCountry.setName(flightDTO.getArrivingAirport().getCity().getCountry().getName());
            arrivingCity.setCountry(arrivingCountry);
        } else {
            arrivingCity.setCountry(arrivingCountryFound);
        }
    }

    private void setDepartureAirport(FlightDTO flightDTO, Flight flight) {
        Airport departureAirportFound = airportDAO.findAirportByName(flightDTO.getDepartureAirport().getName());
        if (departureAirportFound == null) {
            Airport departureAirport = new Airport();
            departureAirport.setName(flightDTO.getDepartureAirport().getName());
            setDepartureCity(flightDTO, null, departureAirport);
            flight.setDepartureAirport(departureAirport);
        } else {
            setDepartureCity(flightDTO, departureAirportFound, departureAirportFound);
            flight.setDepartureAirport(departureAirportFound);
        }
    }

    private void setDepartureCity(FlightDTO flightDTO, Airport departureAirportFound, Airport departureAirport) {
        City departCityFound = cityDAO.findCity(flightDTO.getDepartureAirport().getCity().getName());
        if (departCityFound == null) {
            City departCity = new City();
            departCity.setName(flightDTO.getDepartureAirport().getCity().getName());
            setDepartureCountry(flightDTO, departCity);
            departureAirport.setCity(departCity);
        } else {
            setDepartureCountry(flightDTO, departCityFound);
            departureAirportFound.setCity(departCityFound);
        }
    }

    private void setDepartureCountry(FlightDTO flightDTO, City departCity) {
        Country departCountryFound = countryDAO.findCountry(flightDTO.getDepartureAirport().getCity().getCountry().getName());
        if (departCountryFound == null) {
            Country departCountry = new Country();
            departCountry.setName(flightDTO.getDepartureAirport().getCity().getCountry().getName());
            departCity.setCountry(departCountry);
        } else {
            departCity.setCountry(departCountryFound);
        }
    }

    public long countFlightNumber(String flightNumber){
        return flightDAO.countFlightNumber(flightNumber);
    }

    public FlightDTO findFlightByFlightNumber(String flightNumber){
        Flight flight = flightDAO.findFlightByFlightNumber(flightNumber);
        if(flight == null){
            return null;
        }else {
            FlightDTO flightDTO = new FlightDTO();
            flightDTO.setFlightNumber(flight.getFlightNumber());
            flightDTO.setDepartureTime(flight.getDepartureTime());
            flightDTO.setArrivingTime(flight.getArrivingTime());
            flightDTO.setDepartureDate(flight.getDepartureDate());
            flightDTO.setArrivingDate(flight.getArrivingDate());
            flightDTO.setPrice(flight.getPrice());
            flightDTO.setSeatsAvailable(flight.getSeatsAvailable());

            flightDTO.setDepartureAirport(getDepartureAirportDTO(flight));
            flightDTO.setArrivingAirport(getArrivingAirportDTO(flight));
            return flightDTO;
        }
    }

    private AirportDTO getDepartureAirportDTO(Flight flight) {
        AirportDTO departureAirportDTO = new AirportDTO();
        departureAirportDTO.setName(flight.getDepartureAirport().getName());
        ContinentDTO continentDTO = new ContinentDTO(flight.getDepartureAirport().getCity().getCountry().getContinent().getName());
        CountryDTO countryDTO = new CountryDTO(flight.getDepartureAirport().getCity().getCountry().getName());
        countryDTO.setContinent(continentDTO);
        CityDTO cityDTO = new CityDTO(flight.getDepartureAirport().getCity().getName());
        cityDTO.setCountry(countryDTO);
        departureAirportDTO.setCity(cityDTO);
        return departureAirportDTO;
    }

    private AirportDTO getArrivingAirportDTO(Flight flight) {
        AirportDTO arrivingAirportDTO = new AirportDTO();
        arrivingAirportDTO.setName(flight.getArrivingAirport().getName());
        ContinentDTO continentDTO = new ContinentDTO(flight.getArrivingAirport().getCity().getCountry().getContinent().getName());
        CountryDTO countryDTO = new CountryDTO(flight.getArrivingAirport().getCity().getCountry().getName());
        countryDTO.setContinent(continentDTO);
        CityDTO cityDTO = new CityDTO(flight.getArrivingAirport().getCity().getName());
        cityDTO.setCountry(countryDTO);
        arrivingAirportDTO.setCity(cityDTO);
        return arrivingAirportDTO;
    }

    public boolean checkAvailability(int numberOfPersons,int seatsAvailable){
        if(seatsAvailable-numberOfPersons > 0) {
            return true;
        }else{
            return false;
        }
    }

}
