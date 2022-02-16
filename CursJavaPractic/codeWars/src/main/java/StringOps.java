import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

public class StringOps {

    public static void main(String[] args) {
    /*    System.out.println(getGrade(92,93,94));
        System.out.println(MakeUpperCase("lower case string"));
        System.out.println(makePalindrome("grape"));
        isIsogram("catlin");
        accum("catalin");
    */

        System.out.println(validPhoneNumber("(123) 456-7890"));
        System.out.println(validPhoneNumber("(1111)555 2345"));
        System.out.println(validPhoneNumber("(198) 123 4567"));

    }


        public static boolean validPhoneNumber(String phoneNumber) {
            boolean valid = false;
            if(phoneNumber.matches("\\(\\d{3}\\)\\s\\d{3}-?\\d{4}")){
                valid = true;
            }
            return valid;
        }


    public static StringBuilder makePalindrome(String text) {
        StringBuilder palindrome = new StringBuilder(text);
        if (text.isEmpty()) {
            return new StringBuilder("String is empty!");
        }else if(text.isBlank()){
            return new StringBuilder("String is blank!");
        }

        int k = text.length() - 1;
        if (k <= 2 && Character.valueOf(text.charAt(0)) != Character.valueOf(text.charAt(k))) {
            for (int j = k; j > 0; j--) {
                palindrome.append(Character.valueOf(text.charAt(j - 1)));
            }
            if (k == 2 && Character.valueOf(text.charAt(1)) == Character.valueOf(text.charAt(2))) {
                palindrome.append(Character.valueOf(text.charAt(0)));
            }
        } else {
            for (int i = 0; i < (text.length() / 2) + 1; i++) {
                if (Character.valueOf(text.charAt(i)) == (Character.valueOf(text.charAt(k - i)))) {
                    continue;
                } else {
                    for (int j = text.length() - 1; j > 0; j--) {
                        palindrome.append(Character.valueOf(text.charAt(j - 1)));
                    }
                    break;
                }
            }
        }


        return palindrome;
    }

    public static boolean isIsogram(String str) {
        String[] array = str.toLowerCase().split("");
        boolean isogram = true;
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].contains(array[i+1])) {
                isogram = false;
                break;
            }

        }
        System.out.println(isogram);
        return isogram;
    }

    public static String accum(String s) {
        StringBuilder bldr = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i > 0) bldr.append('-');
            bldr.append(Character.toUpperCase(c));
            for (int j = 0; j < i; j++) {
                bldr.append(Character.toLowerCase(c));
            }
            i++;
        }
        System.out.println(bldr);
        return bldr.toString();
    }

    public String plaingBanjo(String name) {
        if (name.startsWith("R") || name.startsWith("r")) {
            return "Yes i am plaing banjo.";
        }
        return "No, i'm not plaing banjo.";
    }

    public int findShort(String s) {
        String[] words = s.split(" ");
        int i = 0;
        int shortWord = words[i].length();
        for (int j = 1; j < words.length; j++) {
            if (words[j].length() < shortWord) {
                shortWord = words[j].length();
            }
        }
        System.out.println(shortWord);
        return shortWord;
    }

    public void find(String s) {
        System.out.println(Stream.of(s.split(" "))
                .mapToInt(String::length)
                .min()
                .getAsInt());
    }

    public boolean setAlarm(boolean employed, boolean vacation) {
        if (employed && !vacation) {
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
    }

    public String weatherInfo(double temp) {
        double c = convertToCelsius(temp);
        if (c < 0) {
            return (c + " is freezing temperature");
        }
        return (c + " is above freezing temperature");
    }

    public double convertToCelsius(double temperature) {
        double celsius = (temperature - 32) * 5 / 9;
        return celsius;

    }


    public static char getGrade(int s1, int s2, int s3) {


        double avg = (s1 + s2 + s3) / 3;
        return avg >= 90 ? 'A' : avg >= 80 ? 'B' : avg >= 70 ? 'C' : avg >= 60 ? 'D' : 'F';
  /*      if(avg <100 && avg> 90){
            return 'A';
        }else if(avg<90 && avg > 80){
            return 'B';
        }else if(avg<80 && avg > 70){
            return 'C';
        }else if(avg<70 && avg > 60){
            return 'D';
        }else{
            return 'F';
        }*/

    }


    public static String MakeUpperCase(String str) {
        return str.toUpperCase();
    }
}



