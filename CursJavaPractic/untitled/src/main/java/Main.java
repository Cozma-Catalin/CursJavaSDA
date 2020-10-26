import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti nr:");
        int userInput = scanner.nextInt();
        int[][] array = new int[2][userInput];
        array[0][0] = userInput;
        for (int i = 0; i < userInput; i++) {
            System.out.println("Introduceti valoarea:");
            array[1][i] = scanner.nextInt();
        }
        
        System.out.println("Valorile array ului sunt: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < userInput; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println("");
        }


        int maxCount = 0;
        for (int i = 0; i <= userInput - 2; i++) {
            int count = 1;
            while (i <= userInput - 2 && array[1][i] + array[1][i + 1] == 2) {
                count++;
                i++;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        System.out.println("Cifra '1' se regaseste consecutiv de : " + maxCount + " ori.");
    }
}