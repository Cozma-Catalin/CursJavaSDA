package business.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class AuthorDTO {

    @NotBlank(message = "Campul este gol.")
    @NotNull
    @Pattern(regexp = "([a-zA-Z])*")
    private String name;

    @NotBlank(message = "Campul este gol.")
    @NotNull
    @Pattern(regexp = "([a-zA-Z])*")
    private String surname;




    public AuthorDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public AuthorDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public String toString() {
        return "AuthorDTO: " + name + ", " + surname;
    }
}
