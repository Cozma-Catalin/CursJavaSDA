import java.util.*;

public class MapEx {
    public static void main(String[] args) {
        Map<Integer, Integer> duplicates = new HashMap<>();
        int[] arr = {1, 5, 15, 4, 15, 74, 12, 15, 14, 25, 2, 4, 6, 5};

        for (int value : arr) {
            int count = 1;
            if (duplicates.containsKey(value)) {
                count = duplicates.get(value);
                count++;
            }
            duplicates.put(value, count);
        }

        System.out.println(duplicates.containsValue(2));
        System.out.println("size of map = " + duplicates.size());
        System.out.println("maps values = "+duplicates.values());

        Set<Integer> keySet = duplicates.keySet();
        for(Integer key: keySet){
            if(duplicates.get(key) >1) System.out.println(key + " appears " + duplicates.get(key));
        }
    }
}
