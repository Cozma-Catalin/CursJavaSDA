package business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class CityDTO {
    @NotNull
    @NotEmpty
    @NotBlank(message = "Empty field")
    @Pattern(regexp = "([a-z A-Z])*")
    private String name;

    @Valid
    private CountryDTO country;

    public CityDTO(String name) {
        this.name = name;
    }
}
