public class Persoana {
    private double bani;
    String nume;

    public double getBani() {
        return bani;
    }

    public Persoana(String nume, double bani, Masina masina) {
        this.bani = bani;
        this.nume = nume;
    }

    public String maPlimbInOras(Masina masina, double km) {
        masina.rezervor -= ((7 * km) / 100);
        if (masina.rezervor <= 5) {
            System.out.println(nume + " nu mai avem " + masina.combustibil + "sa ne plimba prin oras.Trebuie sa alimentam.");
            masina.alimentez(masina.combustibil);
        }
        masina.km += km;
        return "Consumul in oras este de :" + 7 + " litri la suta de km.";

    }

    public String maPlimbInAfaraOrasului(Masina masina, double km) {
        masina.rezervor -= ((11 * km) / 100);
        if (masina.rezervor <= 5) {
            System.out.println(nume + " nu mai avem " + masina.combustibil + "sa ne plimbam in afara orasului.Trebuie sa alimentam.");
            masina.alimentez(masina.combustibil);
        }
        masina.km += km;
        return "Consumul in afara orasului este de :" + 11 + " litri la suta de km";

    }

}
