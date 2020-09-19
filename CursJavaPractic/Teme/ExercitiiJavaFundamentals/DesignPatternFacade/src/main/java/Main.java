import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Ne ajuta sa ascudem complexitatea creerii unui obiect si ne ofera o interfata,
        // un singur loc care sa creem obiecte fara sa vedem ce se intampla in spate

        System.out.println("Meniu Pizza:");
        System.out.println("1. Diavola");
        System.out.println("2. Vegan");
        System.out.println("3. Quatro-Stagioni");
        System.out.println("4. Pepperoni");
        System.out.println("Alegeti din meniu.");

        Scanner userInput = new Scanner(System.in);
        int optiune = userInput.nextInt();
        PizzaMaker pizzaMaker = new PizzaMaker();

        if (optiune == 1) {
            pizzaMaker.makePizzaDiavola();
        } else if (optiune == 2) {
            pizzaMaker.makePizzaVegan();
        } else if (optiune == 3) {
            pizzaMaker.makePizzaQuatroStagioni();
        } else if (optiune == 4) {
            pizzaMaker.makePizzaPepperoni();
        } else {
            System.out.println("Nu avem aceasta optiune.");
        }
    }
}
