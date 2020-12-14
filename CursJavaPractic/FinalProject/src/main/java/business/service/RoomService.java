package business.service;

import business.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.RoomDAO;
import persistence.entities.Room;

@Service
public class RoomService {

    @Autowired
    RoomDAO roomDAO;

    public RoomDTO findRoomByType(String roomType){
        Room room = roomDAO.findRoomByType(roomType);
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setNumberOfRooms(room.getNumberOfRooms());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setExtraBed(room.isExtraBed());
        roomDTO.setPrice(room.getPrice());
        roomDTO.setRoomsAvailable(room.getRoomsAvailable());
        return roomDTO;
    }

    public void updateRoomAvailability(String roomType,int roomNumber){
        roomDAO.updateRoomsAvailable(roomNumber,roomType);

    }



}
