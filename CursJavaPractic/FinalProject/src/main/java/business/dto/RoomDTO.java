package business.dto;

import javax.validation.constraints.NotNull;

public class RoomDTO {
    @NotNull
    private String roomType;
    @NotNull
    private int numberOfRooms;
    @NotNull
    private boolean extraBed;
    @NotNull
    private int roomsAvailable;

    public RoomDTO(String roomType, int numberOfRooms, boolean extraBed, int roomsAvailable) {
        this.roomType = roomType;
        this.numberOfRooms = numberOfRooms;
        this.extraBed = extraBed;
        this.roomsAvailable = roomsAvailable;
    }

    public RoomDTO() {

    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isExtraBed() {
        return extraBed;
    }

    public void setExtraBed(boolean extraBed) {
        this.extraBed = extraBed;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public void setRoomsAvailable(int roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }
}