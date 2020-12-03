package persistence.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String roomType;

    @Column(name = "number_of_rooms")
    private int numberOfRooms;

    @Column(name = "extra_bed")
    private boolean extraBed;

    @Column(name = "rooms_available")
    private int roomsAvailable;

    @ManyToMany(mappedBy = "roomSet")
    private Set<Hotel> hotelSet;


    public Room(String roomType, int numberOfRooms, boolean extraBed, int roomsAvailable) {
        this.roomType = roomType;
        this.numberOfRooms = numberOfRooms;
        this.extraBed = extraBed;
        this.roomsAvailable = roomsAvailable;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Hotel> getHotelSet() {
        return hotelSet;
    }

    public void setHotelSet(Set<Hotel> hotelSet) {
        this.hotelSet = hotelSet;
    }

    @Override
    public String toString() {
        return "Room: " + roomType + ", number of rooms:" + numberOfRooms + ", extra bed: " +
                extraBed + ",number of rooms available : " + roomsAvailable;
    }
}