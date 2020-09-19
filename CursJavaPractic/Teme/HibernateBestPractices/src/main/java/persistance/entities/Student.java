
package persistance.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Find_Student_By_Name", query = "select student from Student student where student.name= :name"),
        @NamedQuery(name = "Find_Student_By_Year_Of_Birth",query ="select student from Student student where student.yearOfBirth=:yearOfBirth" ),
        @NamedQuery(name = "Delete_Student_By_Name",query = "delete Student where name=:name" ),
        @NamedQuery(name = "Delete_Student_By_Year_Of_Birth",query = "delete Student where yearOfBirth=:yearOfBirth")
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
    private int yearOfBirth;
    @Column(name = "major")
    private String major;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_teachers",
            joinColumns= {@JoinColumn(name = "students_id")},
            inverseJoinColumns = {@JoinColumn(name = "teachers_id")})
    private Set<Teacher> teacherSet;

    public Student() {
    }
    public Student(String name,String surname,int yearOfBirth,String major,Address address){
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.major = major;
        this.address = address;
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

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Teacher> getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set<Teacher> teacherSet) {
        this.teacherSet = teacherSet;
    }

    @Override
    public String toString() {
        return name + ", "+ surname + ", " + yearOfBirth + ", " + major  + ", " + address;
    }
}
