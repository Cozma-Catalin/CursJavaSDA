package business.dto;

import java.util.Set;

public class TrainerDTO {

    private String name;
    private String surname;
    private String birthDate;
    private int salary;
    private Set<CourseDTO> courseDTOSet;
    private Set<GymDTO> gymDTOSet;

    public TrainerDTO(String name, String surname, String birthDate, int salary) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public TrainerDTO(String name, String surname, String birthDate, int salary, Set<CourseDTO> courseDTOSet) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.salary = salary;
        this.courseDTOSet = courseDTOSet;
    }

    public TrainerDTO() {
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

    public Set<CourseDTO> getCourseDTOSet() {
        return courseDTOSet;
    }

    public void setCourseDTOSet(Set<CourseDTO> courseDTOSet) {
        this.courseDTOSet = courseDTOSet;
    }

    public Set<GymDTO> getGymDTOSet() {
        return gymDTOSet;
    }

    public void setGymDTOSet(Set<GymDTO> gymDTOSet) {
        this.gymDTOSet = gymDTOSet;
    }


    @Override
    public String toString() {
        return "TrainerDTO: " + name + ", " + surname + ", birthDate: " + birthDate + ", salary: " + salary ;
    }
}
