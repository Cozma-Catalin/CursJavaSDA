package business.service;

import business.dto.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import persistence.HibernateUtil;
import persistence.dao.*;
import persistence.entities.*;

import java.util.*;

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
    HotelDAO hotelDAO;
    @Autowired
    ContinentDAO continentDAO;
    @Autowired
    FlightDAO flightDAO;


    public void insertTrip(TripDTO tripDTO) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Continent departureContinent = prepareContinent(tripDTO.getDepartureFlightDTO().getDepartureAirport().getCityDTO().getCountryDTO().getContinentDTO(), session);
        Continent arrivingContinent = prepareContinent(tripDTO.getDepartureFlightDTO().getArrivingAirport().getCityDTO().getCountryDTO().getContinentDTO(), session);
        Continent returningDepartureContinent = setReturningContinent(session, arrivingContinent, tripDTO.getReturningFlightDTO().getDepartureAirport());
        Continent returningArrivingContinent = setReturningContinent(session, departureContinent, tripDTO.getReturningFlightDTO().getArrivingAirport());

        Country departureCountry = setDepartureCountry(session, departureContinent, tripDTO.getDepartureFlightDTO().getDepartureAirport());
        Country arrivingCountry = setDepartureCountry(session, arrivingContinent, tripDTO.getDepartureFlightDTO().getArrivingAirport());
        Country returningDepartureCountry = setCountryForReturningFlight(session, arrivingContinent, returningDepartureContinent, arrivingCountry, tripDTO.getReturningFlightDTO().getDepartureAirport());
        Country returningArrivingCountry = setCountryForReturningFlight(session, departureContinent, returningArrivingContinent, departureCountry, tripDTO.getReturningFlightDTO().getArrivingAirport());

        City departureCity = setCityForDepartureFlight(session, departureCountry, tripDTO.getDepartureFlightDTO().getDepartureAirport());
        City arrivingCity = setCityForDepartureFlight(session, arrivingCountry, tripDTO.getDepartureFlightDTO().getArrivingAirport());
        City returningDepartureCity = setCityForReturningFlight(session, arrivingCountry, returningDepartureCountry, arrivingCity, tripDTO.getReturningFlightDTO().getDepartureAirport());
        City returningArrivingCity = setCityForReturningFlight(session, departureCountry, returningArrivingCountry, departureCity, tripDTO.getReturningFlightDTO().getArrivingAirport());

        Airport departureAirport = setAirportForDepartureFlight(session, departureCity, tripDTO.getDepartureFlightDTO().getDepartureAirport());
        Airport arrivingAirport = setAirportForDepartureFlight(session, arrivingCity, tripDTO.getDepartureFlightDTO().getArrivingAirport());
        Airport returningDepartureAirport = setAirportForReturningFlight(session, arrivingCity, returningDepartureCity, arrivingAirport, tripDTO.getReturningFlightDTO().getDepartureAirport());
        Airport returningArrivingAirport = setAirportForReturningFlight(session, departureCity, returningArrivingCity, departureAirport, tripDTO.getReturningFlightDTO().getArrivingAirport());

        Flight departureFlight = setDepartureFlight(tripDTO, session, departureAirport, arrivingAirport);
        Flight returningFlight = setReturningFlight(tripDTO, session, departureAirport, arrivingAirport, returningDepartureAirport, returningArrivingAirport);

        Hotel stayingHotel = setHotel(tripDTO, departureFlight, arrivingCity, session);

        Trip trip = setTrip(tripDTO, departureFlight, returningFlight, stayingHotel);

        tripDAO.insertTrip(trip, session);
        session.getTransaction().commit();
        session.close();
    }

    private Trip setTrip(TripDTO tripDTO, Flight departureFlight, Flight returningFlight, Hotel stayingHotel) {
        Trip trip = new Trip();
        trip.setName(tripDTO.getName());
        trip.setDepartureFlight(departureFlight);
        trip.setStayingHotel(stayingHotel);
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
        return trip;
    }

    private Hotel setHotel(TripDTO tripDTO, Flight departureFlight, City arrivingCity, Session session) {
        City city = null;

        Hotel hotel = hotelDAO.findHotelByAddress(tripDTO.getStayingHotelDTO().getAddress());
        if (hotel == null) {
            hotel = new Hotel();
            hotel.setName(tripDTO.getStayingHotelDTO().getName());
            if (tripDTO.getStayingHotelDTO().getCityDTO().getName().equalsIgnoreCase(departureFlight.getArrivingAirport().getCity().getName())) {
                city = arrivingCity;
            } else {
                city = prepareCity(tripDTO.getStayingHotelDTO().getCityDTO(), session);
                if (city.getCountry() == null) {
                    Country country = prepareCountry(tripDTO.getStayingHotelDTO().getCityDTO().getCountryDTO(), session);
                    if (country.getContinent() == null) {
                        country.getContinent().setName(tripDTO.getStayingHotelDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
                    }
                    city.setCountry(country);
                }
            }
            hotel.setCity(city);
            hotel.setAddress(tripDTO.getStayingHotelDTO().getAddress());
            hotel.setDescription(tripDTO.getStayingHotelDTO().getDescription());
            hotel.setNumberOfStars(tripDTO.getStayingHotelDTO().getNumberOfStars());
            setRoomsForHotel(tripDTO, hotel);
        }
        return hotel;
    }


    private void setRoomsForHotel(TripDTO tripDTO, Hotel hotel) {
        Set<Room> rooms = new HashSet<>();
        for (RoomDTO roomDTO : tripDTO.getStayingHotelDTO().getRoomDTOSet()) {
            Room room = new Room();
            room.setRoomType(roomDTO.getRoomType());
            room.setNumberOfRooms(roomDTO.getNumberOfRooms());
            room.setExtraBed(roomDTO.isExtraBed());
            room.setRoomsAvailable(roomDTO.getRoomsAvailable());
            rooms.add(room);
        }
        hotel.setRoomSet(rooms);
    }

    private Flight setReturningFlight(TripDTO tripDTO, Session session, Airport departureAirport, Airport
            arrivingAirport, Airport returningDepartureAirport, Airport returningArrivingAirport) {
        Flight returningFlight = prepareFlight(tripDTO.getReturningFlightDTO(), session);
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
        return returningFlight;
    }

    private Flight setDepartureFlight(TripDTO tripDTO, Session session, Airport departureAirport, Airport
            arrivingAirport) {
        Flight departureFlight = prepareFlight(tripDTO.getDepartureFlightDTO(), session);
        if (departureFlight.getDepartureAirport() == null) {
            departureFlight.setDepartureAirport(departureAirport);
        }


        if (departureFlight.getArrivingAirport() == null) {
            departureFlight.setArrivingAirport(arrivingAirport);
        }
        return departureFlight;
    }


    private Airport setAirportForReturningFlight(Session session, City arrivingCity, City
            returningDepartureCity, Airport arrivingAirport, AirportDTO departureFlightDepartureAirport) {
        Airport returningDepartureAirport = null;
        if (!arrivingAirport.getName().equalsIgnoreCase(departureFlightDepartureAirport.getName())) {
            returningDepartureAirport = prepareAirport(departureFlightDepartureAirport, session);
            if (returningDepartureAirport.getCity() == null) {
                returningDepartureAirport.setName(departureFlightDepartureAirport.getName());
                if (returningDepartureCity != null) {
                    returningDepartureAirport.setCity(returningDepartureCity);
                } else {
                    returningDepartureAirport.setCity(arrivingCity);
                }
            }
        }
        return returningDepartureAirport;
    }

    private Airport setAirportForDepartureFlight(Session session, City departureCity, AirportDTO departureFlightDepartureAirport) {
        Airport departureAirport = prepareAirport(departureFlightDepartureAirport, session);
        if (departureAirport.getCity() == null) {
            departureAirport.setCity(departureCity);
        }
        return departureAirport;
    }

    private City setCityForReturningFlight(Session session, Country arrivingCountry, Country
            returningDepartureCountry, City arrivingCity, AirportDTO departureFlightDepartureAirport) {
        City returningDepartureCity = null;
        if (!departureFlightDepartureAirport.getCityDTO().getName().equalsIgnoreCase(arrivingCity.getName())) {
            returningDepartureCity = prepareCity(departureFlightDepartureAirport.getCityDTO(), session);
            if (returningDepartureCity.getCountry() == null) {
                if (returningDepartureCountry == null) {
                    returningDepartureCity.setCountry(arrivingCountry);
                } else {
                    returningDepartureCity.setCountry(returningDepartureCountry);
                }
            }
        }
        return returningDepartureCity;
    }

    private City setCityForDepartureFlight(Session session, Country departureCountry, AirportDTO departureFlightDepartureAirport) {
        City departureCity = prepareCity(departureFlightDepartureAirport.getCityDTO(), session);
        if (departureCity.getCountry() == null) {
            departureCity.setCountry(departureCountry);
        }
        return departureCity;
    }

    private Country setCountryForReturningFlight(Session session, Continent arrivingContinent, Continent
            returningDepartureContinent, Country arrivingCountry, AirportDTO departureFlightDepartureAirport) {
        Country returningDepartureCountry = null;
        if (!arrivingCountry.getName().equalsIgnoreCase(departureFlightDepartureAirport.getCityDTO().getCountryDTO().getName())) {
            returningDepartureCountry = prepareCountry(departureFlightDepartureAirport.getCityDTO().getCountryDTO(), session);
            if (returningDepartureCountry.getContinent() == null) {
                if (returningDepartureContinent == null) {
                    returningDepartureCountry.setContinent(arrivingContinent);
                } else {
                    returningDepartureCountry.setContinent(returningDepartureContinent);
                }
            }
        }
        return returningDepartureCountry;
    }

    private Country setDepartureCountry(Session session, Continent departureContinent, AirportDTO departureAirport2) {
        Country departureCountry = prepareCountry(departureAirport2.getCityDTO().getCountryDTO(), session);
        if (departureCountry.getContinent() == null) {
            departureCountry.setContinent(departureContinent);
        }
        return departureCountry;
    }

    private Continent setReturningContinent(Session session, Continent arrivingContinent, AirportDTO
            departureAirport2) {
        Continent returningDepartureContinent = null;
        if (!arrivingContinent.getName().equalsIgnoreCase(departureAirport2.getCityDTO().getCountryDTO().getContinentDTO().getName())) {
            returningDepartureContinent = prepareContinent(departureAirport2.getCityDTO().getCountryDTO().getContinentDTO(), session);
        }
        return returningDepartureContinent;
    }


    private Flight prepareFlight(FlightDTO flightDTO, Session session) {
        Flight flight = flightDAO.findFlightByFlightNumber(flightDTO.getFlightNumber(), session);
        if (flight == null) {
            flight = new Flight();
            flight.setFlightNumber(flightDTO.getFlightNumber());
            flight.setSeatsAvailable(flightDTO.getSeatsAvailable());
            flight.setPrice(flightDTO.getPrice());
            flight.setDepartureDate(flightDTO.getDepartureDate());
            flight.setDepartureTime(flightDTO.getDepartureTime());
            flight.setArrivingDate(flightDTO.getArrivingDate());
            flight.setArrivingTime(flightDTO.getArrivingTime());
        }
        return flight;
    }


    private Airport prepareAirport(AirportDTO airportDTO, Session session) {
        Airport airport = airportDAO.findAirportByName(airportDTO.getName());
        if (airport == null) {
            airport = new Airport();
            airport.setName(airportDTO.getName());
        }
        return airport;
    }

    private City prepareCity(CityDTO cityDTO, Session session) {
        City city = cityDAO.findCity(cityDTO.getName(), session);
        if (city == null) {
            city = new City();
            city.setName(cityDTO.getName());
        }
        return city;
    }

    private Country prepareCountry(CountryDTO countryDTO, Session session) {
        Country country = countryDAO.findCountry(countryDTO.getName(), session);
        if (country == null) {
            country = new Country();
            country.setName(countryDTO.getName());
        }
        return country;
    }

    private Continent prepareContinent(ContinentDTO continentDTO, Session session) {
        Continent continent = continentDAO.findContinent(continentDTO.getName(), session);
        if (continent == null) {
            continent = new Continent();
            continent.setName(continentDTO.getName());
        }
        return continent;
    }


    private double calculateTripsPrice(TripDTO tripDTO) {
        double totalFlightPrice = (tripDTO.getDepartureFlightDTO().getPrice() * (tripDTO.getNumberOfAdults() + tripDTO.getNumberOfChildren()))
                + (tripDTO.getReturningFlightDTO().getPrice() * (tripDTO.getNumberOfAdults() + tripDTO.getNumberOfChildren()));
        return ((tripDTO.getPriceForAdult() * tripDTO.getNumberOfAdults() + (tripDTO.getPriceForChild() * tripDTO.getNumberOfChildren())) + totalFlightPrice);
    }

    public long countTrips(String name, Date date) {
        long result = tripDAO.countTrips(name, date);
        return result;
    }

    public int deleteTripsByName(String name) {
        int result = tripDAO.deleteTripsByName(name);
        return result;
    }

    public List<TripDTO> findPromotedTrips(boolean promoted) {
        List<Trip> tripList = tripDAO.findPromotedTrips(promoted);
        return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByDepartureContinent(String continentName){
        List<Trip> tripList = tripDAO.findTripsByDepartureContinent(continentName);
        return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByArrivingContinent(String continentName){
        List<Trip> tripList = tripDAO.findTripsByArrivingContinent(continentName);
        return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByDepartureCountry(String countryName){
        List<Trip> tripList = tripDAO.findTripsByDepartureCountry(countryName);
       return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByArrivingCountry(String countryName){
        List<Trip> tripList = tripDAO.findTripsByArrivingCountry(countryName);
       return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByDepartureCity(String cityName){
        List<Trip> tripList = tripDAO.findTripsByDepartureCity(cityName);
       return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByArrivingCity(String cityName){
        List<Trip> tripList = tripDAO.findTripsByArrivingCity(cityName);
      return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByHotel(String hotelName){
        List<Trip> tripList = tripDAO.findTripsByHotel(hotelName);
      return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByDepartureAirport(String airportName){
        List<Trip> tripList = tripDAO.findTripsByDepartureAirport(airportName);
       return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByDepartureDate(java.sql.Date departureDate){
        List<Trip> tripList = tripDAO.findTripsByDepartureDate(departureDate);
      return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByReturnDate(java.sql.Date returnDate){
        List<Trip> tripList = tripDAO.findTripsByReturnDate(returnDate);
        return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByDepartureTimeFrame(java.sql.Date departureDate, java.sql.Date returnDate){
        List<Trip> tripList = tripDAO.findTripsByDepartureTimeFrame(departureDate,returnDate);
       return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByReturnTimeFrame(java.sql.Date departureDate, java.sql.Date returnDate){
        List<Trip> tripList = tripDAO.findTripsByReturnTimeFrame(departureDate,returnDate);
        return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByMealType(String mealType){
        List<Trip> tripList = tripDAO.findTripsByMealType(mealType);
       return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByHotelStars(double numberOfStars){
        List<Trip> tripList = tripDAO.findTripsByHotelStars(numberOfStars);
       return getTripDTOList(tripList);
    }

    public List<TripDTO> findTripsByNumberOfDays(int numberOfDays){
        List<Trip> tripList = tripDAO.findTripsByNumberOfDays(numberOfDays);
      return getTripDTOList(tripList);
    }

    public List<TripDTO> findAllTrips(){
        List<Trip> tripList = tripDAO.findAllTrips();
       return getTripDTOList(tripList);
    }

    private List<TripDTO> getTripDTOList(List<Trip> tripList) {
        List<TripDTO> tripDTOList = new LinkedList<>();
        for (Trip trip : tripList) {
            FlightDTO departureFlightDTO = setDepartureFlightDTO(trip.getDepartureFlight());
            FlightDTO returningFlightDTO = setReturningFlightDTO(trip.getReturningFlight());
            HotelDTO hotelDTO = setStayingHotel(trip.getStayingHotel());
            tripDTOList.add(getTripDTO(trip,departureFlightDTO, returningFlightDTO, hotelDTO));
        }
        return tripDTOList;
    }

    private TripDTO getTripDTO(Trip trip, FlightDTO departureFlightDTO, FlightDTO returningFlightDTO, HotelDTO hotelDTO) {
        TripDTO tripDTO = new TripDTO();
        tripDTO.setName(trip.getName());
        tripDTO.setDepartureDate(trip.getDepartureDate());
        tripDTO.setDepartureFlightDTO(departureFlightDTO);
        tripDTO.setReturnDate(trip.getReturnDate());
        tripDTO.setReturningFlightDTO(returningFlightDTO);
        tripDTO.setMealType(trip.getMealType());
        tripDTO.setStayingHotelDTO(hotelDTO);
        tripDTO.setNumberOfAdults(trip.getNumberOfAdults());
        tripDTO.setNumberOfChildren(trip.getNumberOfChildren());
        tripDTO.setNumberOfDays(trip.getNumberOfDays());
        tripDTO.setPriceForAdult(trip.getPriceForAdult());
        tripDTO.setPriceForChild(trip.getPriceForChild());
        tripDTO.setNumberOfTripsAvailable(trip.getNumberOfTripsAvailable());
        tripDTO.setTripsPrice(trip.getTripsPrice());
        return tripDTO;
    }

    private FlightDTO setDepartureFlightDTO(Flight departureFlight) {
        FlightDTO departureFlightDTO = new FlightDTO();
        departureFlightDTO.setFlightNumber(departureFlight.getFlightNumber());
        departureFlightDTO.setSeatsAvailable(departureFlight.getSeatsAvailable());
        departureFlightDTO.setPrice(departureFlight.getPrice());
        departureFlightDTO.setDepartureDate(departureFlight.getDepartureDate());
        departureFlightDTO.setDepartureTime(departureFlight.getDepartureTime());
        departureFlightDTO.setArrivingDate(departureFlight.getArrivingDate());
        departureFlightDTO.setArrivingTime(departureFlight.getArrivingTime());

        setDepartureAirportDTO(departureFlightDTO,departureFlight.getDepartureAirport());
        setArrivingAirportDTO(departureFlight, departureFlightDTO);
        return departureFlightDTO;
    }

    private void setArrivingAirportDTO(Flight departureFlight, FlightDTO departureFlightDTO) {
        Airport arrivingAirport = departureFlight.getArrivingAirport();
        AirportDTO arrivingAirportDTO = new AirportDTO();
        arrivingAirportDTO.setName(arrivingAirport.getName());
        ContinentDTO arrivingContinentDTO = new ContinentDTO(arrivingAirport.getCity().getCountry().getContinent().getName());
        CountryDTO arrivingCountryDTO = new CountryDTO(arrivingAirport.getCity().getCountry().getName());
        arrivingCountryDTO.setContinentDTO(arrivingContinentDTO);
        CityDTO arrivingCityDTO = new CityDTO(arrivingAirport.getCity().getName());
        arrivingCityDTO.setCountryDTO(arrivingCountryDTO);
        arrivingAirportDTO.setCityDTO(arrivingCityDTO);
        departureFlightDTO.setArrivingAirport(arrivingAirportDTO);
    }

    private void setDepartureAirportDTO(FlightDTO departureFlightDTO, Airport departureAirport) {
        AirportDTO departureAirportDTO = new AirportDTO();
        departureAirportDTO.setName(departureAirport.getName());
        ContinentDTO departureContinentDTO = new ContinentDTO(departureAirport.getCity().getCountry().getContinent().getName());
        CountryDTO departureCountryDTO = new CountryDTO(departureAirport.getCity().getCountry().getName());
        departureCountryDTO.setContinentDTO(departureContinentDTO);
        CityDTO departureCityDTO = new CityDTO(departureAirport.getCity().getName());
        departureCityDTO.setCountryDTO(departureCountryDTO);
        departureAirportDTO.setCityDTO(departureCityDTO);
        departureFlightDTO.setDepartureAirport(departureAirportDTO);
    }

    private FlightDTO setReturningFlightDTO(Flight returningFlight) {
        FlightDTO returningFlightDTO = new FlightDTO();
        returningFlightDTO.setFlightNumber(returningFlight.getFlightNumber());
        returningFlightDTO.setSeatsAvailable(returningFlight.getSeatsAvailable());
        returningFlightDTO.setPrice(returningFlight.getPrice());
        returningFlightDTO.setDepartureDate(returningFlight.getDepartureDate());
        returningFlightDTO.setDepartureTime(returningFlight.getDepartureTime());
        returningFlightDTO.setArrivingDate(returningFlight.getArrivingDate());
        returningFlightDTO.setArrivingTime(returningFlight.getArrivingTime());

        setDepartureAirportDTO(returningFlightDTO,returningFlight.getDepartureAirport());
        setArrivingAirportDTO(returningFlight, returningFlightDTO);
        return returningFlightDTO;
    }

    private HotelDTO setStayingHotel(Hotel hotel){
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setName(hotel.getName());
        hotelDTO.setAddress(hotel.getAddress());
        hotelDTO.setNumberOfStars(hotel.getNumberOfStars());
        hotelDTO.setDescription(hotel.getDescription());
        ContinentDTO continentDTO = new ContinentDTO(hotel.getCity().getCountry().getContinent().getName());
        CountryDTO countryDTO = new CountryDTO(hotel.getCity().getCountry().getName());
        countryDTO.setContinentDTO(continentDTO);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(hotel.getCity().getName());
        cityDTO.setCountryDTO(countryDTO);
        hotelDTO.setCityDTO(cityDTO);

        hotelDTO.setRoomDTOSet(getRoomDTOS(hotel));
        return hotelDTO;
    }

    private Set<RoomDTO> getRoomDTOS(Hotel hotel) {
        Set<RoomDTO> roomDTOSet = new HashSet<>();
        for(Room room : hotel.getRoomSet()){
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setNumberOfRooms(room.getNumberOfRooms());
            roomDTO.setRoomType(room.getRoomType());
            roomDTO.setRoomsAvailable(room.getRoomsAvailable());
            roomDTO.setExtraBed(room.isExtraBed());
            roomDTOSet.add(roomDTO);
        }
        return roomDTOSet;
    }
}