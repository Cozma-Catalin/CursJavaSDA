package business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
public class AirportDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    @NotNull
    @Valid
    private CityDTO city;

}
