package business.service;

import business.dto.AuthorDTO;
import business.dto.BookDTO;
import business.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.BookDAO;
import persistance.entities.Author;
import persistance.entities.Book;
import persistance.entities.Section;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;

    public void insertBookDTO(BookDTO bookDTO){
        Author author = new Author();
        author.setName(bookDTO.getAuthorDTO().getName());
        author.setSurname(bookDTO.getAuthorDTO().getSurname());

        Section section = new Section();
        section.setName(bookDTO.getSectionDTO().getName());

        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(author);
        book.setSection(section);
        bookDAO.insertBook(book);
    }

    public List<BookDTO> findBookDTO(){
        List<Book> bookList = bookDAO.findBook();
        List<BookDTO> bookDTOList = new ArrayList<BookDTO>();

        for(Book book:bookList){

            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setName(book.getAuthor().getName());
            authorDTO.setSurname(book.getAuthor().getSurname());

            SectionDTO sectionDTO = new SectionDTO();
            sectionDTO.setName(book.getSection().getName());

            BookDTO bookDTO = new BookDTO();
            bookDTO.setName(book.getName());
            bookDTO.setAuthorDTO(authorDTO);
            bookDTO.setSectionDTO(sectionDTO);
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    public int deleteBookByName(String name){
        int result = bookDAO.deleteBookByName(name);
        return result;
    }
}
