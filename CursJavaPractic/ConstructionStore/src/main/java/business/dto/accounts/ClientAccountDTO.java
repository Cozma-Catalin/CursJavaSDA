package business.dto.accounts;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ClientAccountDTO {
    @NotNull
    @Pattern(regexp = "([a-zA-z]*)")
    private String name;
    @NotNull
    @Pattern(regexp = "([a-zA-z]*)")
    private String surname;
    @NotNull
    private String email;
    @NotNull
    @Pattern(regexp = "([a-zA-z]*)")
    private String password;

    public ClientAccountDTO(){}

    public ClientAccountDTO(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ClientDTO: " + name + " " + surname + ", email: " + email ;
    }
}
