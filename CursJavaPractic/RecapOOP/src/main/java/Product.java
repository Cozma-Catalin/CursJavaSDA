public abstract class Product {
    protected String brand;
    protected String model;
    protected double quantity;
    protected double price;

    public Product(String brand, String model, double quantity, double price) {
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {
    }

    public abstract void start();

    public abstract void stop();


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
