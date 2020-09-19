package persistance.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Find_Teacher",query="select teacher from Teacher teacher")
})

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "major")
    private String major;

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Teacher(String name, String surname, String major) {
        this.name = name;
        this.surname = surname;
        this.major = major;
    }
    public Teacher(){}

    @Override
    public String toString() {
        return "Teacher:" + name + " " + surname + ", major:" + major ;
    }
}
