public class ProductFactory {

    public Product getProduct(String productType){
        if(productType.equalsIgnoreCase("shirt")){
            return new Shirt();
        }else if(productType.equalsIgnoreCase("Tshirt")){
            return new Tshirt();
        }else if(productType.equalsIgnoreCase("jacket")){
            return new Jacket();
        }
        return null;
    }
}
