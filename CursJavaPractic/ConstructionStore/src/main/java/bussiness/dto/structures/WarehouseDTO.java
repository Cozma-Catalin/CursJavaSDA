package bussiness.dto.structures;

import javax.validation.constraints.NotNull;

public class WarehouseDTO {
    @NotNull
    private String name;
    @NotNull
    private String city;
    @NotNull
    private String address;

    public WarehouseDTO(){}

    public WarehouseDTO(String city, String address) {
        this.city = city;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "WarehouseDTO: " + name + ",city: " + city + ", address: " + address ;
    }
}
