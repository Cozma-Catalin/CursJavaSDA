import java.util.Scanner;

public class Benzinarie {
    private double benzina;
    private double motorina;
    private double pretB;
    private double pretM;

    public Benzinarie(double benzina, double pretB, double motorina, double pretM) {
        this.benzina = benzina;
        this.motorina = motorina;
        this.pretB = pretB;
        this.pretM = pretM;

    }

    Scanner scan = new Scanner(System.in);

    public void vandM(Persoana persoana) {
        System.out.println("Buna ziua " + persoana.nume + ".Cati litri de motorina vreti sa alimentati...?");
        double litri = scan.nextDouble();
        double motorinaRamasa = getMotorina() - litri;
        if (litri > getMotorina()) {
            System.out.println("Nu avem atata motorina.");
        } else {
            double totalDePlata = litri * getPretM();
            System.out.println("Aveti de platit: " + totalDePlata);
            if (persoana.getBani() < totalDePlata) {
                System.out.println("Nu am atatia bani.");
            } else if (persoana.getBani() == totalDePlata) {
                System.out.println("Va multumim.");
                System.out.println("A mai ramas atata " + motorinaRamasa + " motorina de vandut.");
                motorina = motorinaRamasa;
            } else {
                System.out.println("Poftiti restul: " + (persoana.getBani() - totalDePlata));
                System.out.println("A mai ramas atata " + motorinaRamasa + " motorina de vandut.");
                motorina = motorinaRamasa;
            }
            motorina = motorinaRamasa;
        }

    }

    public void vandB(Persoana persoana) {
        System.out.println("Buna ziua " + persoana.nume + ".Cati litri de benzina vreti sa alimentati...?");
        double litri = scan.nextDouble();
        double benzinaRamasa = getBenzina() - litri;
        if (litri > getBenzina()) {
            System.out.println("Nu avem atata benzina.");
        } else {
            double totalDePlata = litri * getPretB();
            System.out.println("Aveti de platit: " + totalDePlata);
            if (persoana.getBani() < totalDePlata) {
                System.out.println("Nu am atatia bani.");
            } else if (persoana.getBani() == totalDePlata) {
                System.out.println("Va multumim.");
                System.out.println("A mai ramas atata " + benzinaRamasa + " benzina de vandut.");
                benzina = benzinaRamasa;
            } else {
                System.out.println("Poftiti restul: " + (persoana.getBani() - totalDePlata));
                System.out.println("A mai ramas atata " + benzinaRamasa + " benzina de vandut.");
                benzina = benzinaRamasa;
            }

            benzina = benzinaRamasa;
        }
    }

    public double getBenzina() {
        return benzina;
    }

    public double getMotorina() {
        return motorina;
    }

    public double getPretB() {
        return pretB;
    }

    public double getPretM() {
        return pretM;
    }

}