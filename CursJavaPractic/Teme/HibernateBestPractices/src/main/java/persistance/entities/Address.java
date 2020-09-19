package persistance.entities;


import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    private Student student;
    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    private Teacher teacher;

    public Address(){}

    public Address(String city,String street){
        this.city = city;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return  city + " street: " + street;
    }
}
