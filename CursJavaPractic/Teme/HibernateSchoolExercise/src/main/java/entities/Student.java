package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Delete_Student_By_Year", query = "delete Student where birthYear>= :birthYear"),
        @NamedQuery(name = "Delete_Student_By_Major",query ="delete Student where major= :major" ),
        @NamedQuery(name = "Update_Students_Major_Before_Year",query = "update Student set major = :major where birthYear < :birthYear" ),
        @NamedQuery(name = "Select_Students_By_BirthYear",query = "select student from Student student where student.birthYear>= :birthYear")
})
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "year_of_birth")
    private int birthYear;
    @Column(name = "major")
    private String major;

    public Student() {
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

    public int getBirthDate() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return id +
                ", " + name + ", "+ surname + ", " + birthYear + ", " +major ;
    }
}
