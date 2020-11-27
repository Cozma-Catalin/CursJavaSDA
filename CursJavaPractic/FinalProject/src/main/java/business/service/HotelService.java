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
        setRooms(hotelDTO, hotel);
        hotel.setDescription(hotelDTO.getDescription());
        setCity(hotelDTO, hotel);
        hotelDAO.insertHotel(hotel);
    }

    private void setRooms(HotelDTO hotelDTO, Hotel hotel) {
        Set<Room> roomSet = new HashSet<>();
        for(RoomDTO r : hotelDTO.getRoomDTOSet()){
            Room room = new Room();
            room.setRoomType(r.getRoomType());
            room.setNumberOfRooms(r.getNumberOfRooms());
            room.setExtraBed(r.isExtraBed());
            room.setRoomsAvailable(r.getRoomsAvailable());
            roomSet.add(room);
        }
        hotel.setRoomSet(roomSet);
    }

    public void setCity(HotelDTO hotelDTO, Hotel hotel) {
        City cityFound = cityDAO.findCity(hotelDTO.getCityDTO().getName());
        if (cityFound != null) {
            hotel.setCity(cityFound);
        } else {
            City city = new City();
            city.setName(hotelDTO.getCityDTO().getName());
            setCountry(hotelDTO, city);
            hotel.setCity(city);
        }
    }

    private void setCountry(HotelDTO hotelDTO, City city) {
        Country countryFound = countryDAO.findCountry(hotelDTO.getCityDTO().getCountryDTO().getName());
        if (countryFound != null) {
            city.setCountry(countryFound);
        } else {
            Country country = new Country();
            country.setName(hotelDTO.getCityDTO().getCountryDTO().getName());
            setContinent(hotelDTO, country);
            city.setCountry(country);
        }
    }

    private void setContinent(HotelDTO hotelDTO, Country country) {
        Continent continentFound = continentDAO.findContinent(hotelDTO.getCityDTO().getCountryDTO().getContinentDTO().getName());
        if (continentFound != null) {
            country.setContinent(continentFound);
        } else {
            Continent continent = new Continent(hotelDTO.getCityDTO().getCountryDTO().getContinentDTO().getName());
            country.setContinent(continent);
        }
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

            ContinentDTO continentDTO = new ContinentDTO();
            continentDTO.setName(h.getCity().getCountry().getContinent().getName());

            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setName(h.getCity().getCountry().getName());
            countryDTO.setContinentDTO(continentDTO);

            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(h.getCity().getName());
            cityDTO.setCountryDTO(countryDTO);
            hotelDTO.setCityDTO(cityDTO);
            hotelDTOList.add(hotelDTO);
        }
        return hotelDTOList;
    }

    public List<HotelDTO> findHotel(String name) {
        List<HotelDTO> hotelDTOList = new LinkedList<>();
        List<Hotel> hotelList = hotelDAO.findHotel(name);
        if(hotelList.isEmpty()){
            return null;
        }
        for (Hotel h : hotelList) {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setName(h.getName());
            hotelDTO.setAddress(h.getAddress());
            hotelDTO.setNumberOfStars(h.getNumberOfStars());
            hotelDTO.setDescription(h.getDescription());
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(h.getCity().getName());
            hotelDTO.setCityDTO(cityDTO);
            hotelDTOList.add(hotelDTO);
        }
        return hotelDTOList;
    }

    public HotelDTO findHotelByAddress(String address){
        HotelDTO hotelDTO = new HotelDTO();
        Hotel hotel = hotelDAO.findHotelByAddress(address);
        hotelDTO.setName(hotel.getName());
        hotelDTO.setAddress(address);
        hotelDTO.setNumberOfStars(hotel.getNumberOfStars());
        hotelDTO.setDescription(hotel.getDescription());
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(hotel.getCity().getName());
        hotelDTO.setCityDTO(cityDTO);
        return hotelDTO;
    }


    public long countHotelName(String name){
        long result = hotelDAO.countHotelName(name);
        return result;
    }

    public List<String> countAddressInCity(String address){
        List<String> result = hotelDAO.countAddressInCity(address);
        return result;
    }

    public int deleteHotelByName(String hotelName) {
        int result = hotelDAO.deleteHotelByName(hotelName);
        return result;
    }

    public int deleteHotelByAddress(String address){
        int result = hotelDAO.deleteHotelByAddress(address);
        return result;
    }

    public int changeHotelName(String newName,String name){
        int result = hotelDAO.changeHotelName(newName,name);
        return result;
    }

}
