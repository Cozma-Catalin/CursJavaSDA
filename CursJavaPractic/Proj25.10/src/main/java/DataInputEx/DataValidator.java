package DataInputEx;

import DataInputEx.Exceptions.NotNumberException;
import DataInputEx.Exceptions.OutOfRangeException;
import DataInputEx.Exceptions.WrongNumberException;

public class DataValidator {
    public void validateData(String userInput) throws WrongNumberException, OutOfRangeException, NotNumberException {
        if (!userInput.matches("[0-9 ]")) {
            throw new NotNumberException("Your input is not a number...!");
        } else if (Integer.parseInt(userInput) <= 200 && Integer.parseInt(userInput) >= 800) {
            throw new OutOfRangeException("Your number not in range(>200,<800");
        }
        int sum = 0;
        String[] digits = userInput.split("");
        for (String digit : digits) {
            sum += Integer.parseInt(digit);
        }
        if (sum % 3 == 0) {
            throw new WrongNumberException("Wrong number input(sum not div by 3)");
        }
    }

}
