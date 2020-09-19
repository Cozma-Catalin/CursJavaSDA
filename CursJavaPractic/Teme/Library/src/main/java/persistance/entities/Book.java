package persistance.entities;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "volume_number")
    private int volume;
    @Column(name = "type")
    private String type;
    @Column(name = "borrowed")
    private int borrowed;
    @Column(name = "free")
    private int free;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authors_id")
    private Author author;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sections_id")
    private Section section;

    public Book(){}

    public Book(String title,String type,int volume,Author author,Section section,int borrowed,int free){
        this.title = title;
        this.type = type;
        this.volume = volume;
        this.author = author;
        this.borrowed = borrowed;
        this.free = free;
        this.section = section;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(int borrowed) {
        this.borrowed = borrowed;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
