import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class LapTopFileReader {
    public LapTopFileReader(){}

    Store store = Store.getInstance();
    Map<String , LapTop> lapTopMap = new HashMap<>();

    public void readLapTopFile() {
        try {
            String filePath = "C:\\Users\\Catalin\\Desktop\\Store\\LapTop.txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String text = bufferedReader.readLine();
            while (text != null && !text.isEmpty()) {
                String[] array = text.split(",");
                LapTop laptop = new LapTop(array[0], Double.valueOf(array[1]), Integer.valueOf(array[2]));
                lapTopMap.put(laptop.getName(),laptop);
                text = bufferedReader.readLine();
            }

                store.setLapTop(lapTopMap);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
