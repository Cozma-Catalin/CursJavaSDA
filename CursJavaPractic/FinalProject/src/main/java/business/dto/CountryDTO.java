package business.dto;

public class CountryDTO {

    private String name;
    private ContinentDTO continentDTO;

    public CountryDTO(String name, ContinentDTO continentDTO) {
        this.name = name;
        this.continentDTO = continentDTO;
    }

    public CountryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContinentDTO getContinentDTO() {
        return continentDTO;
    }

    public void setContinentDTO(ContinentDTO continentDTO) {
        this.continentDTO = continentDTO;
    }

    @Override
    public String toString() {
        return "CountryDTO: " + name + "," + continentDTO ;
    }
}
