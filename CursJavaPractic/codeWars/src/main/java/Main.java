

public class Main {
    public static void main(String[] args) {

        StringOps stringOps = new StringOps();
        String str = "turns out random test cases are easier than writing out basic ones as";
        stringOps.findShort(str);
        stringOps.find(str);
        stringOps.setAlarm(true,false);
        stringOps.weatherInfo(50);
    /*        stringOps.isIsogram(str);
        stringOps.accum(str);
        char[] chars = {'a','b','c','d','f'};
*/
        NumberOps numberOps = new NumberOps();
        int[] array = {-1,-2,-3,-4,-5};
        numberOps.invert(array);
        /*      int n = 108;
        numberOps.isSquare(n);

        long m = 114;
        numberOps.findNextSquare(m);
      double time = 11.8;
        numberOps.Liters(time);

        //int power = 3;
       // numberOps.getAverage(array);
     //   numberOps.repeats(array);
 //       numberOps.modifiedSum(array,power);
       numberOps.nthPower(array,power);
   */
    }
}
