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
    @Valid
    private ContinentDTO continent;



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

    public ContinentDTO getContinent() {
        return continent;
    }

    public void setContinent(ContinentDTO continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "CountryDTO: " + name + "," + continent ;
    }
}
