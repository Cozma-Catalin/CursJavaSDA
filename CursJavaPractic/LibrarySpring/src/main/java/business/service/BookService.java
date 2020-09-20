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

    public String insertBookDTO(BookDTO bookDTO) {

            Author author = new Author();
            author.setName(bookDTO.getAuthorDTO().getName());
            author.setSurname(bookDTO.getAuthorDTO().getSurname());

            Section section = new Section();
            section.setName(bookDTO.getSectionDTO().getName());

            Book book = new Book();
            book.setTitle(bookDTO.getTitle());
            book.setAuthor(author);
            book.setSection(section);
            bookDAO.insertBook(book);
            return "Cartea a fost adaugata cu succes.";
        }

        public Long countBooksByTitle(String title){
        Long result = bookDAO.countBooksByTitle(title);
        return result;
        }

    public List<BookDTO> findBookDTOByTitle(String title) {
        List<Book> bookList = bookDAO.findBookByTitle(title);
        List<BookDTO> bookDTOList = new ArrayList<BookDTO>();

        for (Book book : bookList) {

            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setName(book.getAuthor().getName());
            authorDTO.setSurname(book.getAuthor().getSurname());

            SectionDTO sectionDTO = new SectionDTO();
            sectionDTO.setName(book.getSection().getName());

            BookDTO bookDTO = new BookDTO();
            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthorDTO(authorDTO);
            bookDTO.setSectionDTO(sectionDTO);
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    public List<BookDTO> findAllBooksDTO(){
       List<Book> bookList = bookDAO.findAllBooks();
       List<BookDTO> bookDTOList = new ArrayList<>();

       for(Book book : bookList){
           BookDTO bookDTO = new BookDTO();
           bookDTO.setTitle(book.getTitle());

           AuthorDTO authorDTO = new AuthorDTO();
           authorDTO.setName(bookDTO.getAuthorDTO().getName());
           authorDTO.setSurname(bookDTO.getAuthorDTO().getSurname());

           SectionDTO sectionDTO = new SectionDTO();
           sectionDTO.setName(bookDTO.getSectionDTO().getName());

           bookDTOList.add(bookDTO);
       }

        return bookDTOList;
    }

    public Long deleteBookByTitle(String title) {
        Long result = bookDAO.deleteBookByTitle(title);
        if (result == 0) {
            System.out.println("Nu a fost stearsa nici o carte.");
        }
        return result;
    }
}
