package CarEx;

public class CarDecorator extends Car{
    private Car car;
    private String features;

    public CarDecorator(Car car,String features){
        this.car = car;
        this.features = features;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "car: " + car.getMark() + ", features: " + features;
    }

}
