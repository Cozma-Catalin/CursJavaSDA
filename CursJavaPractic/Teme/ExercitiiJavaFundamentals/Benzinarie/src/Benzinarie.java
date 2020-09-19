public class Benzinarie {
    private double motorina;
    private double benzina;
    private double pretM;
    private double pretB;

    public double getMotorina() {
        return motorina;
    }

    public double getBenzina() {
        return benzina;
    }

    public double getPretM() {
        return pretM;
    }

    public double getPretB() {
        return pretB;
    }

    public Benzinarie(double motorina, double benzina, double pretB, double pretM) {
        this.motorina = motorina;
        this.benzina = benzina;
        this.pretM = pretM;
        this.pretB = pretB;
    }

    public double vandBenzina(double benzinaDeVandut) {
        double pretTotal = 0;
        if (this.benzina < 10) {
            System.out.println("Nu avem benzina in stoc.");
        } else {
            if (benzinaDeVandut > this.benzina) {
                System.out.println("Nu avem atata benzina.");

            }
            this.benzina -= benzinaDeVandut;
            pretTotal = benzinaDeVandut * pretB;
        }
        return pretTotal;
    }

    public double vandMotorina(double motorinaDeVandut) {
        double pretTotal = 0;
        if (this.motorina < 10) {
            System.out.println("Nu avem motorina in stoc.");
        } else {
            if (motorinaDeVandut > this.motorina) {
                System.out.println("Nu avem atata motorina.");
            }
            this.motorina -= motorinaDeVandut;
            pretTotal = motorinaDeVandut * pretM;
        }
        return pretTotal;
    }

    public String incaseazaBani(double bani, double pretTotal) {

        if (bani == pretTotal) {
            return "Multumim va mai asteptam.";
        } else if (bani > pretTotal) {
            return "Multumim, poftiti restul:" + (bani - pretTotal);
        }
        return "Chem politia.";
    }
}
