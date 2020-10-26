import DataInputEx.*;
import CarEx.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        try {
            menu.display();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }

        DataInput dataInput = new DataInput();
        dataInput.inputData();


    }
}


