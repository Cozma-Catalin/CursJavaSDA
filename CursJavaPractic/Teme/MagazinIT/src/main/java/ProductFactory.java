public class ProductFactory {
    public ProductFactory(){}

    public Product getProduct(String productName){
        if(productName.equalsIgnoreCase("LapTop")){
            return new LapTop();
        }else if(productName.equalsIgnoreCase("PC")){
            return new PC();
        }else if(productName.equalsIgnoreCase("Monitor")){
            return new Monitor();
        }else if(productName.equalsIgnoreCase("Keyboard")){
            return new Keyboard();
        }else if(productName.equalsIgnoreCase("Mouse")){
            return new Mouse();
        }else if(productName.equalsIgnoreCase("HardDisk")){
            return new HardDisk();
        }else if(productName.equalsIgnoreCase("Processor")) {
            return new Processor();
        }else if(productName.equalsIgnoreCase("MemoryCard")){
            return new MemoryCard();
        }else if(productName.equalsIgnoreCase("VideoCard")){
            return new VideoCard();
        }else if(productName.equalsIgnoreCase("WebCam")){
            return new WebCam();
        }else{
            return null;
        }
    }
}
