public class Main {
    public static void main(String[] args) {
        String text = "Severe acute respiratory syndrome coronavirus 2 (SARS-CoV-2), a coronavirus responsible for the 2019–20 outbreak";
        rezultat(text);
    }

    public static void rezultat(String text) {
        int count = 0;
        String[] textNou = text.split(" ");
        for (int i = 0; i < textNou.length; i++) {
            if (textNou[i].length() % 2 != 0 && textNou[i].endsWith("e")) {
                count++;
                System.out.println(textNou[i]);
            }
        }
        System.out.println(count);
    }
}