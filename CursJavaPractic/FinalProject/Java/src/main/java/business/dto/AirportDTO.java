package business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AirportDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    @NotNull
    @Valid
    private CityDTO city;



    public AirportDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AirportDTO: " + name + "," + city ;
    }
}
