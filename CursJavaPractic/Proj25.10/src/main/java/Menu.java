import java.util.Scanner;

public class Menu {


    Scanner scanner = new Scanner(System.in);

    public void display() throws NoSuchInputException {
        System.out.println("Choose a car :");
        System.out.println("1. BMW");
        System.out.println("2. Dacia");
        System.out.println("3. Trabant");
        CarMaker carMaker = new CarMaker();
        int userInput = scanner.nextInt();
        if (userInput == 1) {
            Car bmw = carMaker.makeBMW();
            displaySubMenu(bmw);
        } else if (userInput == 2) {
            Car dacia = carMaker.makeDacia();
            displaySubMenu(dacia);
        } else if (userInput == 3) {
            Car trabant = carMaker.makeTrabant();
            displaySubMenu(trabant);
        } else {
            throw new NoSuchInputException("This option has no meaning...!");

        }
    }


    public void displaySubMenu(Car car) throws NoSuchInputException {
        System.out.println("Choose your favorite:");
        System.out.println("1. Standard");
        System.out.println("2. Customize");
        int userInput = scanner.nextInt();
        if (userInput == 1) {
            System.out.println("Thank you for purchasing " + car.getBrand()+ " with standard features...");
        } else if (userInput == 2) {
            System.out.println("Choose which features you want to be added:");
            String feature_1 = scanner.nextLine();
            System.out.println("First feature:");
            feature_1 = scanner.nextLine();
            System.out.println(feature_1 + " added.");
            System.out.println("Second feature:");
            String feature_2 = scanner.nextLine();
            System.out.println(feature_2 + " added.");
            System.out.println("Thank you for purchasing " + car.getBrand() + " with extra features: " + feature_1 + ", " + feature_2 + ".");
        } else {
            throw new NoSuchInputException("Were did you see this option...?!");
        }
    }
}
