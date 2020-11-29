package business.service;

import business.dto.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import persistence.HibernateUtil;
import persistence.dao.*;
import persistence.entities.*;

@Scope("prototype")
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
    @Autowired
    FlightDAO flightDAO;


    public void insertTrip(TripDTO tripDTO) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //pregatesc continentele de la dus
        Continent departureContinent = prepareContinent(tripDTO.getDepartureFlightDTO().getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO(),session);
        Continent arrivingContinent = prepareContinent(tripDTO.getDepartureFlightDTO().getArrivingAirport().getCityDTO().getCountryDTO().getContinentDTO(),session);

        //pregatesc continentele pentru sosire
        Continent returningDepartureContinent = null;
        if (!arrivingContinent.getName().equalsIgnoreCase(tripDTO.getReturningFlightDTO().getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO().getName())) {
            returningDepartureContinent = prepareContinent(tripDTO.getReturningFlightDTO().getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO(),session);
        }


        Continent returningArrivingContinent = null;
        if (!departureContinent.getName().equalsIgnoreCase(tripDTO.getReturningFlightDTO().getArrivingAirport().getCityDTO().getCountryDTO().getContinentDTO().getName())) {
            returningArrivingContinent = prepareContinent(tripDTO.getReturningFlightDTO().getArrivingAirport().getCityDTO().getCountryDTO().getContinentDTO(),session);
        }


        //pregatesc tara de la dus din punctul de plecare
        Country departureCountry = prepareCountry(tripDTO.getDepartureFlightDTO().getDepartureAirport().getCityDTO().getCountryDTO(),session);
        if (departureCountry.getContinent() == null) {
            departureCountry.setContinent(departureContinent);
        }

        //pregatesc tara de la dus din punctul de sosire
        Country arrivingCountry = prepareCountry(tripDTO.getDepartureFlightDTO().getArrivingAirport().getCityDTO().getCountryDTO(),session);
        if (arrivingCountry.getContinent() == null) {
            arrivingCountry.setContinent(arrivingContinent);
        }

        //pregatesc tara de la intors din punctul de plecare
        Country returningDepartureCountry = null;
        if (!arrivingCountry.getName().equalsIgnoreCase(tripDTO.getReturningFlightDTO().getDepartureAirport().getCityDTO().getCountryDTO().getName())) {
            returningDepartureCountry = prepareCountry(tripDTO.getReturningFlightDTO().getDepartureAirport().getCityDTO().getCountryDTO(),session);
            if (returningDepartureCountry.getContinent() == null) {
                if (returningDepartureContinent == null) {
                    returningDepartureCountry.setContinent(arrivingContinent);
                } else {
                    returningDepartureCountry.setContinent(returningDepartureContinent);
                }
            }
        }

        //pregatesc tara de la intors din punctul de sosire
        Country returningArrivingCountry = null;
        if (!departureCountry.getName().equalsIgnoreCase(tripDTO.getReturningFlightDTO().getArrivingAirport().getCityDTO().getCountryDTO().getName())) {
            returningArrivingCountry = prepareCountry(tripDTO.getReturningFlightDTO().getArrivingAirport().getCityDTO().getCountryDTO(),session);
            if (returningArrivingCountry.getContinent() == null) {
                if (returningArrivingContinent == null) {
                    returningArrivingCountry.setContinent(departureContinent);
                } else {
                    returningArrivingCountry.setContinent(returningArrivingContinent);
                }
            }
        }

        //pregatesc orasul de la dus din punctul de plecare
        City departureCity = prepareCity(tripDTO.getDepartureFlightDTO().getDepartureAirport().getCityDTO(),session);
        if (departureCity.getCountry() == null) {
            departureCity.setCountry(departureCountry);
        }

        //pregatesc orasul de la dus din punctul de sosire
        City arrivingCity = prepareCity(tripDTO.getDepartureFlightDTO().getArrivingAirport().getCityDTO(),session);
        if (arrivingCity.getCountry() == null) {
            arrivingCity.setCountry(arrivingCountry);
        }

        //pregatesc orasul de la intoarcere din punctul de plecare
        City returningDepartureCity = null;
        if (!tripDTO.getReturningFlightDTO().getDepartureAirport().getCityDTO().getName().equalsIgnoreCase(arrivingCity.getName())) {
            returningDepartureCity = prepareCity(tripDTO.getReturningFlightDTO().getDepartureAirport().getCityDTO(),session);
            if (returningDepartureCity.getCountry() == null) {
                if (returningDepartureCountry == null) {
                    returningDepartureCity.setCountry(arrivingCountry);
                } else {
                    returningDepartureCity.setCountry(returningDepartureCountry);
                }
            }
        }

        //pregatesc orasul de la intoarcere din punctul de sosire
        City returningArrivingCity = null;
        if (!tripDTO.getReturningFlightDTO().getArrivingAirport().getCityDTO().getName().equalsIgnoreCase(departureCity.getName())) {
            returningArrivingCity = prepareCity(tripDTO.getReturningFlightDTO().getArrivingAirport().getCityDTO(),session);
            if (returningArrivingCity.getCountry() == null) {
                if (returningArrivingCountry == null) {
                    returningArrivingCity.setCountry(departureCountry);
                } else {
                    returningArrivingCity.setCountry(returningArrivingCountry);
                }
            }
        }

        //pregatesc aeroportul de la dus din punctul de plecare
        Airport departureAirport = prepareAirport(tripDTO.getDepartureFlightDTO().getDepartureAirport(),session);
        if (departureAirport.getCity() == null) {
            departureAirport.setCity(departureCity);
        }

        //pregatesc aeroportul de la dus din punctul de sosire
        Airport arrivingAirport = prepareAirport(tripDTO.getDepartureFlightDTO().getArrivingAirport(),session);
        if (arrivingAirport.getCity() == null) {
            arrivingAirport.setCity(arrivingCity);
        }

        //pregatesc aeroportul de la intors din punctul de plecare
        Airport returningDepartureAirport = null;
        if (!arrivingAirport.getName().equalsIgnoreCase(tripDTO.getReturningFlightDTO().getDepartureAirport().getName())) {
            returningDepartureAirport = prepareAirport(tripDTO.getReturningFlightDTO().getDepartureAirport(),session);
            if (returningDepartureAirport.getCity() == null) {
                returningDepartureAirport.setName(tripDTO.getReturningFlightDTO().getDepartureAirport().getName());
                if (returningDepartureCity != null) {
                    returningDepartureAirport.setCity(returningDepartureCity);
                } else {
                    returningDepartureAirport.setCity(arrivingCity);
                }
            }
        }

        //pregatesc aeroportul de la intors din punctul de sosire
        Airport returningArrivingAirport = null;
        if (!departureAirport.getName().equalsIgnoreCase(tripDTO.getReturningFlightDTO().getArrivingAirport().getName())) {
            returningArrivingAirport = prepareAirport(tripDTO.getReturningFlightDTO().getArrivingAirport(),session);
            if (returningArrivingAirport.getCity() == null) {
                if (returningArrivingCity != null) {
                    returningArrivingAirport.setCity(returningArrivingCity);
                } else {
                    returningArrivingAirport.setCity(departureCity);
                }
            }
        }
        System.out.println("Aeroportul de la intoarcere " + returningArrivingAirport);

        Flight departureFlight = prepareFlight(tripDTO.getDepartureFlightDTO(),session);
        if (departureFlight.getDepartureAirport() == null) {
            departureFlight.setDepartureAirport(departureAirport);
        }


        if (departureFlight.getArrivingAirport() == null) {
            departureFlight.setArrivingAirport(arrivingAirport);
        }

        Flight returningFlight = prepareFlight(tripDTO.getReturningFlightDTO(),session);
        if (returningFlight.getDepartureAirport() == null) {
            if (returningDepartureAirport == null) {
                returningFlight.setDepartureAirport(arrivingAirport);
            } else {
                returningFlight.setDepartureAirport(returningDepartureAirport);
            }
        }

        if (returningFlight.getArrivingAirport() == null) {
            if (returningArrivingAirport == null) {
                returningFlight.setArrivingAirport(departureAirport);
            } else {
                returningFlight.setArrivingAirport(returningArrivingAirport);
            }
        }


        Trip trip = new Trip();
        trip.setName(tripDTO.getName());
        trip.setDepartureFlight(departureFlight);
        trip.setReturningFlight(returningFlight);
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
        tripDAO.insertTrip(trip,session);

        session.getTransaction().commit();
        session.close();



       /* Airport departureFlightDepartureAirport = prepareAirport(tripDTO.getDepartureFlightDTO().getDepartureAirport());
        City departureFlightDepartureCity = prepareCity(tripDTO.getDepartureFlightDTO().getDepartureAirport().getCityDTO());
        Country departureFlightDepartureCountry = prepareCountry(tripDTO.getDepartureFlightDTO().getDepartureAirport().getCityDTO().getCountryDTO());
        Continent departureContinent = prepareContinent(tripDTO.getDepartureFlightDTO().getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO());

        Airport departureFlightArrivingAirport = prepareAirport(tripDTO.getDepartureFlightDTO().getArrivingAirport());
        City departureFlightArrivingCity = prepareCity(tripDTO.getDepartureFlightDTO().getArrivingAirport().getCityDTO());
        Country departureFlightArrivingCountry = prepareCountry(tripDTO.getDepartureFlightDTO().getArrivingAirport().getCityDTO().getCountryDTO());
        Continent departureFlightArrivingContinent = prepareContinent(tripDTO.getDepartureFlightDTO().getArrivingAirport().getCityDTO().getCountryDTO().getContinentDTO());


        departureFlightDepartureCountry.setContinent(departureFlightDepartureContinent);
        departureFlightDepartureCity.setCountry(departureFlightDepartureCountry);
        departureFlight.setDepartureAirport(departureFlightDepartureAirport);


        if (departureFlightArrivingContinent.getName().equalsIgnoreCase(departureFlightDepartureContinent.getName())) {
            departureFlightArrivingContinent.setId(departureFlightDepartureContinent.getId());
        }

        departureFlightArrivingCountry.setContinent(departureFlightArrivingContinent);
        departureFlightArrivingCity.setCountry(departureFlightArrivingCountry);
        departureFlightArrivingAirport.setCity(departureFlightArrivingCity);

        departureFlight.setFlightNumber(tripDTO.getDepartureFlightDTO().getFlightNumber());
        departureFlight.setSeatsAvailable(tripDTO.getDepartureFlightDTO().getSeatsAvailable());
        departureFlight.setPrice(tripDTO.getDepartureFlightDTO().getPrice());
        departureFlight.setDepartureDateAndTime(tripDTO.getDepartureFlightDTO().getDepartureDateAndTime());
        departureFlight.setArrivingDateAndTime(tripDTO.getDepartureFlightDTO().getArrivingDateAndTime());

        trip.setDepartureFlight(departureFlight);



        Flight returningFlight = new Flight();

        Continent returningFlightDepartureContinent = prepareContinent(tripDTO.getReturningFlightDTO().getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO());
        Country returningFlightDepartureCountry = prepareCountry(tripDTO.getReturningFlightDTO().getDepartureAirport().getCityDTO().getCountryDTO());
        City returningFlightDepartureCity = prepareCity(tripDTO.getReturningFlightDTO().getDepartureAirport().getCityDTO());
        Airport returningFlightDepartureAirport = prepareAirport(tripDTO.getReturningFlightDTO().getDepartureAirport());

        Continent returningFlightArrivingContinent = prepareContinent(tripDTO.getReturningFlightDTO().getArrivingAirport().getCityDTO().getCountryDTO().getContinentDTO());
        Country returningFlightArrivingCountry = prepareCountry(tripDTO.getReturningFlightDTO().getArrivingAirport().getCityDTO().getCountryDTO());
        City returningFlightArrivingCity = prepareCity(tripDTO.getReturningFlightDTO().getArrivingAirport().getCityDTO());
        Airport returningFlightArrivingAirport = prepareAirport(tripDTO.getReturningFlightDTO().getArrivingAirport());

        if (returningFlightDepartureContinent.getName().equalsIgnoreCase(departureFlightArrivingContinent.getName())) {
            returningFlightDepartureContinent.setId(departureFlightArrivingContinent.getId());
        }

        if (returningFlightDepartureCountry.getName().equalsIgnoreCase(departureFlightArrivingCountry.getName())) {
            returningFlightDepartureCountry.setId(departureFlightArrivingCountry.getId());
        }

        if (returningFlightDepartureCity.getName().equalsIgnoreCase(departureFlightArrivingCity.getName())) {
            returningFlightDepartureCity.setId(departureFlightArrivingCity.getId());
        }

        if (returningFlightDepartureAirport.getName().equalsIgnoreCase(departureFlightArrivingAirport.getName())) {
            returningFlightDepartureAirport.setId(departureFlightArrivingAirport.getId());
        }

        returningFlightDepartureCountry.setContinent(returningFlightDepartureContinent);
        returningFlightDepartureCity.setCountry(returningFlightDepartureCountry);
        returningFlightDepartureAirport.setCity(returningFlightDepartureCity);
        returningFlight.setDepartureAirport(returningFlightDepartureAirport);


        if (returningFlightArrivingContinent.getName().equalsIgnoreCase(departureFlightDepartureContinent.getName())) {
            returningFlightArrivingContinent.setId(departureFlightDepartureContinent.getId());
        } else if (returningFlightArrivingContinent.getName().equalsIgnoreCase(returningFlightDepartureContinent.getName())) {
            returningFlightArrivingContinent.setId(returningFlightDepartureContinent.getId());
        }

        if (returningFlightArrivingCountry.getName().equalsIgnoreCase(departureFlightDepartureCountry.getName())) {
            returningFlightArrivingCountry.setId(departureFlightDepartureCountry.getId());
        }

        if (returningFlightArrivingCity.getName().equalsIgnoreCase(departureFlightDepartureCity.getName())) {
            returningFlightArrivingCity.setId(departureFlightDepartureCity.getId());
        }

        if (returningFlightArrivingAirport.getName().equalsIgnoreCase(departureFlightDepartureAirport.getName())) {
            returningFlightArrivingAirport.setId(departureFlightDepartureAirport.getId());
        }

        returningFlightArrivingCountry.setContinent(returningFlightArrivingContinent);
        returningFlightArrivingCity.setCountry(returningFlightArrivingCountry);
        returningFlightArrivingAirport.setCity(returningFlightArrivingCity);
        returningFlight.setArrivingAirport(returningFlightArrivingAirport);

        returningFlight.setFlightNumber(tripDTO.getReturningFlightDTO().getFlightNumber());
        returningFlight.setDepartureDateAndTime(tripDTO.getReturningFlightDTO().getDepartureDateAndTime());
        returningFlight.setArrivingDateAndTime(tripDTO.getReturningFlightDTO().getArrivingDateAndTime());
        returningFlight.setPrice(tripDTO.getReturningFlightDTO().getPrice());
        returningFlight.setSeatsAvailable(tripDTO.getReturningFlightDTO().getSeatsAvailable());


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
            trip.setStayingHotel(hotelFound);*/


    }


    private Flight prepareFlight(FlightDTO flightDTO,Session session) {
        Flight flight;
        if (flightDAO.findFlightByFlightNumber(flightDTO.getFlightNumber(),session) == null) {
            flight = new Flight();
            flight.setFlightNumber(flightDTO.getFlightNumber());
            flight.setSeatsAvailable(flightDTO.getSeatsAvailable());
            flight.setPrice(flightDTO.getPrice());
            flight.setDepartureDateAndTime(flightDTO.getDepartureDateAndTime());
            flight.setArrivingDateAndTime(flightDTO.getArrivingDateAndTime());
        } else {
            flight = flightDAO.findFlightByFlightNumber(flightDTO.getFlightNumber(),session);
        }
        return flight;
    }


    private Airport prepareAirport(AirportDTO airportDTO,Session session) {
        Airport airport;
        if (airportDAO.findAirportByName(airportDTO.getName()) == null) {
            airport = new Airport();
            airport.setName(airportDTO.getName());
        } else {
            airport = airportDAO.findAirportByName(airportDTO.getName());
        }
        return airport;
    }

    private City prepareCity(CityDTO cityDTO,Session session) {
        City city;
        if (cityDAO.findCity(cityDTO.getName(),session) == null) {
            city = new City();
            city.setName(cityDTO.getName());
        } else {
            city = cityDAO.findCity(cityDTO.getName(),session);
        }
        return city;
    }

    private Country prepareCountry(CountryDTO countryDTO,Session session) {
        Country country;
        if (countryDAO.findCountry(countryDTO.getName(),session) == null) {
            country = new Country();
            country.setName(countryDTO.getName());
        } else {
            country = countryDAO.findCountry(countryDTO.getName(),session);
        }
        return country;
    }

    private Continent prepareContinent(ContinentDTO continentDTO,Session session) {
        Continent continent;
        if (continentDAO.findContinent(continentDTO.getName(),session) == null) {
            continent = new Continent();
            continent.setName(continentDTO.getName());
        } else {
            continent = continentDAO.findContinent(continentDTO.getName(),session);
        }
        return continent;
    }


    private double calculateTripsPrice(TripDTO tripDTO) {
        double totalFlightPrice = (tripDTO.getDepartureFlightDTO().getPrice() * (tripDTO.getNumberOfAdults() + tripDTO.getNumberOfChildren()))
                + (tripDTO.getReturningFlightDTO().getPrice() * (tripDTO.getNumberOfAdults() + tripDTO.getNumberOfChildren()));
        return ((tripDTO.getPriceForAdult() * tripDTO.getNumberOfAdults() + (tripDTO.getPriceForChild() * tripDTO.getNumberOfChildren())) + totalFlightPrice);
    }


}