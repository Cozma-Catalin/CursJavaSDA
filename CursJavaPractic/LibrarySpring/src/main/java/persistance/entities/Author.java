package persistance.entities;


import javax.persistence.*;
import java.util.Set;
@NamedQueries({
        @NamedQuery(name = "findAuthorByName",query="select author from Author author where name=:name")
})


@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Book> bookSet;

    public Author(String name, String surname, Set<Book> bookSet) {
        this.name = name;
        this.surname = surname;
        this.bookSet = bookSet;
    }

    public Author(String name,String surname){
        this.name = name;
        this.surname = surname;
    }

    public Author(){}

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

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    @Override
    public String toString() {
        return "Author: " + name + ", " + surname;
    }
}
