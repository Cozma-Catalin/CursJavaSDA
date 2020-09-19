import persistance.dao.AuthorDAO;
import persistance.dao.BookDAO;
import persistance.entities.Author;
import persistance.entities.Book;
import persistance.entities.Person;
import persistance.entities.Section;

import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

        AuthorDAO authorDAO = new AuthorDAO();
        BookDAO bookDAO = new BookDAO();

        Person person = new Person("Marin","Preda","saddggfhds","1952/10/16");
        Person person1 = new Person("Catalin","Cozma","kljhgfghj","1989/12/5");

        Set<Person> personSet = new HashSet<Person>();
        personSet.add(person);
        personSet.add(person1);

        Author author = new Author();
        author.setPersonSet(personSet);
        authorDAO.insertAuthor(author);


        Section section = new Section("Roman");


        Book book = new Book("Baltagul","Roman",2,author,section,1,0);
        bookDAO.insertBook(book);
    }
}
