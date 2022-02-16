package business.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z A-Z])*")
    private String name;

    @NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z A-Z])*")
    private String surname;

    @NotNull @NotBlank @NotEmpty
    private String address;

    private String birthDate;

    @NotNull @NotBlank @NotEmpty
    private String phoneNumber;

    @NotNull @NotBlank @NotEmpty @Email
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    private String password;

    private boolean loggedIn;



}
