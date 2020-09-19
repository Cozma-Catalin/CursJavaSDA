public class Main {
    public static void main(String[] args) {
        //verifica daca al 2 lea string se afla in 1 string
        String text1 = "Ana are mere si nu da la nimeni.";
        String text2 = "mere";
        contain(text1, text2);
    }

    public static void contain(String text1, String text2) {
        boolean rezultat = text1.contains(text2);
        System.out.println(rezultat);
    }

}
