import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextFileReader {

    public Map<String, Integer> readFile(String filePathToRead) {
        Map<String,Integer> wordsMap = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(filePathToRead);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            while (text != null) {
                int count = 1;
                String[] words = text.split(" ");
                for(String word:words){
                    if(wordsMap.get(word)==null){
                        wordsMap.put(word,count);
                    }else{
                       int wordCount = wordsMap.get(word);
                       wordCount++;
                       wordsMap.get(word.repeat(wordCount));
                    }
                }
                text = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordsMap;
    }
}
