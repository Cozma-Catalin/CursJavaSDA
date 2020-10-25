public abstract class Car {
    protected String brand;

    public Car(String brand){
        this.brand = brand;
    }
    public abstract void build();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
