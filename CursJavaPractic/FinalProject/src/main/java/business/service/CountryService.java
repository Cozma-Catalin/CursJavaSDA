package business.service;

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
public class CountryService {
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    ContinentDAO continentDAO;
    @Autowired
    CityDAO cityDAO;

    public void insertCountry(CountryDTO countryDTO) {
        Country country = new Country();
        country.setName(countryDTO.getName());
        setContinent(countryDTO, country);
        countryDAO.insertCountry(country);
    }

    public void setContinent(CountryDTO countryDTO, Country country) {
        Continent continentFound = continentDAO.findContinent(countryDTO.getContinentDTO().getName());
        if (continentFound == null) {
            Continent continent = new Continent();
            continent.setName(countryDTO.getContinentDTO().getName());
            country.setContinent(continent);
        } else {
            country.setContinent(continentFound);
        }
    }

    public long countCountryDTO(String name) {
        long result = countryDAO.countCountry(name);
        return result;
    }

    public CountryDTO findCountryDTO(String name) {
        Country country = countryDAO.findCountry(name);
        if (country == null) {
            return null;
        }
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(country.getName());
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setName(country.getContinent().getName());
        countryDTO.setContinentDTO(continentDTO);
        return countryDTO;
    }

    public List<CountryDTO> findCountriesInContinent(String continentName) {
        List<CountryDTO> countryDTOList = new LinkedList<>();
        List<Country> countryList = countryDAO.findCountriesInContinent(continentName);
        for (Country c : countryList) {
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setName(c.getName());
            ContinentDTO continentDTO = new ContinentDTO();
            continentDTO.setName(c.getContinent().getName());
            countryDTO.setContinentDTO(continentDTO);
            countryDTOList.add(countryDTO);
        }
        return countryDTOList;
    }

    public int deleteCountry(String name) {
        List<City> cityList = cityDAO.findCitiesInCountry(name);
        for(City c : cityList){
            cityDAO.deleteCity(c.getName());
        }
        int result = countryDAO.deleteCountry(name);
        return result;
    }

    public int changeCountryName(String newName, String name) {
        int result = countryDAO.changeCountryName(newName, name);
        return result;
    }
}
