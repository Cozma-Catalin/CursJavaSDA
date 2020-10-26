import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class TextFileReader {


    public ArrayList readFile() {
        String fileToRead = "C:\\Users\\Catalin\\Desktop\\RecapStringsReq.txt";
        ArrayList textList = new ArrayList();
        try {
            FileReader fileReader = new FileReader(fileToRead);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            while (text != null) {
                String[] line = text.split(" ");
                textList.add(line);
                text = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return textList;
    }

}