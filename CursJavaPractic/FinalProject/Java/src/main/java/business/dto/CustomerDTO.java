package business.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    @NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z A-Z])*")
    private String name;

    @NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z A-Z])*")
    private String surname;

    @NotNull @NotBlank @NotEmpty
    private String address;

    private java.sql.Date birthDate;

    @NotNull @NotBlank @NotEmpty
    private String phoneNumber;

    @NotNull @NotBlank @NotEmpty @Email
    private String email;

    @Valid
    private AccountDTO account;



}
