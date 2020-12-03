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
    private Set<RoomDTO> roomDTOSet;


    @Valid
    private CityDTO cityDTO;


    public HotelDTO( String name, String address, double numberOfStars, Set<RoomDTO> roomDTOSet,
                     String description,CityDTO cityDTO) {
        this.name = name;
        this.address = address;
        this.numberOfStars = numberOfStars;
        this.roomDTOSet = roomDTOSet;
        this.description = description;
        this.cityDTO = cityDTO;
    }

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

    public Set<RoomDTO> getRoomDTOSet() {
        return roomDTOSet;
    }

    public void setRoomDTOSet(Set<RoomDTO> roomDTOSet) {
        this.roomDTOSet = roomDTOSet;
    }

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
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
                 ", rooms : " + roomDTOSet + ", description:" + description + ", cityDTO:" + cityDTO ;
    }
}
