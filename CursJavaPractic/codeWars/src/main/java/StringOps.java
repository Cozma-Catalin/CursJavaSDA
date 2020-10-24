import java.util.Arrays;

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

    public String plaingBanjo(String name){
        if(name.startsWith("R")||name.startsWith("r")){
            return "Yes i am plaing banjo.";
        }
        return "No, i'm not plaing banjo.";
    }
}
