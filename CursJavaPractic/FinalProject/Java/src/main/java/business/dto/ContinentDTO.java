package business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContinentDTO {
    @NotNull
    @NotBlank(message = "Empty field")
    @Pattern(regexp = "([a-z A-Z])*")
    @NotEmpty
    private String name;


}
