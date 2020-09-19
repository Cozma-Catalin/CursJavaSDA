public class Main {
    public static void main(String[] args) {
        char[] vectorCaract = {'e', 'l', 'i', 's', 'a', 'v'};
        afisareInversa(vectorCaract);
    }

    //sa se afiseze in ordine inversa un array de caract
    public static void afisareInversa(char[] vectorCaract) {
        for (int i = vectorCaract.length - 1; i >= 0; i--) {
            System.out.println(vectorCaract[i]);
        }
    }
}
