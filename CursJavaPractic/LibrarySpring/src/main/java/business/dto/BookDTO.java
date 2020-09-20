package business.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BookDTO {

    @NotBlank(message = "Campul este gol.")
    @NotNull
    @Pattern(regexp = "([a-z A-Z])*")
    private String title;
    @NotNull
    private SectionDTO sectionDTO;
    @NotNull
    private AuthorDTO authorDTO;


    public BookDTO(String title, SectionDTO sectionDTO,AuthorDTO authorDTO) {
        this.title = title;
        this.sectionDTO = sectionDTO;
        this.authorDTO = authorDTO;
    }
    public BookDTO(String title){
        this.title = title;
    }

    public BookDTO(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SectionDTO getSectionDTO() {
        return sectionDTO;
    }

    public void setSectionDTO(SectionDTO sectionDTO) {
        this.sectionDTO = sectionDTO;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }




    @Override
    public String toString() {
        return "BookDTO: " + title + authorDTO.getName()+authorDTO.getSurname() + sectionDTO ;
    }
}

