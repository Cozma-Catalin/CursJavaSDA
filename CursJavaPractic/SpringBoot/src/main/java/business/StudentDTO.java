package business;

public class StudentDTO {

    private String name;

    public StudentDTO(){}

    public StudentDTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
