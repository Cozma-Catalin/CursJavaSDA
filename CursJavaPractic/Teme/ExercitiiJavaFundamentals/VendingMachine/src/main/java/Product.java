public abstract class Product {
    protected String name;
    protected int price;
    protected int quantity;



    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String toString() {
        return name + ", price: " + price + ",quantity: " + quantity ;
    }
}
