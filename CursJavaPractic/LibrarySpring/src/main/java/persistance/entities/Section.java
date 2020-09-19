package persistance.entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "findSection",query = "select section from Section section")
})

@Entity
@Table(name = "sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToOne(mappedBy = "section")
    private Book book;

    public Section(String name, Book book) {
        this.name = name;
        this.book = book;
    }
    public Section(String name){
        this.name = name;
    }

    public Section(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Section: " + name ;
    }
}
