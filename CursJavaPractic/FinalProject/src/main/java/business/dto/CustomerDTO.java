package business.dto;


import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

public class CustomerDTO {
    @NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z A-Z])*")
    private String name;
    @NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z A-Z])*")
    private String surname;
    @NotNull @NotBlank @NotEmpty
    private String address;
    private Date birthDate;
    @NotNull @NotBlank @NotEmpty
    private String phoneNumber;
    @NotNull @NotBlank @NotEmpty @Email
    private String email;
    @Valid
    private AccountDTO accountDTO;


    public CustomerDTO(String name, String surname, String address, Date birthDate,String phoneNumber,
                       String email, AccountDTO accountDTO) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountDTO = accountDTO;
    }

    public CustomerDTO() {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }

    @Override
    public String toString() {
        return "CustomerDTO: " + name + ", " + surname + ", birthDate: " + birthDate + ", email: " + email ;
    }
}
