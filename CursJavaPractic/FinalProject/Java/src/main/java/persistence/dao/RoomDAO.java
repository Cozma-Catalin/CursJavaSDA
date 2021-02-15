package persistence.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import persistence.entities.Room;
import persistence.utils.HibernateUtil;

import javax.persistence.NoResultException;


@Repository
public class RoomDAO {



    public Room findRoomByType(String roomType){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findRoomByTypeQuery = session.createNamedQuery("findRoomByType");
        findRoomByTypeQuery.setParameter("roomType",roomType);
        Room room = null;
        try{
            room = (Room) findRoomByTypeQuery.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        return room;
    }

    public void updateRoomsAvailable(int roomsAvailable,String roomType){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateRoomsAvailableQuery = session.createNamedQuery("updateRoomsAvailable");
        updateRoomsAvailableQuery.setParameter("roomsAvailable",roomsAvailable);
        updateRoomsAvailableQuery.setParameter("roomType",roomType);
        updateRoomsAvailableQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }



}
