package business.service;

import business.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.*;
import persistence.entities.*;

import java.util.HashSet;
import java.util.Set;

@Service
public class TripService {
    @Autowired
    TripDAO tripDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    AirportDAO airportDAO;
    @Autowired
    HotelService hotelService;
    @Autowired
    HotelDAO hotelDAO;
    @Autowired
    ContinentDAO continentDAO;


    public void insertTrip(TripDTO tripDTO) {
        Trip trip = new Trip();
        trip.setName(tripDTO.getName());
        FlightDTO departureFlightDTO = tripDTO.getDepartureFlightDTO();

        Flight departureFlight = new Flight();
        departureFlight.setFlightNumber(departureFlightDTO.getFlightNumber());
        departureFlight.setDepartureDateAndTime(departureFlightDTO.getDepartureDateAndTime());
        Airport departAirportFound = airportDAO.findAirportByName(departureFlightDTO.getDepartureAirport().getName());
        if (departAirportFound == null) {
            Airport departAirport = new Airport();
            departAirport.setName(departureFlightDTO.getDepartureAirport().getName());
            City cityFound = cityDAO.findCity(departureFlightDTO.getDepartureAirport().getCityDTO().getName());
            if (cityFound == null) {
                City city = new City();
                city.setName(departureFlightDTO.getDepartureAirport().getCityDTO().getName());
                Country countryFound = countryDAO.findCountry(departureFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getName());
                if (countryFound == null) {
                    Country country = new Country();
                    country.setName(departureFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getName());
                    Continent continentFound = continentDAO.findContinent(departureFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO().getName());
                    if (continentFound == null) {
                        Continent continent = new Continent(departureFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO().getName());
                        country.setContinent(continent);
                    } else {
                        country.setContinent(continentFound);
                    }
                    city.setCountry(country);
                } else {
                    city.setCountry(countryFound);
                }
                departAirport.setCity(city);
            } else {
                departAirport.setCity(cityFound);
            }
            departureFlight.setDepartureAirport(departAirport);
        } else {
            departureFlight.setDepartureAirport(departAirportFound);
        }

        Airport arrivingAirportFound = airportDAO.findAirportByName(departureFlightDTO.getArrivingAirport().getName());
        if (arrivingAirportFound == null) {
            Airport arrivingAirport = new Airport();
            arrivingAirport.setName(departureFlightDTO.getArrivingAirport().getName());
            City cityFound = cityDAO.findCity(departureFlightDTO.getArrivingAirport().getCityDTO().getName());
            if (cityFound == null) {
                City city = new City();
                city.setName(departureFlightDTO.getArrivingAirport().getCityDTO().getName());
                Country countryFound = countryDAO.findCountry(departureFlightDTO.getArrivingAirport().getCityDTO().getCountryDTO().getName());
                if (countryFound == null) {
                    Country country = new Country();
                    country.setName(departureFlightDTO.getArrivingAirport().getCityDTO().getCountryDTO().getName());
                    if (departureFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO().getName().equalsIgnoreCase(departureFlightDTO.getArrivingAirport().getCityDTO().getCountryDTO().getContinentDTO().getName())) {
                        country.setContinent(departureFlight.getDepartureAirport().getCity().getCountry().getContinent());
                    } else {
                        Continent continentFound = continentDAO.findContinent(departureFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO().getName());
                        if (continentFound == null) {
                            Continent continent = new Continent(departureFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO().getName());
                            country.setContinent(continent);
                        } else {
                            country.setContinent(continentFound);
                        }
                    }
                    city.setCountry(country);
                } else {
                    city.setCountry(countryFound);
                }
                arrivingAirport.setCity(city);
            } else {
                arrivingAirport.setCity(cityFound);
            }
            departureFlight.setArrivingAirport(arrivingAirport);
        } else {
            departureFlight.setArrivingAirport(arrivingAirportFound);
        }
        departureFlight.setArrivingDateAndTime(departureFlightDTO.getArrivingDateAndTime());
        departureFlight.setPrice(departureFlightDTO.getPrice());
        departureFlight.setSeatsAvailable(departureFlightDTO.getSeatsAvailable());


        trip.setDepartureFlight(departureFlight);


        FlightDTO returningFlightDTO = tripDTO.getReturningFlightDTO();
        Flight returningFlight = new Flight();
        returningFlight.setFlightNumber(returningFlightDTO.getFlightNumber());
        returningFlight.setDepartureDateAndTime(returningFlightDTO.getDepartureDateAndTime());
        if (departureFlight.getArrivingAirport().getName().equalsIgnoreCase(returningFlightDTO.getDepartureAirport().getName())) {
            returningFlight.setDepartureAirport(departureFlight.getArrivingAirport());
        } else {
            Airport returningDepartAirportFound = airportDAO.findAirportByName(returningFlightDTO.getDepartureAirport().getName());
            if (returningDepartAirportFound == null) {
                Airport departAirport = new Airport();
                departAirport.setName(returningFlightDTO.getDepartureAirport().getName());
                City cityFound = cityDAO.findCity(returningFlightDTO.getDepartureAirport().getCityDTO().getName());
                if (cityFound == null) {
                    City city = new City();
                    city.setName(returningFlightDTO.getDepartureAirport().getCityDTO().getName());
                    Country countryFound = countryDAO.findCountry(returningFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getName());
                    if (countryFound == null) {
                        Country country = new Country();
                        country.setName(returningFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getName());
                        if (departureFlightDTO.getArrivingAirport().getCityDTO().getCountryDTO().getContinentDTO().getName().equalsIgnoreCase(returningFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO().getName())) {
                            country.setContinent(departureFlight.getArrivingAirport().getCity().getCountry().getContinent());
                        } else {
                            Continent continentFound = continentDAO.findContinent(returningFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO().getName());
                            if (continentFound == null) {
                                Continent continent = new Continent(returningFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO().getName());
                                country.setContinent(continent);
                            } else {
                                country.setContinent(continentFound);
                            }
                        }
                        city.setCountry(country);
                    } else {
                        city.setCountry(countryFound);
                    }
                    departAirport.setCity(city);
                } else {
                    departAirport.setCity(cityFound);
                }
                returningFlight.setDepartureAirport(departAirport);
            } else {
                returningFlight.setDepartureAirport(returningDepartAirportFound);
            }
        }

        if (departureFlight.getDepartureAirport().getName().equalsIgnoreCase(returningFlightDTO.getArrivingAirport().getName())) {
            returningFlight.setArrivingAirport(departureFlight.getDepartureAirport());
        } else {
            Airport returningArrivingAirportFound = airportDAO.findAirportByName(returningFlightDTO.getArrivingAirport().getName());
            if (arrivingAirportFound == null) {
                Airport arrivingAirport = new Airport();
                arrivingAirport.setName(returningFlightDTO.getArrivingAirport().getName());
                City cityFound = cityDAO.findCity(returningFlightDTO.getArrivingAirport().getCityDTO().getName());
                if (cityFound == null) {
                    City city = new City();
                    city.setName(returningFlightDTO.getArrivingAirport().getCityDTO().getName());
                    Country countryFound = countryDAO.findCountry(returningFlightDTO.getArrivingAirport().getCityDTO().getCountryDTO().getName());
                    if (countryFound == null) {
                        Country country = new Country();
                        country.setName(returningFlightDTO.getArrivingAirport().getCityDTO().getCountryDTO().getName());
                        if(departureFlightDTO.getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO().getName().equalsIgnoreCase(returningFlightDTO.getArrivingAirport().getCityDTO().getCountryDTO().getContinentDTO().getName())) {
                            country.setContinent(departureFlight.getDepartureAirport().getCity().getCountry().getContinent());
                        }else {
                            Continent continentFound = continentDAO.findContinent(returningFlightDTO.getArrivingAirport().getCityDTO().getCountryDTO().getContinentDTO().getName());
                            if(continentFound==null){
                                Continent continent = new Continent(returningFlightDTO.getArrivingAirport().getCityDTO().getCountryDTO().getContinentDTO().getName());
                                country.setContinent(continent);
                            }else{
                                country.setContinent(continentFound);
                            }
                        }
                        city.setCountry(country);
                    } else {
                        city.setCountry(countryFound);
                    }
                    arrivingAirport.setCity(city);
                } else {
                    arrivingAirport.setCity(cityFound);
                }
                returningFlight.setArrivingAirport(arrivingAirport);
            } else {
                returningFlight.setArrivingAirport(returningArrivingAirportFound);
            }
        }

        returningFlight.setArrivingDateAndTime(returningFlightDTO.getArrivingDateAndTime());
        returningFlight.setPrice(returningFlightDTO.getPrice());
        returningFlight.setSeatsAvailable(returningFlightDTO.getSeatsAvailable());


        trip.setReturningFlight(returningFlight);


        Hotel hotelFound = hotelDAO.findHotelByAddress(tripDTO.getStayingHotelDTO().getAddress());
        if (hotelFound == null) {
            Hotel hotel = new Hotel();
            hotel.setName(tripDTO.getStayingHotelDTO().getName());
            if (tripDTO.getStayingHotelDTO().getCityDTO().getName().equalsIgnoreCase(departureFlight.getArrivingAirport().getCity().getName())) {
                hotel.setCity(departureFlight.getArrivingAirport().getCity());
            } else {
                hotelService.setCity(tripDTO.getStayingHotelDTO(), hotel);
            }
            hotel.setAddress(tripDTO.getStayingHotelDTO().getAddress());
            hotel.setDescription(tripDTO.getStayingHotelDTO().getDescription());
            hotel.setNumberOfStars(tripDTO.getStayingHotelDTO().getNumberOfStars());
            Set<Room> rooms = new HashSet<>();
            Set<RoomDTO> roomDTOSet = tripDTO.getStayingHotelDTO().getRoomDTOSet();
            for (RoomDTO roomDTO : roomDTOSet) {
                Room room = new Room();
                room.setRoomType(roomDTO.getRoomType());
                room.setNumberOfRooms(roomDTO.getNumberOfRooms());
                room.setExtraBed(roomDTO.isExtraBed());
                room.setRoomsAvailable(roomDTO.getRoomsAvailable());
                rooms.add(room);
            }
            hotel.setRoomSet(rooms);
            trip.setStayingHotel(hotel);
        } else {
            trip.setStayingHotel(hotelFound);
        }
        trip.setMealType(tripDTO.getMealType());
        trip.setDepartureDate(tripDTO.getDepartureDate());
        trip.setReturnDate(tripDTO.getReturnDate());
        trip.setNumberOfDays(tripDTO.getNumberOfDays());
        trip.setPriceForAdult(tripDTO.getPriceForAdult());
        trip.setPriceForChild(tripDTO.getPriceForChild());
        trip.setNumberOfAdults(tripDTO.getNumberOfAdults());
        trip.setNumberOfChildren(tripDTO.getNumberOfChildren());
        trip.setPromoted(tripDTO.isPromoted());
        trip.setTripsPrice(calculateTripsPrice(tripDTO));
        trip.setNumberOfTripsAvailable(tripDTO.getNumberOfTripsAvailable());
        tripDAO.insertTrip(trip);
    }

    private double calculateTripsPrice(TripDTO tripDTO) {
        double totalFlightPrice = (tripDTO.getDepartureFlightDTO().getPrice() * (tripDTO.getNumberOfAdults() + tripDTO.getNumberOfChildren()))
                + (tripDTO.getReturningFlightDTO().getPrice() * (tripDTO.getNumberOfAdults() + tripDTO.getNumberOfChildren()));
        return ((tripDTO.getPriceForAdult() * tripDTO.getNumberOfAdults() + (tripDTO.getPriceForChild() * tripDTO.getNumberOfChildren())) + totalFlightPrice);
    }


}
