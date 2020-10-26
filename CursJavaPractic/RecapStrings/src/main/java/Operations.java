import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

public class Operations {

    TextFileReader textFileReader = new TextFileReader();
    TextFileWriter textFileWriter = new TextFileWriter();

    public void replaceChar() {
        ArrayList list = textFileReader.readFile();
        Iterator iterator = list.iterator();
        System.out.println("Here's the text after the characters have been replaced:");
        while (iterator.hasNext()) {
            String[] line = (String[]) iterator.next();
            for (int i = 1; i < line.length; i++) {
                if (line[i].length() > Integer.parseInt(line[0])) {
                    char[] word = line[i].toCharArray();
                    word[Integer.parseInt(line[0])] = '*';
                    String text = new String(word);
                    line[i] = text;
                }
            }

            for (int i = 0; i < line.length; i++) {
                System.out.print(line[i] + " ");
            }
            System.out.println("");
        }

    }


    public void getCountSqr() {
        ArrayList list = textFileReader.readFile();
        Iterator iterator = list.iterator();
        int countSqr = 0;
        System.out.println("Perfect square numbers are:");
        while (iterator.hasNext()) {
            String[] line = (String[]) iterator.next();
            double sqrt = Math.sqrt(Integer.valueOf(line[0]));
            if (sqrt - Math.floor(sqrt) == 0) {
                System.out.print(line[0] + " ");
                countSqr++;
            }
        }
        System.out.println("");
        System.out.println("Square numbers found: " + countSqr);
    }

    public void getCountVowel() {
        int countVowel = 0;
        ArrayList list = textFileReader.readFile();
        Iterator iterator = list.iterator();
        System.out.println("The vowels are:");
        while (iterator.hasNext()) {
            String[] line = (String[]) iterator.next();
            for (int i = 1; i < line.length; i++) {
                if (line[i].startsWith("a") || line[i].startsWith("e") || line[i].startsWith("i") || line[i].startsWith("o") || line[i].startsWith("u")) {
                    System.out.print(line[i] + " ");
                    countVowel++;
                }
            }
        }
        System.out.println("");
        System.out.println("The vowel count is: " + countVowel);
    }

    public void getLetterCount() {
        int wordsCount = 0;
        ArrayList list = textFileReader.readFile();
        Iterator iterator = list.iterator();
        System.out.println("The words that have the length matching the number are:");
        while (iterator.hasNext()) {
            String[] line = (String[]) iterator.next();
            for (int i = 1; i < line.length; i++) {
                if (Integer.valueOf(line[0]) == line[i].length() - 1) {
                    System.out.print(line[i] + " ");
                    wordsCount++;
                }
            }
        }
        System.out.println("");
        System.out.println("The word count is: " + wordsCount);
    }

    public void getRowLengthMatchingNr() {
        int wordsCount = 0;
        ArrayList list = textFileReader.readFile();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String[] line = (String[]) iterator.next();
            if (Integer.valueOf(line[0]) == line.length - 1) {
                wordsCount++;
            }
        }
        System.out.println("The number of rows that have the length matching the number is : " + wordsCount);
    }

    public void transformText() {
        ArrayList list = textFileReader.readFile();
        Iterator iterator = list.iterator();
        String text = " ";
        while (iterator.hasNext()) {
            String[] line = (String[]) iterator.next();
            line[0] = String.valueOf(Math.pow(Integer.parseInt(line[0]), 3));
            text += line[0] + " ";
            for (int i = 1; i < line.length; i++) {
                if (line[i].endsWith("a") || line[i].endsWith("e") || line[i].endsWith("i") || line[i].endsWith("o") || line[i].endsWith("u")) {
                    text += line[i] + " ";
                }
            }
        }
        textFileWriter.write(text);
        System.out.println("Text has been transformed and written in file...");

    }
}
