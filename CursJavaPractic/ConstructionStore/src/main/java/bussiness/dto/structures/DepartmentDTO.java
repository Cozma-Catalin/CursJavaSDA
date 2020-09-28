package bussiness.dto.structures;

import javax.validation.constraints.NotNull;

public class DepartmentDTO {


    @NotNull
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
