package persistance.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "address")
    private String address;
    @Column(name = "year_of_birth")
    private String yearOfBirth;
    @ManyToMany(mappedBy = "personSet",cascade = CascadeType.ALL)
    private Set<Author> authorSet;

    public Person(){}

    public Person(String name,String surname,String address,String yearOfBirth){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
    }


    public Person(String name,String surname,String address,String yearOfBirth,Set<Author> authorSet){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
        this.authorSet = authorSet;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }


    @Override
    public String toString() {
        return name + ", " + surname + ", address: " + address + ", yearOfBirth: " + yearOfBirth ;
    }
}
