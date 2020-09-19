import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Meniu masini:");
        System.out.println("1. Audi");
        System.out.println("2. Seat");
        System.out.println("3. Wolksvagen");
        System.out.println("Alegeti o masina din meniu.");

        Scanner userInput = new Scanner(System.in);
        int optiune = userInput.nextInt();
        CarMaker carMaker = new CarMaker();

        if (optiune == 1) {
            carMaker.makeAudi();
        } else if (optiune == 2) {
            carMaker.makeSeat();
        } else if (optiune == 3) {
            carMaker.makeWolksvagen();
        } else {
            System.out.println("Nu avem aceasta optiune.");
        }


    }
}
