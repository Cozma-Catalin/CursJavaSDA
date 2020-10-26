import java.io.*;

public class TextFileWriter {

    String filePath = "C:\\Users\\Catalin\\Desktop\\RecapStrings.txt";



    public void write(String text){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
