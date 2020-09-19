import java.io.*;

public class Main {
    public static void main(String[] args) {
        // sa se citeasca randurile dintr un fisier
        //sa afiseze nr de cuv dintr un rand


        //declaram calea catre fisier
        String filePath = "C:\\Users\\Catalin\\Desktop\\fisierdecitit.txt";

        try {
            //incarcarea fisierului in memoria programului cu ajutorul ob fileReader
            FileReader fileReader = new FileReader(filePath);
            //incepem citirea din fisier linie cu line cu ajutorul BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            while (text != null) {
                System.out.println("Linia citita este: " + text);
                String[] array = text.split(" ");
                System.out.println(array.length);
                text = bufferedReader.readLine();

            }

        } catch (IOException e) {
            System.out.println("A aparut o eroare: " + e.getMessage());
        }


        //invatam sa scriem intr un fisier
        String filePathToWrite = "C:\\Users\\Catalin\\Desktop\\fisierdescris.txt";
        try {
            FileWriter fileWriter = new FileWriter(filePathToWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String text = "Mama lu' Ana nu are nici mere si nici pere.";
            String text2 = "smhjhdgfdsbfkdhj";

            bufferedWriter.write(text2);
            bufferedWriter.newLine();
            bufferedWriter.write(text);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("A aparut o exceptie: " + e.getMessage());
        }


    }
}

