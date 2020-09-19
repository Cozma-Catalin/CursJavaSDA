import java.io.*;

public class Main {
    public static void main(String[] args) {
        // sa se citeasca dintr un fisier linie cu line
        // sa se scrie in alt fisier liniile din primul fisier care au nr par de cuv
        try {
            //declaram pathu-rile
            String textDeCitit = "C:\\Users\\Catalin\\Desktop\\fisierdecitit.txt";
            String textDeScris = "C:\\Users\\Catalin\\Desktop\\fisierdescris.txt";

            //citim fisierul
            FileReader fileReader = new FileReader(textDeCitit);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //scriem textul
            FileWriter fileWriter = new FileWriter(textDeScris);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String text = bufferedReader.readLine();
            while (text != null) {
                String[] array = text.split(" ");
                if (array.length % 2 == 0) {
                    bufferedWriter.write(text);
                    bufferedWriter.newLine();

                }
                bufferedWriter.flush();
                text = bufferedReader.readLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("A aparut o exceptie: " + e.getMessage());
        }


    }

}
