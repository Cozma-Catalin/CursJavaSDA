import java.util.*;

public class Main {

    public static void main(String[] args) {
     /*   Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println("Introduceti numerele");
        for (int i = 0; i < 10; i++) {
            int number = scanner.nextInt();
            linkedList.add(number);
            arrayList.add(number);
        }

        displayNumbers(linkedList);
        removeEvenNumbers(linkedList);
        removeElementsOnOddPosition(arrayList);


        char[] cuv = {'a', 'm', 'm', 'a','s'};

        checkIfPalindrome(cuv);
*/

    int[] array = new int[1030];
    for(int i = 0;i<array.length;i++){
        array[i]=i;
    }

    displayFibNr(array);



    }

    static void removeEvenNumbers(LinkedList<Integer> linkedList) {
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            int number = (Integer) iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println("LinkedList ul dupa eliminarea nr pare");
        displayNumbers(linkedList);
    }

    static void displayNumbers(LinkedList<Integer> linkedList) {
        for (Integer numbers : linkedList) {
            System.out.println(numbers);
        }
    }

    static void removeElementsOnOddPosition(ArrayList arrayList) {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            int i = (int) iterator.next();
            if (i % 2 != 0) {
                iterator.remove();
            }
        }
        System.out.println("ArrayList ul fara pozitii impare:");
        for (int j = 0; j < arrayList.size(); j++) {
            System.out.println(arrayList.get(j));
        }
    }

    static void checkIfPalindrome(char[] array) {
        boolean palindrome = false;
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] == array[j]) {
                palindrome = true;
            } else {
                palindrome = false;
                break;
            }
            i++;
            j--;
        }
        System.out.println("Is the word a palindrome?");
        System.out.println(palindrome);

    }

    static void displayFibNr(int[] arrary){

        int i = 0;
        int j = 1;
        int fibNr=0;

        while(fibNr<arrary.length){
            System.out.println(fibNr); //0-->1-->1-->2-->3
            fibNr = j;                 //fibNr=1-->fibNr=1-->fibNr=2-->fibNr=3
            j= i + j;                  //j=1-->j=2-->j=3-->j=5
            i =fibNr;                  //i=1-->i=1-->i=2-->i=3

        }
    }

}
