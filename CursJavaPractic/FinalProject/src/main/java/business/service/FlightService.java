package business.service;

import business.dto.FlightDTO;
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
            setArrivingCity(flightDTO, arrivingAirportFound, arrivingAirport);
            flight.setArrivingAirport(arrivingAirport);
        } else {
            setArrivingCity(flightDTO, arrivingAirportFound, arrivingAirportFound);
            flight.setArrivingAirport(arrivingAirportFound);
        }
    }

    private void setArrivingCity(FlightDTO flightDTO, Airport arrivingAirportFound, Airport arrivingAirport) {
        City arrivingCityFound = cityDAO.findCity(flightDTO.getArrivingAirport().getCityDTO().getName());
        if (arrivingCityFound == null) {
            City arrivingCity = new City();
            arrivingCity.setName(flightDTO.getArrivingAirport().getCityDTO().getName());
            setArrivingCountry(flightDTO, arrivingCity);
            arrivingAirport.setCity(arrivingCity);
        } else {
            setArrivingCountry(flightDTO, arrivingCityFound);
            arrivingAirportFound.setCity(arrivingCityFound);
        }
    }

    private void setArrivingCountry(FlightDTO flightDTO, City arrivingCity) {
        Country arrivingCountryFound = countryDAO.findCountry(flightDTO.getArrivingAirport().getCityDTO().getCountryDTO().getName());
        if (arrivingCountryFound == null) {
            Country arrivingCountry = new Country();
            arrivingCountry.setName(flightDTO.getArrivingAirport().getCityDTO().getCountryDTO().getName());
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
        City departCityFound = cityDAO.findCity(flightDTO.getDepartureAirport().getCityDTO().getName());
        if (departCityFound == null) {
            City departCity = new City();
            departCity.setName(flightDTO.getDepartureAirport().getCityDTO().getName());
            setDepartureCountry(flightDTO, departCity);
            departureAirport.setCity(departCity);
        } else {
            setDepartureCountry(flightDTO, departCityFound);
            departureAirportFound.setCity(departCityFound);
        }
    }

    private void setDepartureCountry(FlightDTO flightDTO, City departCity) {
        Country departCountryFound = countryDAO.findCountry(flightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getName());
        if (departCountryFound == null) {
            Country departCountry = new Country();
            departCountry.setName(flightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getName());
            departCity.setCountry(departCountry);
        } else {
            departCity.setCountry(departCountryFound);
        }
    }

    public long countFlightNumber(String flightNumber){
        long result = flightDAO.countFlightNumber(flightNumber);
        return result;
    }

}
