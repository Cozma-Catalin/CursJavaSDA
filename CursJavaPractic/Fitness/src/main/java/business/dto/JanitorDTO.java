package business.dto;

public class JanitorDTO {
    private String name;
    private String surname;
    private String birthDate;
    private int salary;
    private GymDTO gymDTO;

    public JanitorDTO() {
    }

    public JanitorDTO(String name, String surname, String birthDate, int salary, GymDTO gymDTO) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.salary = salary;
        this.gymDTO = gymDTO;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public GymDTO getGymDTO() {
        return gymDTO;
    }

    public void setGymDTO(GymDTO gymDTO) {
        this.gymDTO = gymDTO;
    }
}
