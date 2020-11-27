package business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class CityDTO {
    @NotNull
    @NotEmpty
    @NotBlank(message = "Campul este gol")
    @Pattern(regexp = "([a-z A-Z])*")
    private String name;

    @Valid
    private CountryDTO countryDTO;


    public CityDTO(String name,CountryDTO countryDTO) {
        this.name = name;
        this.countryDTO = countryDTO;
    }

    public CityDTO(String name) {
        this.name = name;
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
