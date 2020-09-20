package persistance.entities;


import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "findAllBooks",query = "select book from Book book"),
        @NamedQuery(name = "findBookByTitle",query = "select book from Book book where title= :title"),
        @NamedQuery(name = "deleteBookByTitle",query = "delete from Book where title= :title"),
        @NamedQuery(name = "countBooksByTitle",query = "select count(*) from Book book where book.title= :title")
})

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sections_id")
    private Section section;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authors_id")
    private Author author;


    public Book(String title, Section section, Author author) {
        this.title = title;
        this.section = section;
        this.author = author;
    }

    public Book(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "Book: " + title ;
    }
}
