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
    private double price;

    @NotNull
    private int roomsAvailable;


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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public void setRoomsAvailable(int roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }


    @Override
    public String toString() {
        return "RoomDTO:" + roomType + ", numberOfRooms: " + numberOfRooms + ", extra bed:" + extraBed +
                ", price: " + price + ", roomsAvailable: " + roomsAvailable;
    }
}