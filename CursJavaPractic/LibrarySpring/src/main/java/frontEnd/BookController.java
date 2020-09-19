package frontEnd;

import business.dto.BookDTO;
import business.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/findBook")
    public List<BookDTO> findBook() {
        List<BookDTO> bookDTOList = bookService.findBookDTO();
        return bookDTOList;
    }

    @DeleteMapping(path = "/deleteBookByName")
    public String deleteBookByName(@RequestParam String name) {
        int result = bookService.deleteBookByName(name);
        if (result == 0) {
            return "Nu a fost sters niciun obiect de tipul Book.";
        } else {
            return "S-au sters " + result + " obiecte de tipul Book.";
        }
    }

    @PostMapping(path = "/insertBook")
    public String insertBook(@RequestBody BookDTO bookToInsert){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setName(bookToInsert.getName());
        bookDTO.setAuthorDTO(bookToInsert.getAuthorDTO());
        bookDTO.setSectionDTO(bookToInsert.getSectionDTO());
        bookService.insertBookDTO(bookDTO);

        return "A fost inserata cartea cu numele: " + bookToInsert.getName();
    }
}