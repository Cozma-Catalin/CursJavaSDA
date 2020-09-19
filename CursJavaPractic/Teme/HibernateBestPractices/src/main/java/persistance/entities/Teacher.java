package persistance.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Delete_Teacher_By_Tenure", query = "delete Teacher where tenure= :tenure"),
        @NamedQuery(name = "Update_Teacher_Expertise",query = "update Teacher set expertise= :expertise where tenure= :tenure "),
        @NamedQuery(name = "Select_Teachers_By_Age",query = "select teacher from Teacher teacher where teacher.age = :age ")
})
@Entity
@Table(name= "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name= "name")
    private String name;
    @Column(name= "surname")
    private String surname;
    @Column(name= "age")
    private int age;
    @Column(name= "expertise")
    private String expertise;
    @Column(name= "secondary_subject")
    private String secondarySubject;
    @Column(name= "tenure")
    private int tenure;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToMany(mappedBy = "teacherSet" ,cascade = CascadeType.ALL)
    private Set<Student> studentSet;

    public Teacher(){}

    public Teacher(String name,String surname, int age,String expertise,String secondarySubject,int tenure,Address address){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.secondarySubject = secondarySubject;
        this.tenure = tenure;
        this.address = address;
        this.expertise = expertise;


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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getSecondarySubject() {
        return secondarySubject;
    }

    public void setSecondary_subject(String secondarySubject) {
        this.secondarySubject = secondarySubject;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public void setSecondarySubject(String secondarySubject) {
        this.secondarySubject = secondarySubject;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    @Override
    public String toString() {
        return  name + ", " + surname + ", " + age + ", " + expertise + ", " + secondarySubject + ", "+ tenure + ", " + address;
    }
}

