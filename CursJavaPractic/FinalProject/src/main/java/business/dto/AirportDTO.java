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
    private CityDTO cityDTO;

    public AirportDTO(String name, CityDTO cityDTO) {
        this.name = name;
        this.cityDTO = cityDTO;
    }

    public AirportDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
    }

    @Override
    public String toString() {
        return "AirportDTO: " + name + "," + cityDTO ;
    }
}
