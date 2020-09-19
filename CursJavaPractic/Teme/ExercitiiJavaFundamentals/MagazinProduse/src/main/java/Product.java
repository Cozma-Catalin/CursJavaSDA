public class Product {
    private String category;
    private String nameProd;
    private String aisle;
    private String price;
    private String discount;

    public Product(String category, String nameProd, String aisle, String price, String discount) {
        this.category = category;
        this.nameProd = nameProd;
        this.aisle = aisle;
        this.price = price;
        this.discount = discount;

    }

    public String getCategory() {
        return category;
    }

    public String getNameProd() {
        return nameProd;
    }

    public String getAisle() {
        return aisle;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return
                "Category: " + category + "; " + " product name is: " + nameProd + "; " + "aisle you can find it: " + aisle + "; " + "the price is: " + price + "; " + "with discount of: " + discount + "%.";
    }
}
