package business.dto;


public class BookDTO {
    private String name;
    private SectionDTO sectionDTO;
    private AuthorDTO authorDTO;


    public BookDTO(String name, SectionDTO sectionDTO,AuthorDTO authorDTO) {
        this.name = name;
        this.sectionDTO = sectionDTO;
        this.authorDTO = authorDTO;
    }
    public BookDTO(String name){
        this.name = name;
    }

    public BookDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "BookDTO: " + name ;
    }
}

