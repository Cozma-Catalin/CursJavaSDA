package persistance.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "date_of_birth")
    private String birthDate;
    @Column(name = "salary")
    private int salary;
    @OneToMany(mappedBy = "trainer",cascade = CascadeType.ALL)
    private Set<Workout> workoutSet ;


    public Trainer(String name, String surname, String birthDate, int salary) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public Trainer(String name, String surname, String birthDate, int salary, Set<Workout> workoutSet) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.salary = salary;
        this.workoutSet = workoutSet;

    }

    public Trainer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Workout> getWorkoutSet() {
        return workoutSet;
    }

    public void setWorkoutSet(Set<Workout> workoutSet) {
        this.workoutSet = workoutSet;
    }

    @Override
    public String toString() {
        return "Trainer:" + name + ", " + surname + ", date of birth:" + birthDate + ", salary:" + salary;
    }
}
