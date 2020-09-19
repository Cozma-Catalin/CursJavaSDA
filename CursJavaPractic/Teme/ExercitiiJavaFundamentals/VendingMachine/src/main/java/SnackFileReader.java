import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SnackFileReader {

    public SnackFileReader() {
    }

    VendingMachine vendingMachine = VendingMachine.getInstance();

    public void readSnackFile() {
        try {
            String snackFilePath = "C:\\Users\\Catalin\\Desktop\\VendingMachine\\Snack.txt";
            FileReader fileReaderSnack = new FileReader(snackFilePath);
            BufferedReader bufferedReaderSnack = new BufferedReader(fileReaderSnack);

            String text = bufferedReaderSnack.readLine();
            while (text != null && !text.isEmpty()) {
                String[] snack = text.split(",");
                if (snack[0].equalsIgnoreCase("Croissant")) {
                    Croissant croissant = new Croissant(snack[0], Integer.valueOf(snack[1]), Integer.valueOf(snack[2]));
                    vendingMachine.setCroissant(croissant);
                } else if (snack[0].equalsIgnoreCase("Chips")) {
                    Chips chips = new Chips(snack[0], Integer.valueOf(snack[1]), Integer.valueOf(snack[2]));
                    vendingMachine.setChips(chips);
                } else if (snack[0].equalsIgnoreCase("ProteinBar")) {
                    ProteinBar proteinBar = new ProteinBar(snack[0], Integer.valueOf(snack[1]), Integer.valueOf(snack[2]));
                    vendingMachine.setProteinBar(proteinBar);
                }
                text = bufferedReaderSnack.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
