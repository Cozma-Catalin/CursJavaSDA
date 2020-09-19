public class Main {
    public static void main(String[] args) {
        String text = "Severe acute respiratory syndrome coronavirus 2 (SARS-CoV-2), a coronavirus responsible for the 2019–20 outbreak";
        exCuStringuri(text);
    }

    //sa se numere cuv dintr-un text care are lungimea >2 contin caract 'i' si caract 'i' se afla pe poz para
    public static void exCuStringuri(String text) {
        int count = 0;
        String[] vector = text.split(" ");
        for (int j = 0; j < vector.length; j++) {
            if (vector[j].length() > 2 && vector[j].indexOf('i') % 2 == 0 && vector[j].contains("i")) {
                count++;
                System.out.println(vector[j]);
            }
        }
        System.out.println(count);
    }
}
