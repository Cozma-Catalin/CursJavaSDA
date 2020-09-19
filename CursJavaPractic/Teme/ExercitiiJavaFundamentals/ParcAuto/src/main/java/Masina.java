public class Masina implements Comparable<Masina>, Leasing {
    private String marca;
    private String model;
    private String culoare;
    private int pret;
    private String combustibil;
    private int dataFabricare;


    public Masina(String marca, String model, String culoare, int pret, String combustibil, int dataFabricare) {
        this.marca = marca;
        this.model = model;
        this.culoare = culoare;
        this.pret = pret;
        this.combustibil = combustibil;
        this.dataFabricare = dataFabricare;

    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public String getCuloare() {
        return culoare;
    }

    public int getPret() {
        return pret;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public int getDataFabricare() {
        return dataFabricare;
    }

    public boolean isVandut() {
        if (this.marca.equals("Audi") || this.marca.equals("BMW") && this.culoare.equals("black") && this.combustibil.equals("benzina")) {
            return true;
        } else {
            return false;
        }

    }

    public int compareTo(Masina o) {

        if (this.dataFabricare < o.getDataFabricare()) {
            System.out.print("Masina mai buna este :" + o.getMarca() + " anul ");
            return o.dataFabricare;
        } else if (this.dataFabricare == o.getDataFabricare()) {
            System.out.println("Masinile sunt la fel de bune.");
        }
        System.out.print("Masina mai buna este :" + getMarca() + " anul ");
        return dataFabricare;
    }

    public int nrRate() {
        return 24;
    }

    public int pretRata() {
        return pret / nrRate();
    }
}
