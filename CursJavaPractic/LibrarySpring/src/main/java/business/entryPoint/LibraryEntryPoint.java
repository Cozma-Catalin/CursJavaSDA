package business.entryPoint;

import business.dto.AuthorDTO;
import business.dto.BookDTO;
import business.dto.SectionDTO;
import business.service.AuthorService;
import business.service.BookService;
import business.service.SectionService;
import frontEnd.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryEntryPoint {
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;
    @Autowired
    SectionService sectionService;
    @Autowired
    BookController bookController;
    public void run(){

        AuthorDTO jamesBond = new AuthorDTO("James","Bond");
        SectionDTO history = new SectionDTO("history");
        BookDTO WWII= new BookDTO("World War II",history,jamesBond);

        AuthorDTO pacino = new AuthorDTO("Tony","Montana");
        SectionDTO mafia = new SectionDTO("mafia");
        BookDTO scarface = new BookDTO("Scarface",mafia,pacino);

        bookService.insertBookDTO(WWII);
        bookService.insertBookDTO(scarface);

        System.out.println("Cartile gasite sunt:" + bookService.findBookDTO());
        System.out.println("Autorul cautat este: " + authorService.findAuthorDTOByNameList("Tony"));
        System.out.println("Sectiile cautate sunt" + sectionService.findSectionDTO());

       // bookController.deleteBookByName("Scarface");

    }

}
