package business.service;

import business.dto.ContinentDTO;
import business.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.ContinentDAO;
import persistence.dao.CountryDAO;
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

    public void insertCountry(CountryDTO countryDTO) {
        Country country = new Country();
        country.setName(countryDTO.getName());
        Continent continentFound = continentDAO.findContinent(countryDTO.getContinentDTO().getName());
        if (continentFound == null) {
            Continent continent = new Continent();
            continent.setName(countryDTO.getContinentDTO().getName());
            country.setContinent(continent);
        } else {
            country.setContinent(continentFound);
        }
        countryDAO.insertCountry(country);
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

    public List<CountryDTO> findCountriesDTO(String continentName) {
        List<CountryDTO> countryDTOList = new LinkedList<>();
        List<Country> countryList = countryDAO.findCountries(continentName);

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
        int result = countryDAO.deleteCountry(name);
        return result;
    }

    public int changeCountryName(String newName, String name) {
        int result = countryDAO.changeCountryName(newName, name);
        return result;
    }
}
