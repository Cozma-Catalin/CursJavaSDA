import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PcFileReader {

    public PcFileReader(){}

    Store store = Store.getInstance();

    public void readFile(){
        try{
            String filePath = "C:\\Users\\Catalin\\Desktop\\Store\\PC.txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String text = bufferedReader.readLine();
            while(text != null && !text.isEmpty()){
                String[] array = text.split(",");
                Pc pc = new Pc(array[0],Integer.valueOf(array[1]),Integer.valueOf(array[2]));
                store.setPc(pc);
                text = bufferedReader.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
