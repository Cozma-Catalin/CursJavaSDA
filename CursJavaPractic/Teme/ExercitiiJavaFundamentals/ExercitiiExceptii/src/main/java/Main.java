import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        int x = 13;
        int y = 0;
        try {
            System.out.println(x / y);
        } catch (ArithmeticException e) {
            System.out.println("Incercati o operatie aritmetica imposibila" + e.getMessage());
        }
        int[] array = {1, 2, 3, 4, 5};

        try {
            System.out.println("Valoarea de pe poz3 este: " + array[3]);
            System.out.println("Valoarea de pe poz 16 este " + array[16]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Pozitia cautata nu se incadreaza in limitele array-ului:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("A aparut o exceptie:" + e.getMessage());
        }
        String text = null;
     /*  if (text == null) {
            throw new NullPointerException("Ai uitat sa instantiezi textul");
            }
       */
        try {
            System.out.println(text.length());
        } catch (Exception e) {
            System.out.println("A aparut o exceptie...:" + e.getMessage());
        }
        String text2 = "Tratam exceptii";
        System.out.println(returnChar(text2));
        String text3 = "Tratam";

        try {
            System.out.println(returnChar(text3));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Stringul este mai mic decat poz cautata...:" + e.getMessage());
        }
      /*  System.out.println("Introdu nr ...");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        if (number % 2 == 0) {
            System.out.println("Bravo ati ales un nr par.");
        } else {
            throw new OddNumberException("Ati ales un nr impar");
        }*/

        try {
            cuvant();
        } catch (VowelException e) {
            System.out.println("A aparut o exceptie " + e.getMessage());
        }
    }

    public static char returnChar(String text) throws StringIndexOutOfBoundsException {
        return text.charAt(8);

    }


    public static void cuvant() throws VowelException {
        System.out.println("Introduceti un String");
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        System.out.println("Ati introdus stringul..." + string);
        if (string.startsWith("a") || string.startsWith("e") || string.startsWith("i") || string.startsWith("o") || string.startsWith("u")) {
            throw new VowelException("Cuvantul incepe cu o vocala.");
        } else {
            System.out.println("Cuvantul incepe cu o consoana.");
        }
    }
}