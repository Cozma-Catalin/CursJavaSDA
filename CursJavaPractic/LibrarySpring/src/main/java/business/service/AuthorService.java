package business.service;

import business.dto.AuthorDTO;
import business.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.AuthorDAO;
import persistance.entities.Author;
import persistance.entities.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorDAO authorDAO;

    public void insertAuthorDTO(AuthorDTO authorDTO){

        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        authorDAO.insertAuthor(author);
    }

    public List<AuthorDTO> findAuthorDTOByNameList(String name){
        List<Author> authorList = authorDAO.findAuthorByName(name);
        List<AuthorDTO> authorDTOList = new ArrayList<AuthorDTO>();

        for(Author author:authorList){
            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setName(author.getName());
            authorDTO.setSurname(author.getSurname());
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }

}
