import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOps {

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

    public int getAverage(int[] marks){
        int average = 0;
        int sum = 0;
        for(int i = 0;i<marks.length;i++){
            sum+=marks[i];
        }
        average=sum/marks.length;
        System.out.println(average);
        return average;
    }


    public int Liters(double time)  {
        int liters = (int) (time/2);
        System.out.println(liters);
        return liters;
    }

    public int[] invert(int[] array) {
        for(int i = 0; i<array.length;i++){
            array[i] = array[i] * -1;
            System.out.println(array[i]);
        }

        return array;
    }
}