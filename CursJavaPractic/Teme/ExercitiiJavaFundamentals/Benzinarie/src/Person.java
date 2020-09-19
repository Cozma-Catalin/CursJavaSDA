public class Person {
    String nume;
    double bani;

    public Person(String nume, double bani) {
        this.nume = nume;
        this.bani = bani;
    }

    public String cumparaB(double baniDePlatit) {
        if (baniDePlatit > this.bani) {
            return "Nu am destui bani " + this.bani;
        }
        this.bani -= baniDePlatit;
        return "Mai avem atatia bani " + this.bani;
    }

    public String cumparaM(double baniDePlatit) {
        if (baniDePlatit > this.bani) {
            return "Nu am destui bani " + this.bani;
        }
        this.bani -= baniDePlatit;
        return "Mai avem atatia bani " + this.bani;
    }

}
