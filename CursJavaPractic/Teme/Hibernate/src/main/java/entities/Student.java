package entities;// clasele care vor fi mapate cu tabele din baza de date poarta numele de Entitati

import javax.persistence.*;

@Entity
@Table(name= "students")
public class Student {

    @Id// folosit ptr coloana id din tabela din baza de date, coloana care are rol de primary key si se autoincrementeaza
    @GeneratedValue(strategy = GenerationType.IDENTITY)// spunem hibernate ului ca valorile din acest atribut vor fi auto-generate de catre baza de date
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "year_of_birth")
    private int yearOfBirth;
    @Column(name = "major")
    private String major;

    public Student(){

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

    public int getYearOfBirth() {
        return yearOfBirth;
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
}
