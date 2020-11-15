package business.dto;

import java.util.Set;

public class CustomerDTO {

    private String name;
    private String surname;
    private String birthDate;
    private String email;
    private AccountDTO accountDTO;
    private Set<GymDTO> gymDTOSet;
    private Set<SubscriptionDTO> subscriptionDTOSet;

    public CustomerDTO(String name, String surname, String birthDate, String email) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
    }

    public CustomerDTO(String name, String surname, String birthDate, String email, Set<GymDTO> gymDTOSet, Set<SubscriptionDTO> subscriptionDTOSet) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.gymDTOSet = gymDTOSet;
        this.subscriptionDTOSet = subscriptionDTOSet;
    }


    public CustomerDTO(String name, String surname, String birthDate, String email, Set<GymDTO> gymDTOSet) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.gymDTOSet = gymDTOSet;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<GymDTO> getGymDTOSet() {
        return gymDTOSet;
    }

    public void setGymDTOSet(Set<GymDTO> gymDTOSet) {
        this.gymDTOSet = gymDTOSet;
    }

    public Set<SubscriptionDTO> getSubscriptionDTOSet() {
        return subscriptionDTOSet;
    }

    public void setSubscriptionDTOSet(Set<SubscriptionDTO> subscriptionDTOSet) {
        this.subscriptionDTOSet = subscriptionDTOSet;
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
