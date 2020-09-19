import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //ne ajuta sa adaugam functionalitati noi sau sa sa facem adaugari la structura unui obiect fara sa ii alteram structura curenta
        //Facem un meniu cu 6 optiuni
        System.out.println("Meniu:");
        System.out.println("1. Triangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");
        System.out.println("4. Bordered Triangle");
        System.out.println("5. Bordered Square");
        System.out.println("6. Bordered Circle");
        System.out.println("Alegeti din meniu.");
        Scanner userInput = new Scanner(System.in);
        int optiune = userInput.nextInt();

        if (optiune == 1) {
            Shape triangle = new Triangle();
            triangle.draw();
        } else if (optiune == 2) {
            Shape square = new Square();
            square.draw();
        } else if (optiune == 3) {
            Shape circle = new Circle();
            circle.draw();
        } else if (optiune == 4) {
            Shape triangle = new Triangle();
            ShapeDecorator borderedTriangle = new TriangleDecorator(triangle);
            borderedTriangle.draw();
        } else if (optiune == 5) {
            Shape square = new Square();
            ShapeDecorator borderedSquare = new SquareDecorator(square);
            borderedSquare.draw();
        } else if (optiune == 6) {
            Shape circle = new Circle();
            ShapeDecorator borderedCircle = new CircleDecorator(circle);
            borderedCircle.draw();
        } else {
            System.out.println("Optiunea asta nu exista.");
        }

    }
}
