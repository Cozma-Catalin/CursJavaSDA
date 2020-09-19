import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Set<Long> operatiiCalculator = new HashSet<>();
        Map<String, Set> calculator = new HashMap<>();
        calculator.put("Calculator", operatiiCalculator);

        try {
            operatiiCalculator.add(calc.add());
            operatiiCalculator.add(calc.subtract());
            operatiiCalculator.add(calc.multiply());
            operatiiCalculator.add(calc.divide());

        } catch (NumberTooShort e) {
            System.out.println(e.getMessage());
        }
        for (Long operatie : operatiiCalculator) {
            System.out.println(operatie);
        }
        System.out.println(calculator.get("Calculator"));
    }

}