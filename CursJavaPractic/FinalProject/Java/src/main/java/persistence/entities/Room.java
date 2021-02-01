package persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@NamedQueries({
        @NamedQuery(name = "findRoomByType",query = "select room from Room room where roomType= :roomType"),
        @NamedQuery(name = "updateRoomsAvailable",query = "update from Room set roomsAvailable= :roomsAvailable where roomType= :roomType")
})

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "price")
    private double price;

    @Column(name = "rooms_available")
    private int roomsAvailable;

    @ManyToMany(mappedBy = "roomSet")
    private Set<Hotel> hotelSet;

}