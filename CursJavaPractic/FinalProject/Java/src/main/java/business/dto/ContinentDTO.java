package business.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContinentDTO {
    @NotNull
    @NotBlank(message = "Campul este gol")
    @Pattern(regexp = "([a-z A-Z])*")
    @NotEmpty
    private String name;

    public ContinentDTO( String name) {
        this.name = name;
    }

    public ContinentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ContinentDTO: " + name ;
    }
}
