package business.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountDTO {
    @NotNull
    @NotBlank
    @NotEmpty
    private String userName;
    @NotNull
    @NotEmpty
    @NotBlank
    private String password;



    public AccountDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }


    public AccountDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "AccountDTO for user: " + userName ;
    }
}
