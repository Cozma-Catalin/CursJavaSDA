package business.service;

import business.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CityDAO;
import persistence.dao.ContinentDAO;
import persistence.dao.CountryDAO;
import persistence.dao.HotelDAO;
import persistence.entities.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class HotelService {
    @Autowired
    HotelDAO hotelDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    ContinentDAO continentDAO;

    public void insertHotelDTO(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setAddress(hotelDTO.getAddress());
        hotel.setNumberOfStars(hotelDTO.getNumberOfStars());
        setRoomsInHotel(hotelDTO, hotel);
        hotel.setDescription(hotelDTO.getDescription());
        setCity(hotelDTO, hotel);
        hotelDAO.insertHotel(hotel);
    }

    private void setRoomsInHotel(HotelDTO hotelDTO, Hotel hotel) {
        Set<Room> roomSet = new HashSet<>();
        for(RoomDTO r : hotelDTO.getRooms()){
            Room room = new Room();
            room.setRoomType(r.getRoomType());
            room.setNumberOfRooms(r.getNumberOfRooms());
            room.setExtraBed(r.isExtraBed());
            room.setPrice(r.getPrice());
            room.setRoomsAvailable(r.getRoomsAvailable());
            roomSet.add(room);
        }
        hotel.setRoomSet(roomSet);
    }

    public void setCity(HotelDTO hotelDTO, Hotel hotel) {
        City cityFound = cityDAO.findCity(hotelDTO.getCity().getName());
        if (cityFound != null) {
            hotel.setCity(cityFound);
        } else {
            City city = new City();
            city.setName(hotelDTO.getCity().getName());
            setCountry(hotelDTO, city);
            hotel.setCity(city);
        }
    }

    private void setCountry(HotelDTO hotelDTO, City city) {
        Country countryFound = countryDAO.findCountry(hotelDTO.getCity().getCountry().getName());
        if (countryFound != null) {
            city.setCountry(countryFound);
        } else {
            Country country = new Country();
            country.setName(hotelDTO.getCity().getCountry().getName());
            setContinent(hotelDTO, country);
            city.setCountry(country);
        }
    }

    private void setContinent(HotelDTO hotelDTO, Country country) {
        Continent continentFound = continentDAO.findContinent(hotelDTO.getCity().getCountry().getContinent().getName());
        if (continentFound != null) {
            country.setContinent(continentFound);
        } else {
            Continent continent = new Continent(hotelDTO.getCity().getCountry().getContinent().getName());
            country.setContinent(continent);
        }
    }

    private void setRoomsInHotelDTO(HotelDTO hotelDTO, Hotel hotel) {
        Set<RoomDTO> roomDTOSet = new HashSet<>();
        for(Room r : hotel.getRoomSet()){
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setRoomType(r.getRoomType());
            roomDTO.setNumberOfRooms(r.getNumberOfRooms());
            roomDTO.setExtraBed(r.isExtraBed());
            roomDTO.setPrice(r.getPrice());
            roomDTO.setRoomsAvailable(r.getRoomsAvailable());
            roomDTOSet.add(roomDTO);
        }
        hotelDTO.setRooms(roomDTOSet);
    }

    public List<HotelDTO> findHotelsInCity(String cityName) {
        List<HotelDTO> hotelDTOList = new LinkedList<>();
        List<Hotel> hotelList = hotelDAO.findHotelsInCity(cityName);
        for (Hotel h : hotelList) {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setName(h.getName());
            hotelDTO.setAddress(h.getAddress());
            hotelDTO.setNumberOfStars(h.getNumberOfStars());
            hotelDTO.setDescription(h.getDescription());
            setRoomsInHotelDTO(hotelDTO,h);

            ContinentDTO continentDTO = new ContinentDTO(h.getCity().getCountry().getContinent().getName());

            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setName(h.getCity().getCountry().getName());
            countryDTO.setContinent(continentDTO);

            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(h.getCity().getName());
            cityDTO.setCountry(countryDTO);
            hotelDTO.setCity(cityDTO);
            hotelDTOList.add(hotelDTO);
        }
        return hotelDTOList;
    }

    public List<HotelDTO> findHotel(String name) {
        List<HotelDTO> hotelDTOList = new LinkedList<>();
        List<Hotel> hotelList = hotelDAO.findHotel(name);

        for (Hotel h : hotelList) {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setName(h.getName());
            hotelDTO.setAddress(h.getAddress());
            hotelDTO.setNumberOfStars(h.getNumberOfStars());
            hotelDTO.setDescription(h.getDescription());
            setRoomsInHotelDTO(hotelDTO,h);
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(h.getCity().getName());
            hotelDTO.setCity(cityDTO);
            hotelDTOList.add(hotelDTO);
        }
        return hotelDTOList;
    }

    public HotelDTO findHotelByAddress(String address){
        HotelDTO hotelDTO = new HotelDTO();
        Hotel hotel = hotelDAO.findHotelByAddress(address);
        if(hotel == null){
            return null;
        }
        hotelDTO.setName(hotel.getName());
        hotelDTO.setAddress(address);
        hotelDTO.setNumberOfStars(hotel.getNumberOfStars());
        hotelDTO.setDescription(hotel.getDescription());
        setRoomsInHotelDTO(hotelDTO,hotel);

        ContinentDTO continentDTO = new ContinentDTO(hotel.getCity().getCountry().getContinent().getName());

        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(hotel.getCity().getCountry().getName());
        countryDTO.setContinent(continentDTO);

        CityDTO cityDTO = new CityDTO();
        cityDTO.setCountry(countryDTO);
        cityDTO.setName(hotel.getCity().getName());

        hotelDTO.setCity(cityDTO);
        return hotelDTO;
    }


    public long countHotelName(String name){
        return hotelDAO.countHotelName(name);
    }

    public List<String> countHotelAddress(String address){
        return hotelDAO.countHotelAddress(address);
    }

    public void deleteHotelByName(String hotelName) {
        hotelDAO.deleteHotelByName(hotelName);
    }

    public void deleteHotelByAddress(String address){
        hotelDAO.deleteHotelByAddress(address);
    }

    public void changeHotelName(String newName, String name){
        hotelDAO.changeHotelName(newName, name);
    }



}
