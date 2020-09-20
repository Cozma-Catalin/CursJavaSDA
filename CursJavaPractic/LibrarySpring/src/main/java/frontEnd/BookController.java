package frontEnd;

import business.dto.BookDTO;
import business.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/findBookByTitle")
    public ResponseEntity<List<BookDTO>> findBookByTitle(String title) {
        List<BookDTO> bookDTOList = bookService.findBookDTOByTitle(title);
        if (bookDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookDTOList);
    }

    @GetMapping("/findAllBooks")
    public ResponseEntity<List<BookDTO>> findAllBooks() {
        List<BookDTO> bookDTOList = bookService.findAllBooksDTO();
        if (bookDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookDTOList);
    }

    @DeleteMapping(path = "/deleteBookByTitle")
    public String deleteBookByTitle(@RequestParam String title) {
        Long result = bookService.deleteBookByTitle(title);
        if (result == 0) {
            return "Nu a fost sters niciun obiect de tipul Book.";
        } else {
            return "S-au sters " + result + " obiecte de tipul Book.";
        }
    }

    @PostMapping(path = "/insertBook")
    public String insertBook(@RequestBody @Valid BookDTO bookToInsert) {
        if (bookService.countBooksByTitle(bookToInsert.getTitle()) == 0) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setTitle(bookToInsert.getTitle());
            bookDTO.setAuthorDTO(bookToInsert.getAuthorDTO());
            bookDTO.setSectionDTO(bookToInsert.getSectionDTO());
            bookService.insertBookDTO(bookDTO);

            return "A fost inserata cartea " + bookToInsert.getTitle() + ": scrisa de " + bookToInsert.getAuthorDTO().getName() + " " + bookToInsert.getAuthorDTO().getSurname() + ".";
        } else {
            return "Exista cartea aceasta.";
        }
    }
}