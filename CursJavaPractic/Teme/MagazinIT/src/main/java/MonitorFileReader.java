import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MonitorFileReader {
    public MonitorFileReader(){}

    Store store = Store.getInstance();

    public void readMonitorFile() {
        try {
            String filePath = "C:\\Users\\Catalin\\Desktop\\Store\\Monitor.txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String text = bufferedReader.readLine();
            while (text != null && !text.isEmpty()) {
                String[] array = text.split(",");
                Monitor monitor = new Monitor(array[0],Double.valueOf(array[1]),Integer.valueOf(array[2]));
                store.setMonitor(monitor);
                text = bufferedReader.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
