package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "deleteTrainer", query = "delete from Trainer where name= :name and surname= :surname"),
        @NamedQuery(name = "changeSalary", query = "update from Trainer set salary= :salary where name= :name and surname= :surname"),
        @NamedQuery(name = "countTrainer", query = "select count(*) from Trainer where name= :name and surname= :surname")

})

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
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private Set<Course> courseSet;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gyms_trainers",
    joinColumns = {@JoinColumn(name = "trainers_id")},
    inverseJoinColumns = {@JoinColumn(name = "gyms_id")})
    private Set<Gym> gymSet;


    public Trainer(String name, String surname, String birthDate, int salary) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public Trainer(String name, String surname, String birthDate, int salary, Set<Course> courseSet) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.salary = salary;
        this.courseSet = courseSet;

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

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public Set<Gym> getGymSet() {
        return gymSet;
    }

    public void setGymSet(Set<Gym> gymSet) {
        this.gymSet = gymSet;
    }

    @Override
    public String toString() {
        return "Trainer:" + name + ", " + surname + ", date of birth:" + birthDate + ", salary:" + salary;
    }
}
