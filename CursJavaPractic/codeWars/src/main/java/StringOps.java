import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

public class StringOps {

    public boolean isIsogram(String str) {
        String[] array = str.toLowerCase().split("");
        boolean isogram = true;
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].equalsIgnoreCase(array[i + 1])) {
                isogram = false;
                break;
            }

        }
        System.out.println(isogram);
        return isogram;
    }

    public String accum(String s) {
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
}

