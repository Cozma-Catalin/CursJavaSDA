public class Strings {
    public static void main(String[] args) {
        //Write a Java program to find the length of last word of a given string.
        String text = "te as duce la pescuit dar nu ma lasam pandemia.t";
        String text2 = "du ma acasa mai tramvai.";
        String text3 = "Gil Dobrica.";

        int lungimeUltimCuv = lungimeText(text);


        System.out.println(lungimeUltimCuv);
        comparare(text2, text3);
        printOddChar(text);
        readString(text);
        numarCuv(text);
        int nrCuv2 = numarCuv(text);
        System.out.println(nrCuv2);
        int numarareSpatii =numarareSpatii(text);
        System.out.println(numarareSpatii);
    }

    public static int lungimeText(String text) {
        String[] continut = text.split(" ");
        int lungimeText = continut.length;

        String ultimCuv = continut[lungimeText - 1];
        System.out.println("Ultimul cuvant este :" + ultimCuv);
        int lungimeUltimCuv = ultimCuv.length();
        return lungimeUltimCuv;
    }

    // Write a java program to compare two strings
    public static void comparare(String text2, String text3) {
        int compare = text2.compareTo(text3);
        if (compare == 0) {
            System.out.println("Textele sunt egale.");
        } else if (compare > 0) {
            System.out.println("Primul text este mai mare decat al doilea.");
        } else {

            System.out.println("Textul al doilea este mai mare decat primul.");
        }


    }

    // Write a Java program to print the characters on odd positions
    public static void printOddChar(String text3) {
        int primaPoz = 1;
        int ultimaPoz = text3.length() - 1;
        for (int i = primaPoz; i <= ultimaPoz; i += 2) {
            System.out.println("Pozitiile impare sunt :" + text3.charAt(i));
        }
    }

    // Write a Java program to read a string and if the first or last characters are 't', return the string without those 't' otherwise return the string unchanged.
    public static void readString(String text) {
        char primulCaract = text.charAt(0);
        char ultimulCaract = text.charAt(text.length() - 1);
        if (primulCaract == 't' || ultimulCaract == 't') {
            String cuvantNou = text.replace("t", "");
            System.out.println(cuvantNou);
        } else {
            System.out.println(text);
        }

    }

    // Write a Java program to count the number of words ending in 'm' or 'n' (not case sensitive).
    public static int numarCuv(String text) {
        int nrCuv = 0;

        String[] cuvinte = text.split(" ");

        for (int i = 0; i <= cuvinte.length - 1; i++) {
            if (cuvinte[i].endsWith("m") || cuvinte[i].endsWith("n")) {

                nrCuv++;
            }

        }
        return nrCuv;
    }

    // Write a Java program to count all spaces in a text
    public static int numarareSpatii(String text) {
        int nrSpatii = 0;
        for (int i = 0; i <= text.length() - 1; i++) {
            char cautat = text.charAt(i);
            if (cautat == ' ') {
                nrSpatii++;
            }
        }
        return nrSpatii;
    }    // Write a Java program to remove vowels from a given string.}
}
