import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DrinkFileReader {


    public DrinkFileReader() {

    }

    VendingMachine vendingMachine = VendingMachine.getInstance();

    public void readDrinkFile() {
        try {
            String filePathDrink = "C:\\Users\\Catalin\\Desktop\\VendingMachine\\Drink.txt";
            FileReader fileReaderDrink = new FileReader(filePathDrink);
            BufferedReader bufferedReaderDrink = new BufferedReader(fileReaderDrink);

            String text = bufferedReaderDrink.readLine();
            while (text != null && !text.isEmpty()) {
                String[] drink = text.split(",");
                if (drink[0].equalsIgnoreCase("Cola")) {
                    Cola cola = new Cola(drink[0], Integer.valueOf(drink[1]), Integer.valueOf(drink[2]));
                    vendingMachine.setCola(cola);
                } else if (drink[0].equalsIgnoreCase("Fanta")) {
                    Fanta fanta = new Fanta(drink[0], Integer.valueOf(drink[1]), Integer.valueOf(drink[2]));
                    vendingMachine.setFanta(fanta);
                } else if (drink[0].equalsIgnoreCase("Watter")) {
                    Watter watter = new Watter(drink[0], Integer.valueOf(drink[1]), Integer.valueOf(drink[2]));
                    vendingMachine.setWatter(watter);
                }
                text = bufferedReaderDrink.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}