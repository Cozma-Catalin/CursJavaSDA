package CarEx;

import java.util.Scanner;

public class Menu {


    Scanner scanner = new Scanner(System.in);

    public void display() throws WrongInputException {
        System.out.println("Choose a car :");
        System.out.println("1. BMW");
        System.out.println("2. Dacia");
        System.out.println("3. Trabant");
        int userInput = scanner.nextInt();
        Car car = new Car();
        if (userInput == 1) {
            car.setMark("BMW");
            displaySubMenu(car);
        } else if (userInput == 2) {
            car.setMark("Dacia");
            displaySubMenu(car);
        } else if (userInput == 3) {
            car.setMark("Trabant");
            displaySubMenu(car);
        } else {
            throw new WrongInputException("This option is not valid!...!");

        }
    }


    public void displaySubMenu(Car car) throws WrongInputException {
        System.out.println("Choose your favorite:");
        System.out.println("1. Standard");
        System.out.println("2. Customize");
        int userInput = scanner.nextInt();
        if (userInput == 1) {
            System.out.println("Thank you for purchasing " + car.getMark() + " with standard features...");
        } else if (userInput == 2) {
            System.out.println("Choose which features you want to be added:");
            String feature_1 = scanner.next();
            System.out.println("First feature:");
            CarDecorator carDecorator = new CarDecorator(car,feature_1);
            System.out.println(feature_1 + " added.");
            System.out.println("Second feature:");
            String feature_2 = scanner.next();
            System.out.println(feature_2 + " added.");
            carDecorator.setFeatures(feature_1 + ", " + feature_2);
            System.out.println("Thank you for purchasing " + carDecorator);
        } else {
            throw new WrongInputException("Were did you see this option...?!");
        }
    }
}
