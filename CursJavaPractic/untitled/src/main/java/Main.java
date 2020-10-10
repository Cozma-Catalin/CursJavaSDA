public class Main {

    public static void main(String[] args) {


        int[] numbers = {1, 2, 3, 3, 4, 5, 5, 8, 9,10, 10};
        checkForDoubles(numbers);

    }

    static void checkForDoubles(int[] array) {
        int count = 0;

        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println(array[i]);
                    count++;
                }
            }
        }
        System.out.println(count);;
    }
}

