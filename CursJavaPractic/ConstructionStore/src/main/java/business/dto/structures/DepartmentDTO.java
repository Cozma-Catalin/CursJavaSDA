package business.dto.structures;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DepartmentDTO {


    @NotNull
    @Pattern(regexp = "([a-zA-z]*)")
    private String name;

    public DepartmentDTO(){}


    public DepartmentDTO(String name) {
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
        return "DepartmentDTO: " + name ;
    }
}
