public abstract class Product {

    private String type;
    private String brand;
    private String color;
    private String size;
    private int price;

    public Product(String type, String brand, String color, String size, int price) {
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public Product(){}

    public Product(String brand, String color, String size, int price) {
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return type + ", brand: " + brand + ", color: " + color + ", size: " + size + ", price: " + price ;
    }
}

