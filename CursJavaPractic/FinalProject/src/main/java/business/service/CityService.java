package business.service;


import business.dto.CityDTO;
import business.dto.ContinentDTO;
import business.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CityDAO;
import persistence.dao.ContinentDAO;
import persistence.dao.CountryDAO;
import persistence.entities.City;
import persistence.entities.Continent;
import persistence.entities.Country;

import java.util.LinkedList;
import java.util.List;

@Service
public class CityService {
    @Autowired
    CityDAO cityDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    ContinentDAO continentDAO;

    public void insertCityDTO(CityDTO cityDTO) {
        City city = new City();
        city.setName(cityDTO.getName());
        Country countryFound = countryDAO.findCountry(cityDTO.getCountryDTO().getName());
        if (countryFound == null) {
            Country country = new Country();
            country.setName(cityDTO.getCountryDTO().getName());
            city.setCountry(country);
        } else {
            city.setCountry(countryFound);
        }
        cityDAO.insertCity(city);
    }

    public long countCityDTO(String name) {
        long result = cityDAO.countCity(name);
        return result;
    }

    public int deleteCityDTO(String name) {
        int result = cityDAO.deleteCity(name);
        return result;
    }

    public int changeCityDTOName(String newName, String name) {
        int result = cityDAO.changeCityName(newName, name);
        return result;
    }

    public CityDTO findCityDTO(String name) {
        City city = cityDAO.findCity(name);
        if (city == null) {
            return null;
        }
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(city.getName());
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(city.getCountry().getName());
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setName(city.getCountry().getContinent().getName());
        countryDTO.setContinentDTO(continentDTO);
        cityDTO.setCountryDTO(countryDTO);
        return cityDTO;
    }

    public List<CityDTO> findCitiesDTO(String countryName) {
        List<City> cityList = cityDAO.findCities(countryName);
        List<CityDTO> cityDTOList = new LinkedList<>();
        for (City c : cityList) {
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(c.getName());
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setName(c.getCountry().getName());
            ContinentDTO continentDTO = new ContinentDTO();
            continentDTO.setName(c.getCountry().getContinent().getName());
            countryDTO.setContinentDTO(continentDTO);
            cityDTO.setCountryDTO(countryDTO);
            cityDTOList.add(cityDTO);
        }
        return cityDTOList;
    }

}
