package business.service;

import business.dto.GymDTO;
import business.dto.ManagerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.ManagerDAO;
import persistence.entities.Gym;
import persistence.entities.Manager;

@Service
public class ManagerService {
    @Autowired
    ManagerDAO managerDAO;

    public void insertManagerDTO(ManagerDTO managerDTO){
        Manager manager = new Manager();
        manager.setName(managerDTO.getName());
        manager.setSurname(managerDTO.getSurname());
        manager.setBirthDate(managerDTO.getBirthDate());
        manager.setSalary(managerDTO.getSalary());
        setManagersGym(managerDTO, manager);
        managerDAO.insertManager(manager);
    }

    private void setManagersGym(ManagerDTO managerDTO, Manager manager) {
        Gym gym = new Gym();
        gym.setName(managerDTO.getGymDTO().getName());
        gym.setAddress(managerDTO.getGymDTO().getAddress());
        gym.setCity(managerDTO.getGymDTO().getCity());
        manager.setGym(gym);
    }

    public int deleteManager(String name){
        int result = managerDAO.deleteManager(name);
        return result;
    }

    public long countManager(String name){
        long result = managerDAO.countManager(name);
        return result;
    }

    public ManagerDTO findManager(String name){
        Manager manager = managerDAO.findManager(name);
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setName(manager.getName());
        managerDTO.setSurname(manager.getSurname());
        managerDTO.setBirthDate(manager.getBirthDate());
        managerDTO.setSalary(manager.getSalary());
        GymDTO gymDTO = new GymDTO();
        gymDTO.setName(manager.getGym().getName());
        gymDTO.setAddress(manager.getGym().getAddress());
        gymDTO.setCity(manager.getGym().getCity());
        managerDTO.setGymDTO(gymDTO);
        return managerDTO;
    }
}
