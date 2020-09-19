package business.dto;

import persistance.entities.Book;

import java.util.Set;

public class AuthorDTO {
private String name;
private String surname;
private Set<BookDTO> bookSetDTO;

    public AuthorDTO(String name, String surname, Set<BookDTO> bookSetDTO) {
        this.name = name;
        this.surname = surname;
        this.bookSetDTO = bookSetDTO;
    }

    public AuthorDTO(String name,String surname){
        this.name = name;
        this.surname = surname;
    }

    public AuthorDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<BookDTO> getBookSetDTO() {
        return bookSetDTO;
    }

    public void setBookSetDTO(Set<BookDTO> bookSetDTO) {
        this.bookSetDTO = bookSetDTO;
    }

    @Override
    public String toString() {
        return "AuthorDTO: " + name + ", " + surname ;
    }
}
