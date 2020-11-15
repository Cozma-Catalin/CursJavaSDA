package business.dto;


public class AccountDTO {

    private String userName;
    private String password;
    private boolean loggedIn;

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

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return "AccountDTO for user: " + userName ;
    }
}
