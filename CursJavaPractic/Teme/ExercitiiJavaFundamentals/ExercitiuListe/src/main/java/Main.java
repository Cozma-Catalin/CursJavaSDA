import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //sa se citeasca dintr un fisier
        //pe primul rand avem un sir de nr separate prin ;
        //sa se ordoneze nr
        //sa se caute nr 325
        //sa se afis max si min
        //sa se afis fara duplicate
        //sa se afis in ordinea inversa
        List<Integer> arrayList = new ArrayList<Integer>();
        try {
            String path = "C:\\Users\\Catalin\\Desktop\\ExercitiuLista.txt";
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            String[] numbers = text.split(";");
            for (String nr : numbers) {
                arrayList.add(Integer.valueOf(nr));
            }
            for (Integer number : arrayList) {
                System.out.println(number);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        Collections.sort(arrayList);
        for (Integer number : arrayList) {
            System.out.println(number);
        }
        int result = Collections.binarySearch(arrayList, 325);
        System.out.println(result);
        int max = Collections.max(arrayList);
        System.out.println(max);
        int min = Collections.min(arrayList);
        System.out.println(min);
        Collections.reverse(arrayList);
        for (Integer number : arrayList) {
            System.out.println(number);
        }

        Set<Integer> numbersSet = new HashSet<>();
        for (Integer number : arrayList) {
            numbersSet.add(number);
        }
        for (Integer number : numbersSet) {
            System.out.println(number);
        }
    }
}
