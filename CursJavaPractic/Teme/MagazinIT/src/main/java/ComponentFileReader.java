import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ComponentFileReader {

    public ComponentFileReader(){}
    Store store = Store.getInstance();

    public void readComponentFile() {
        try {
            String filePath = "C:\\Users\\Catalin\\Desktop\\Store\\Components.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            while (text != null && !text.isEmpty()) {
                String[] array = text.split(",");
                if (array[0].equalsIgnoreCase("hardDisk")) {
                    HardDisk hardDisk = new HardDisk(array[1], Double.valueOf(array[2]), Integer.valueOf(array[3]));
                    store.setHardDisk(hardDisk);
                } else if (array[0].equalsIgnoreCase("memoryCard")) {
                    MemoryCard memoryCard = new MemoryCard(array[1], Double.valueOf(array[2]), Integer.valueOf(array[3]));
                    store.setMemoryCard(memoryCard);
                } else if (array[0].equalsIgnoreCase("videoCard")) {
                    VideoCard videoCard = new VideoCard(array[1], Double.valueOf(array[2]), Integer.valueOf(array[3]));
                    store.setVideoCard(videoCard);
                } else if (array[0].equalsIgnoreCase("processor")) {
                    Processor processor = new Processor(array[1], Double.valueOf(array[2]), Integer.valueOf(array[3]));
                    store.setProcessor(processor);
                }
                text = bufferedReader.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
