import java.math.BigInteger;
import java.util.*;

public class NumberOps {

    public static void main(String[] args) {
     /*   System.out.println(findUniq(new double[]{1, 4, 10, 2, 8, 3, 4, 3, 5, 5, 6, 6, 2, 10, 12}));
        System.out.println(grow(new int[]{4,1,1,1,4}));
        System.out.println(isPrime(4));

        pancakeSort(new int[]{1, 5, 4, 3, 2, 10, 9});
      fizzBuzz(20);
        System.out.println(fibRec(7));
        int[] fibNr=fib(8);
        for(int value:fibNr){
            System.out.println(value);
        }*/
        String number = "99730298499892525";
        System.out.println(solve(number));
    }

    public static double sum(double[] numbers) {
        double sum = 0;
        if (numbers != null) {
            for (int i = 0; i < numbers.length; i++) {   // return Arrays.stream(numbers).sum();
                sum += numbers[i];
            }
        }
        return sum;
    }


    public static int solve(final String digits) {
        int largest = 0;
        for (int i = 0; i <= digits.length() - 5; i++) {
            int number = Integer.parseInt(digits.substring(i, i + 5));
            largest = Math.max(number, largest);
        }
        return largest;
    }


    public boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        if ((sqrt - Math.floor(sqrt)) == 0) {
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
    }

    public long findNextSquare(long sq) {
        double sqrt = Math.sqrt(sq);
        double pow = (sqrt - Math.floor(sqrt));
        if (pow == 0) {
            sqrt++;
            return (long) (sqrt * sqrt);
        } else {
            return -1;
        }
    }

    public int modifiedSum(int[] array, int power) {
        int sum = 0;
        for (int value : array) {
            sum = (int) (sum + Math.pow(value, power));
        }
        for (int value : array) {
            sum -= value;
        }
        System.out.println(sum);
        return sum;
    }

    public int nthPower(int[] array, int n) {
        int nr = 0;
        for (int i = 0; i < array.length; i++) {
            if (n < array.length) {
                nr = (int) Math.pow(array[n], n);
                break;
            } else {
                nr = -1;
            }
        }
        System.out.println(nr);
        return nr;
    }

    public int repeats(int[] array) {
        Set<Integer> numbers = new HashSet<>();
        int sum = 0;
        for (int num : array) {
            if (numbers.contains(num)) {
                sum = sum - num;
            } else {
                sum = sum + num;
                numbers.add(num);
            }
        }
        System.out.println(sum);
        return sum;
    }

    public int getAverage(int[] marks) {
        int average = 0;
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        average = sum / marks.length;
        System.out.println(average);
        return average;
    }


    public int Liters(double time) {
        int liters = (int) (time / 2);
        System.out.println(liters);
        return liters;
    }

    public int[] invert(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * -1;
            System.out.println(array[i]);
        }

        return array;
    }


    public static double findUniq(double arr[]) {
        Arrays.sort(arr);

        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                int count = map.get(arr[i]);
                count++;
                map.put(arr[i], count);
            }
        }

        double result = 0;
        Set<Double> keys = map.keySet();
        for (Double key : keys) {
            if (map.get(key) == 1) {
                result = key;
            }
        }
        return result;
    }

    public static int grow(int[] x) {
        int result = 1;
        for (int i = x.length - 1; i >= 0; i--) {
            result *= x[i];
        }
        return result;

    }

    public static boolean isPrime(int num) {
        return num > 1 && BigInteger.valueOf(num).isProbablePrime(1);
    }

    public static void flip(int[] arr, int k) {
        if (arr == null) {
            throw new NullPointerException();
        }
        if (arr.length < (k - 1)) {
            throw new IndexOutOfBoundsException();
        }

        if (arr.length < 2) {
            throw new NoSuchElementException();
        }

        for (int i = 0; i < k / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[k - i - 1];
            arr[k - i - 1] = temp;

        }


    }

    public static int[] pancakeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
//1, 5, 4, 3, 2,10,9-->10,2,3,4,5,1,9-->9,1,5,4,3,2,10-->2,3,4,5,1,9,10-->5,4,3,2,1,9,10-->1,2,3,4,5,9,10-->5,4,3,2,1,9,10-->1,2,3,4,5,9,10
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            flip(arr, max + 1);
            flip(arr, i + 1);
        }
        for (int value : arr) {
            System.out.println(value);
        }
        return arr;
    }

    public static void fizzBuzz(int n) {
        for (int i = 0; i <= n; i++) {
            if (i % 15 == 0) {
                System.out.println("fizz-buzz");
            } else {
                if (i % 5 == 0) {
                    System.out.println("buzz");
                } else {
                    if (i % 3 == 0) {
                        System.out.println("fizz");
                    } else {
                        System.out.println(i);
                    }
                }
            }
        }
    }

    public static int fibRec(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) return 1;

        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static int[] fib(int n) {
        int[] fibNr = new int[n + 1];
        fibNr[1] = 1;
        for (int i = 2; i < n; i++) {
            fibNr[i] = fibNr[i - 1] + fibNr[i - 2];
        }
        return fibNr;
    }
}
