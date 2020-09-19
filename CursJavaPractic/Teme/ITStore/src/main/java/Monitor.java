public class Monitor extends Product {
    private String name;
    private double price;
    private int quantity;
    private Resolution resolution;


    public Monitor(String name, double price, int quantity, Resolution resolution) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.resolution = resolution;
    }
    public Monitor(){}

    public Resolution getResolution() {
        return resolution;
    }
}
