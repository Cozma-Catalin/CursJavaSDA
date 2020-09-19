public class Main {
    public static void main(String[] args) {
        String text = "Severe acute respiratory syndrome coronavirus 2 (SARS-CoV-2), a coronavirus responsible for the 2019–20 outbreak";
        afisareCuvinte(text);
        litDePePoz3(text);
    }

    // sa se afiseze toate cuv care incep cu litera s sau d
    public static void afisareCuvinte(String text) {
        String[] vector = text.split(" ");
        for (int i = 0; i < vector.length; i++) {
            if (vector[i].startsWith("s") || vector[i].startsWith("d")) {
                System.out.println(vector[i]);
            }
        }
    }

    //sa se afis lit de la poz 3 din fiecare cuv
    public static void litDePePoz3(String text) {
        int j = 3;
        String[] vector = text.split(" ");
        for (int i = 0; i < vector.length; i++) {
            if (vector[i].length() > j) {
                System.out.println("Avem cuv " + vector[i] + ", litera de pe poz 3 este : " + vector[i].charAt(j));
            }
        }
    }
}
