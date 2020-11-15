package business.dto;

import java.util.Set;

public class GymDTO {
    private String name;
    private String address;
    private String city;
    private ManagerDTO managerDTO;
    private Set<TrainerDTO> trainerDTOSet;
    private Set<JanitorDTO> janitorDTOSet;


    public GymDTO() {
    }

    public GymDTO(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public GymDTO(String address) {
        this.address = address;
    }

    public GymDTO(String name, String address, String city, ManagerDTO managerDTO) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.managerDTO = managerDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ManagerDTO getManagerDTO() {
        return managerDTO;
    }

    public void setManagerDTO(ManagerDTO managerDTO) {
        this.managerDTO = managerDTO;
    }

    public Set<TrainerDTO> getTrainerDTOSet() {
        return trainerDTOSet;
    }

    public void setTrainerDTOSet(Set<TrainerDTO> trainerDTOSet) {
        this.trainerDTOSet = trainerDTOSet;
    }

    public Set<JanitorDTO> getJanitorDTOSet() {
        return janitorDTOSet;
    }

    public void setJanitorDTOSet(Set<JanitorDTO> janitorDTOSet) {
        this.janitorDTOSet = janitorDTOSet;
    }


    @Override
    public String toString() {
        return "Gym: " + name + ", address:" + address + ", city:" + city ;
    }
}
