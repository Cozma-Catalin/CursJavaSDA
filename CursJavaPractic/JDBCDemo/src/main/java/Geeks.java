import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Geeks {
    public static void main(String[] args) {

        List<Integer>[] arr = new ArrayList[2];
        Arrays.fill(arr, new ArrayList<>());
        arr[0].add(1);
        arr[1].add(2);
        for (List<Integer> list : arr) {
            System.out.println(list);
        }


    }
}
