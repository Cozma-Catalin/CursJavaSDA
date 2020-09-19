public class Beer extends Product {
    private String name;
    private String size;
    private String price;
    private String alcoholPercentage;

    public Beer(String name,String size, String price, String alcoholPercentage) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.alcoholPercentage = alcoholPercentage;
    }
    public String getName(){ return name;}

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }

    public String getAlcoholPercentage() {
        return alcoholPercentage;
    }
}
