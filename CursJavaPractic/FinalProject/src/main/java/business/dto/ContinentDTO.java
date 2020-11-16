package business.dto;

public class ContinentDTO {
    private String name;

    public ContinentDTO(String name) {
        this.name = name;
    }

    public ContinentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ContinentDTO: " + name ;
    }
}
