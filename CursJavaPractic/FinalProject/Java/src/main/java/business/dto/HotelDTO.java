package business.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Set;


public class HotelDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([a-z A-Z])*")
    private String name;
    @NotNull
    @NotBlank
    @NotEmpty
    private String address;
    @NotNull
    @Min(1)
    @Max(5)
    private double numberOfStars;
    @NotNull
    private String description;
    @NotNull @Valid
    private Set<RoomDTO> rooms;


    @Valid
    private CityDTO city;



    public HotelDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(double numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(Set<RoomDTO> rooms) {
        this.rooms = rooms;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "HotelDTO: " + name + ", address: " + address + ", numberOfStars:" + numberOfStars +
                 ", rooms : " + rooms + ", description:" + description + ", cityDTO:" + city ;
    }
}
