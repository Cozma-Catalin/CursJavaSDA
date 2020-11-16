package business.dto;

public class CityDTO {
    private String name;
    private CountryDTO countryDTO;

    public CityDTO(String name, CountryDTO countryDTO) {
        this.name = name;
        this.countryDTO = countryDTO;
    }

    public CityDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDTO getCountryDTO() {
        return countryDTO;
    }

    public void setCountryDTO(CountryDTO countryDTO) {
        this.countryDTO = countryDTO;
    }

    @Override
    public String toString() {
        return "CityDTO: " + name + ", " + countryDTO ;
    }
}
