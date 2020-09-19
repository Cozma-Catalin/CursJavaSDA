import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CoffeeFileReader {

    public CoffeeFileReader() {

    }

    VendingMachine vendingMachine = VendingMachine.getInstance();

    public void readCoffeeFile() {
        try {

            String filePathCoffee = "C:\\Users\\Catalin\\Desktop\\VendingMachine\\Coffee.txt";
            FileReader fileReaderCoffee = new FileReader(filePathCoffee);
            BufferedReader bufferedReaderCoffee = new BufferedReader(fileReaderCoffee);

            String text = bufferedReaderCoffee.readLine();
            while (text != null && !text.isEmpty()) {
                String[] coffee = text.split(",");
                if (coffee[0].equalsIgnoreCase("Cappucino")) {
                    Cappucino cappucino = new Cappucino(coffee[0], Integer.valueOf(coffee[1]), Integer.valueOf(coffee[2]));
                    vendingMachine.setCappucino(cappucino);
                } else if (coffee[0].equalsIgnoreCase("Americano")) {
                    Americano americano = new Americano(coffee[0], Integer.valueOf(coffee[1]), Integer.valueOf(coffee[2]));
                    vendingMachine.setAmericano(americano);
                } else if (coffee[0].equalsIgnoreCase("Esspresso")) {
                    Esspresso esspresso = new Esspresso(coffee[0], Integer.valueOf(coffee[1]), Integer.valueOf(coffee[2]));
                    vendingMachine.setEsspresso(esspresso);
                }
                text = bufferedReaderCoffee.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
