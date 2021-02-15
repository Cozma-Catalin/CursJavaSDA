package business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([a-z A-Z])*")
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    private String address;

    @NotNull
    @Min(1)
    @Max(5)
    private double numberOfStars;

    @NotNull
    private String description;

    @NotNull @Valid
    private Set<RoomDTO> rooms;

    @Valid
    private CityDTO city;

}
