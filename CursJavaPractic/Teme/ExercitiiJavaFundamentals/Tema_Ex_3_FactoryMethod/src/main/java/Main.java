import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Meniu de bauturi:");
        System.out.println("1. Cola");
        System.out.println("2. Fanta");
        System.out.println("3. Prigat");
        System.out.println("4. Becks");
        System.out.println("5. Tuborg");
        System.out.println("6. Carslberg");
        System.out.println("7. Johnny Walker");
        System.out.println("8. Jameson");
        System.out.println("Alegeti din meniu.");

        Scanner usersInput = new Scanner(System.in);
        int option = usersInput.nextInt();
        ProductFactory productFactory = new ProductFactory();

        if (option == 1) {
            ZeroProof zeroProofProduct = (ZeroProof) productFactory.getProduct("Cola");
            System.out.println("Ati ales produsul " + zeroProofProduct.getName() + ": " + zeroProofProduct.getPrice() + ", " + zeroProofProduct.getSize() + "," + zeroProofProduct.isCarbonated() + ".");
        } else if (option == 2) {
            ZeroProof zeroProofProduct = (ZeroProof) productFactory.getProduct("Fanta");
            System.out.println("Ati ales produsul " + zeroProofProduct.getName() + ": " + zeroProofProduct.getSize() + ", " + zeroProofProduct.getPrice() + "," + zeroProofProduct.isCarbonated() + ".");
        } else if (option == 3) {
            ZeroProof zeroProofProduct = (ZeroProof) productFactory.getProduct("Prigat");
            System.out.println("Ati ales " + zeroProofProduct.getName() + ": " + zeroProofProduct.getSize() + ", " + zeroProofProduct.getPrice() + "," + zeroProofProduct.isCarbonated() + ".");
        } else if (option == 4) {
            Beer beerProduct = (Beer) productFactory.getProduct("Becks");
            System.out.println("Ati ales " + beerProduct.getName() + ": " + beerProduct.getSize() + ", " + beerProduct.getPrice() + ", " + beerProduct.getAlcoholPercentage() + ".");
        } else if (option == 5) {
            Beer beerProduct = (Beer) productFactory.getProduct("Tuborg");
            System.out.println("Ati ales " + beerProduct.getName() + ": " + beerProduct.getSize() + ", " + beerProduct.getPrice() + ", " + beerProduct.getAlcoholPercentage() + ".");
        } else if (option == 6) {
            Beer beerProduct = (Beer) productFactory.getProduct("Carlsberg");
            System.out.println("Ati ales " + beerProduct.getName() + ": " + beerProduct.getSize() + ", " + beerProduct.getPrice() + ", " + beerProduct.getAlcoholPercentage() + ".");
        } else if (option == 7) {
            Spirit spiritProduct = (Spirit) productFactory.getProduct("Johnny Walker");
            System.out.println("Ati ales " + spiritProduct.getName() + ": " + spiritProduct.getSize() + ", " + spiritProduct.getPrice() + ", " + spiritProduct.getAlcoholPercentage() + ".");
        } else if (option == 8) {
            Spirit spiritProduct = (Spirit) productFactory.getProduct("Jameson");
            System.out.println("Ati ales " + spiritProduct.getName() + ": " + spiritProduct.getSize() + "," + spiritProduct.getPrice() + "," + spiritProduct.getAlcoholPercentage() + ".");
        } else {
            System.out.println("We don't have this item.");
        }
        System.out.println("Va multumim.O zi buna!");
    }
}
