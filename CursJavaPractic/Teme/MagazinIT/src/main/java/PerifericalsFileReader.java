import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PerifericalsFileReader {

    public PerifericalsFileReader(){}
    Store store = Store.getInstance();

    public void readPerifericalsFile() {
        try {
            String filePath = "C:\\Users\\Catalin\\Desktop\\Store\\Perifericals.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            while (text != null && !text.isEmpty()) {
                String[] array = text.split(",");
                    if(array[0].equalsIgnoreCase("keyboard")){
                        Keyboard keyboard = new Keyboard(array[1],Double.valueOf(array[2]),Integer.valueOf(array[3]));
                        store.setKeyboard(keyboard);
                    }else if(array[0].equalsIgnoreCase("mouse")){
                        Mouse mouse = new Mouse(array[1],Double.valueOf(array[2]),Integer.valueOf(array[3]));
                        store.setMouse(mouse);
                    }else if(array[0].equalsIgnoreCase("webCam")){
                        WebCam webCam = new WebCam(array[1],Double.valueOf(array[2]),Integer.valueOf(array[3]));
                        store.setWebCam(webCam);
                    }
                text = bufferedReader.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
