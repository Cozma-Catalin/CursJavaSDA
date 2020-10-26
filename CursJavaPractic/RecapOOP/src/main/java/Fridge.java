public class Fridge extends Product {
    private String powerSource;
    private boolean freezer;
    private int degree;

    public Fridge(String brand, String model, double quantity, double price,String powerSource,Boolean freezer) {
        super(brand, model, quantity, price);
        this.powerSource = powerSource;
        this.freezer = freezer;
    }

    public Fridge(){}

    public void start() {
        System.out.println("Fridge is on...cooling started!");
    }

    public void stop() {
        System.out.println("Fridge is shutting down.");
    }

    public void selfCleaning(int degree){
        if(degree>10){
            System.out.println("Self cleaning mode started...");
        }
    }

    public String getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    public void isFreezer() {
        if(freezer == true){
            System.out.println("Fridge has a freezer.");
        }else{
            System.out.println("Fridge doesn't have a freezer.");
        }
    }

    public void setFreezer(boolean freezer) {
        this.freezer = freezer;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Fridge: " + ", brand: " + brand + ", model: " + model + ", freezer=" + freezer + ", quantity: " + quantity + ",price: " + price ;
    }
}
