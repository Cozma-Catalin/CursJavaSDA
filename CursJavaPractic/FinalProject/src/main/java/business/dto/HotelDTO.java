package business.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class HotelDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([a-z A-Z])*")
    private String name;
    @NotNull
   // @Pattern(regexp = "([1-5])*")
    private double numberOfStars;
    @NotBlank
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    private CityDTO cityDTO;
    @NotNull
    private Set<RoomDTO> roomDTOSet;

    public HotelDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z A-Z])*") String name, @NotNull double numberOfStars, @NotBlank @NotNull @NotEmpty String description, @NotNull CityDTO cityDTO) {
        this.name = name;
        this.numberOfStars = numberOfStars;
        this.description = description;
        this.cityDTO = cityDTO;
    }

    public HotelDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z A-Z])*") String name, @NotNull double numberOfStars, @NotBlank @NotNull @NotEmpty String description, @NotNull CityDTO cityDTO, @NotNull Set<RoomDTO> roomDTOSet) {
        this.name = name;
        this.numberOfStars = numberOfStars;
        this.description = description;
        this.cityDTO = cityDTO;
        this.roomDTOSet = roomDTOSet;
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

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
    }

    public Set<RoomDTO> getRoomDTOSet() {
        return roomDTOSet;
    }

    public void setRoomDTOSet(Set<RoomDTO> roomDTOSet) {
        this.roomDTOSet = roomDTOSet;
    }

    @Override
    public String toString() {
        return "HotelDTO: " + name + ", numberOfStars:" + numberOfStars + ", description:" + description + ", cityDTO:" + cityDTO + ", roomDTOSet: " + roomDTOSet ;
    }
}
