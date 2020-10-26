public class WashingMachine extends Product {
    private String powerSource;
    private int revs;
    private boolean dryer;
    private String washingCycle;


    public WashingMachine(String brand, String model, double quantity, double price,String powerSource,int revs,boolean dryer,String washingCycle) {
        super(brand, model, quantity, price);
        this.powerSource = powerSource;
        this.revs = revs;
        this.dryer = dryer;
        this.washingCycle = washingCycle;
    }

    public WashingMachine() {
    }

    public void start() {
        System.out.println("Washing machine is on!");
    }

    public void selectWashingCycle(String fabric){
        if(fabric.equalsIgnoreCase("cotton")){
            System.out.println("Washing cottons.");
        }else if(fabric.equalsIgnoreCase("wool")){
            System.out.println("Washing wools.");
        }else{
            System.out.println("Washing synthetics.");
        }
    }

    public void stop() {
        System.out.println("Washing machine is shutting down!");
    }

    public String getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    public int getRevs() {
        return revs;
    }

    public void setRevs(int revs) {
        this.revs = revs;
    }

    public boolean isDryer() {
        return dryer;
    }

    public void setDryer(boolean dryer) {
        this.dryer = dryer;
    }

    public String getWashingCycle() {
        return washingCycle;
    }

    public void setWashingCycle(String washingCycle) {
        this.washingCycle = washingCycle;
    }
}
