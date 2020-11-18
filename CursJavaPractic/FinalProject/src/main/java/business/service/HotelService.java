package business.service;

import business.dto.HotelDTO;
import business.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CityDAO;
import persistence.dao.ContinentDAO;
import persistence.dao.CountryDAO;
import persistence.dao.HotelDAO;
import persistence.entities.*;

import java.util.HashSet;
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
        hotel.setNumberOfStars(hotelDTO.getNumberOfStars());
        hotel.setDescription(hotelDTO.getDescription());
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
        setCity(hotelDTO, hotel);
        hotelDAO.insertHotel(hotel);
    }

    private void setCity(HotelDTO hotelDTO, Hotel hotel) {
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
            setContinent(hotelDTO,country);
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

    public long countHotelDTO(String name) {
        long result = hotelDAO.countHotel(name);
        return result;
    }


}
