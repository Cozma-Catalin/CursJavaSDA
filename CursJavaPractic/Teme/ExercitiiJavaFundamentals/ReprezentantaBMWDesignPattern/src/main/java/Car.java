public class Car {
    private String name;
    private String model;
    private String engine;
    private String color;

    public Car(String name, String model, String engine, String color){
        this.name = name;
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    @Override
    public Car clone() {
        return new Car(this.name,this.model,this.engine,this.color);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name + "," + model + "," + engine + "," + color;
    }
}
