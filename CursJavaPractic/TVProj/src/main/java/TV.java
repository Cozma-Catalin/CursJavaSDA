public class TV {
    private String brand;
    private String model;
    private int diag;

    public TV(String brand, String model, int diag) {
        this.brand = brand;
        this.model = model;
        this.diag = diag;
    }

    public TV(){}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDiag() {
        return diag;
    }

    public void setDiag(int diag) {
        this.diag = diag;
    }

    @Override
    public String toString() {
        return "TV: " + brand + ", model: " + model + ", diagonal: " + diag ;
    }

}
