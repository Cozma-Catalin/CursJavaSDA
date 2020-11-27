package business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CountryDTO {
    @NotNull
    @NotEmpty
    @NotBlank(message = "Empty field!")
    @Pattern(regexp = "([a-z A-Z])*")
    private String name;


    private ContinentDTO continentDTO;

    public CountryDTO( String name,ContinentDTO continentDTO) {
        this.name = name;
        this.continentDTO = continentDTO;
    }

    public CountryDTO( String name) {
        this.name = name;
    }

    public CountryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContinentDTO getContinentDTO() {
        return continentDTO;
    }

    public void setContinentDTO(ContinentDTO continentDTO) {
        this.continentDTO = continentDTO;
    }

    @Override
    public String toString() {
        return "CountryDTO: " + name + "," + continentDTO ;
    }
}
