package business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    @NotNull
    private String roomType;

    @NotNull
    private int numberOfRooms;

    @NotNull
    private boolean extraBed;

    @NotNull
    private double price;

    @NotNull
    private int roomsAvailable;

}