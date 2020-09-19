import java.util.Date;

public class ProdusAlimentar extends Produs {
    private Date dataExp;
    private boolean alergeni;
    public ProdusAlimentar(){

    }
   public ProdusAlimentar(String numeProd,int pret,boolean alergeni,Date dataExp){
        this.numeProd = numeProd;
        this.pret = pret;
        this.dataExp = dataExp;
        this.alergeni = alergeni;
    }

    public Date getDataExp() {
        return dataExp;
    }

    public void setDataExp(Date dataExp) {
        this.dataExp = dataExp;
    }

    public boolean getAlergeni() {
        return alergeni;
    }

    public void setAlergeni(boolean alergeni) {
        this.alergeni = alergeni;
    }
}
