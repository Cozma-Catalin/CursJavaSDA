import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PCFileReader {
    public PCFileReader(){}

    Store store = Store.getInstance();

    public void readPCFile() {
        try {
            String filePath = "C:\\Users\\Catalin\\Desktop\\Store\\PC.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            while (text != null && !text.isEmpty()) {
                String[] array = text.split(",");
                PC pc = new PC(array[0],Double.valueOf(array[1]),Integer.valueOf(array[2]));
                store.setPc(pc);
                text = bufferedReader.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
