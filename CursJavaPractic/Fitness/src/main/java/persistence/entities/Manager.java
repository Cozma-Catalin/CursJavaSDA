package persistence.entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "deleteManager",query = "delete from Manager where name= :name"),
        @NamedQuery(name = "countManager",query = "select count(name) from Manager where name= :name"),
        @NamedQuery(name = "findManager",query = "select manager from Manager manager where manager.name= :name")
})

@Entity
@Table(name = "managers")
public class Manager {
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gyms_id")
    private Gym gym;


    public Manager(String name, String surname, String birthDate, int salary) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public Manager(String name, String surname, String birthDate, int salary, Gym gym) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.salary = salary;
        this.gym = gym;
    }

    public Manager() {
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

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    @Override
    public String toString() {
        return "Manager:" + name + ", " + surname + ", date of birth: " + birthDate + ", salary:" + salary;
    }
}
