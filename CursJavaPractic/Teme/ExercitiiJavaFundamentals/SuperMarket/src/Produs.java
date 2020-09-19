public class Produs {
    protected String numeProd;
    protected double pret;
    Produs(){

    }

    public Produs(String numeProd, double pret) {
        this.numeProd = numeProd;
        this.pret = pret;
    }

    public void setNumeProd(String numeProd) {
        this.numeProd = numeProd;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getNumeProd() {
        return numeProd;
    }

    public double getPret() {
        return pret;
    }

}
