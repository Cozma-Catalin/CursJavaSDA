package persistance.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Book> bookSet;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "authors_persons",
            joinColumns = {@JoinColumn(name = "authors_id")},
            inverseJoinColumns = {@JoinColumn(name = "persons_id")})
    private Set<Person> personSet;

public Author(){}

public Author(Set<Person> personSet){
    this.personSet = personSet;
}


    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    @Override
    public String toString() {
        return "Author: " + personSet;
    }
}
