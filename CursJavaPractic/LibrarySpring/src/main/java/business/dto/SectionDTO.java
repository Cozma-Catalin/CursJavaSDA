package business.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SectionDTO {

    @NotBlank(message = "Campul este gol.")
    @NotNull
    @Pattern(regexp = "([a-zA-Z])*")
    private String name;



    public SectionDTO(){}

    public SectionDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "SectionDTO: " + name ;
    }
}
