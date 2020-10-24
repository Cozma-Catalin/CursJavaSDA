import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileReader  {
    private static TextFileReader instance = new TextFileReader();
    private TextFileReader()  {
    }

    public ArrayList readFile(){
            String filePath ="C:\\Users\\Catalin\\Desktop\\TVs.txt";
            ArrayList<TV> tvList = new ArrayList<TV>();
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            while(text!= null){
                String[] line = text.split(" ");
                TV tv = new TV(line[0],line[1],Integer.valueOf(line[2]));
                tvList.add(tv);
             text = bufferedReader.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return tvList;
    }

    public static TextFileReader getInstance() {
        return instance;
    }

    public void setInstance(TextFileReader instance) {
        this.instance = instance;
    }
}
