package business.service;

import business.dto.GymDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.GymDAO;
import persistence.entities.Gym;

@Service
public class GymService {

    @Autowired
    GymDAO gymDAO;

    public void insertGymDTO(GymDTO gymDTO){
        Gym gym = new Gym();
        gym.setName(gymDTO.getName());
        gym.setAddress(gymDTO.getAddress());
        gym.setCity(gymDTO.getCity());
        gymDAO.insertGym(gym);
    }

    public long countGym(String address) {
        long result = gymDAO.countGym(address);
        return result;
    }

    public GymDTO findGymDTO(String address) {
        Gym gym = gymDAO.findGym(address);
        GymDTO gymDTO = new GymDTO();
        gymDTO.setName(gym.getName());
        gymDTO.setAddress(gym.getAddress());
        gymDTO.setCity(gym.getCity());
        return gymDTO;
    }

    public int deleteGymDTO(String address){
        int result = gymDAO.deleteGym(address);
        return result;
    }

    public int changeGymDTOName(String name,String address){
        int result = gymDAO.changeGymName(name,address);
        return result;
    }
}
