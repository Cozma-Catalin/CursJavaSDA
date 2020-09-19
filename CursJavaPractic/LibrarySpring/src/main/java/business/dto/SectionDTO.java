package business.dto;


public class SectionDTO {
    private String name;
    private BookDTO bookDTO;

    public SectionDTO(){}

    public SectionDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    @Override
    public String toString() {
        return "SectionDTO: " + name ;
    }
}
