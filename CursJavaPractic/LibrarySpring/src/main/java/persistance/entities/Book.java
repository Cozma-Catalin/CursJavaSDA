package persistance.entities;


import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "findBook",query = "select book from Book book"),
        @NamedQuery(name = "deleteBookByName",query = "delete from Book where name= :name")
})

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sections_id")
    private Section section;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authors_id")
    private Author author;


    public Book(String name, Section section, Author author) {
        this.name = name;
        this.section = section;
        this.author = author;
    }

    public Book(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book: " + name ;
    }
}
