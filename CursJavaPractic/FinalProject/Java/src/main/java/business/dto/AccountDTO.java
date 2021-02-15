package business.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
public class AccountDTO {
    @NotNull
    @NotBlank
    @NotEmpty
    private String userName;
    @NotNull
    @NotEmpty
    @NotBlank
    private String password;
    @NotNull
    private boolean loggedIn;


}
