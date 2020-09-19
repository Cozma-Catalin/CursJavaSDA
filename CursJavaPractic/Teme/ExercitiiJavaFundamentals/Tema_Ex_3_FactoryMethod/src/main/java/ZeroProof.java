public class ZeroProof extends Product {
    private String name;
    private String size;
    private String price;
    private boolean carbonated;

    public ZeroProof(String name,String size, String price, boolean carbonated) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.carbonated = carbonated;
    }

    public String getName(){
        return name;}

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }

    public String isCarbonated() {
        if (carbonated) {
            return "Bautura este carbogazoasa";
        } else {
            return "Bautura nu este carbogazoasa";
        }
    }
}
