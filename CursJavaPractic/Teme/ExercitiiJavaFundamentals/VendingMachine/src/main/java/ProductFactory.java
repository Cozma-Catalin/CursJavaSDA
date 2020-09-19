public class ProductFactory {



    public Product getProduct(String productName){
        if(productName.equalsIgnoreCase("Cola")){
            return new Cola();
        }else if(productName.equalsIgnoreCase("Fanta")){
            return new Fanta();
        }else if(productName.equalsIgnoreCase("Watter")){
            return new Watter();
        }else if(productName.equalsIgnoreCase("Cappucino")){
            return new Cappucino();
        }else if(productName.equalsIgnoreCase("Esspresso")){
            return new Esspresso();
        }else if(productName.equalsIgnoreCase("Americano")){
            return new Americano();
        }else if(productName.equalsIgnoreCase("Chips")){
            return new Chips();
        }else if(productName.equalsIgnoreCase("Croissant")){
            return new Croissant();
        }else if(productName.equalsIgnoreCase("Protein Bar")){
            return new ProteinBar();
        }else{
            System.out.println("We don't have this product.");
        }
        return null;
    }

}
