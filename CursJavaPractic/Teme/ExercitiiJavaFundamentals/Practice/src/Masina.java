import java.util.Scanner;

public class Masina {
    double rezervor;
    String combustibil;
    double km = 0;

    public Masina(double rezervor, String combustibil) {
        this.rezervor = rezervor;
        this.combustibil = combustibil;
    }

    Scanner scan = new Scanner(System.in);

    public void alimentez(String combustibil) {
        System.out.println("Cat vreti sa alimentati...?");
        double litri = scan.nextDouble();
        System.out.println("Am alimentat cu " + litri + " litri de " + combustibil);
    }
}
