import java.util.Random;

public class Bingo {

    public static void main(String[] args) {

        int count = 0;
        while (count != 6) {
            count = 0;
            Random random = new Random();
            int[] bingoNr = new int[6];
            for (int i = 0; i < 6; i++) {
                bingoNr[i] = random.nextInt(50);
                for (int j = 0; j < 6; j++) {
                    if (bingoNr[j] == bingoNr[i]) {
                        bingoNr[i] = random.nextInt(50);
                    }
                }
            }


            for (int i : bingoNr) {

                System.out.print(i + " \t");
            }

            System.out.println("\n========================");

            int[] pickedNumbers = {1, 9, 46, 5, 24, 23};
            for (int i : pickedNumbers) {
                System.out.print(i + " \t");
            }


            for (int i : pickedNumbers) {
                for (int j : bingoNr) {
                    if (i == j) {
                        count++;
                        continue;
                    }
                }

            }

            switch (count) {
                case 1:
                    System.out.println("\nAti ghicit 1 numar");
                    break;
                case 2:
                    System.out.println("\nAti ghicit 2 numere");
                    break;
                case 3:
                    System.out.println("\nAti ghicit 3 numere");
                    break;
                case 4:
                    System.out.println("\nAti ghicit 4 numere");
                    break;
                case 5:
                    System.out.println("\nAti ghicit 5 numere");
                    break;
                case 6:
                    System.out.println("\nFelicitari ati castigat marele premiu");
                    break;
                default:
                    System.out.println("\nNu ati ghicit nimic");
            }

        }
    }
}
