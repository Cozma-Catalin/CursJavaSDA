package DataInputEx;

import DataInputEx.Exceptions.OutOfRangeException;
import DataInputEx.Exceptions.WrongNumberException;
import DataInputEx.Exceptions.NotNumberException;

import java.util.Scanner;

public class DataInput {
    public DataInput() {
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti valorile:");
        String userInput = scanner.nextLine();
        try {
            while (!userInput.isBlank()) {
                DataValidator dataValidator = new DataValidator();
                dataValidator.validateData(userInput);
                userInput = scanner.nextLine();
            }
            System.out.println("Program ended because your input was 'space'.");
        } catch (WrongNumberException e) {
            System.out.println(e.getMessage());
        } catch (OutOfRangeException e) {
            System.out.println(e.getMessage());
        } catch (NotNumberException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Next time be more careful.");
        }
    }


}
