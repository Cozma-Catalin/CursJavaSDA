import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        int[] numbers = {1, 2, 3, 3, 4, 5, 5, 8, 9, 10, 10,5,8,7};
        checkForDoublesV2(numbers);

    }

    static void checkForDoublesV2(int[] array) {   //O(n) final
        //calculam care este cel mai mare nr din primul vector
        int count = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {   //O(n)
            if (array[i] > max) {
                max = array[i];
            }
        }

        int[] arr = new int[max+1];

        for (int i = 0; i < array.length; i++) {  //O(n)
            if (arr[array[i]] == array[i]) {
                System.out.println(arr[array[i]]);
                count++;
            } else {
                arr[array[i]] = array[i];
            }
        }
        System.out.println(count);

    }
}

