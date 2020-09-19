import java.math.BigInteger;
import java.util.Scanner;

public class Calculator {
    Scanner scan = new Scanner(System.in);

    public Calculator() {

    }


    public long add() throws NumberTooShort {
        System.out.println("Incepem operatiunea de adunare.");
        System.out.println("Introdu o valoare pentru variabila x(mai mult de 15 cifre).");
        long x = scan.nextLong();
        int lengthX = 0;
        long tempX = 1;
        while (tempX <= x) {
            lengthX++;
            tempX *= 10;
        }

        if (lengthX < 15) {
            throw new NumberTooShort("Ati introdus o valoare prea nica pentru X.Este nevoie de un nr cu mai mut de 15 cifre.");
        }
        System.out.println("Introdu o valoare pentru variabila y(mai mult de 15 cifre).");
        long y = scan.nextLong();
        int lengthY = 0;
        long tempY = 1;
        while (tempY <= y) {
            lengthY++;
            tempY *= 10;
        }
        if (lengthY < 15) {
            throw new NumberTooShort("Ati introdus o valoare prea mica pentru Y.Este nevoie de un nr cu mai mut de 15 cifre.");
        }
        System.out.println("Rezultatul adunarii este: ");
        System.out.println(x + y);
        return x + y;
    }

    public long subtract() throws NumberTooShort {
        System.out.println("Incepem operatiunea de scadere.");
        System.out.println("Introdu o valoare pentru variabila x.");
        long x = scan.nextLong();
        int lenghtX = String.valueOf(x).length();
        if (lenghtX < 15) {
            throw new NumberTooShort("Ati introdus o valoare prea nica pentru X.Este nevoie de un nr cu mai mut de 15 cifre.");
        }
        System.out.println("Introdu o valoare pentru variabila y.");
        long y = scan.nextLong();
        int lenghtY = String.valueOf(y).length();
        if (lenghtY < 15) {
            throw new NumberTooShort("Ati introdus o valoare prea nica pentru Y.Este nevoie de un nr cu mai mut de 15 cifre.");
        }
        System.out.println("Rezultatul scaderii este: ");
        System.out.println(x - y);
        return x - y;
    }

    public long multiply() throws NumberTooShort {
        System.out.println("Incepem operatiunea de inmultire.");
        System.out.println("Introdu o valoare pentru variabila x.");
        long x = scan.nextLong();
        int lenghtX = (int) (Math.log10(x) + 1);
        if (lenghtX < 15) {
            throw new NumberTooShort("Ati introdus o valoare prea nica pentru X.Este nevoie de un nr cu mai mut de 15 cifre.");
        }
        System.out.println("Introdu o valoare pentru variabila y.");
        long y = scan.nextLong();
        int lenghtY = (int) (Math.log10(y) + 1);
        if (lenghtY < 15) {
            throw new NumberTooShort("Ati introdus o valoare prea nica pentru Y.Este nevoie de un nr cu mai mut de 15 cifre.");
        }
        System.out.println("Rezultatul inmultirii este: ");
        System.out.println(x * y);
        return x * y;

    }

    public long divide() throws NumberTooShort {
        System.out.println("Incepem operatiunea de impartire.");
        System.out.println("Introdu o valoare pentru variabila x.");
        long x = scan.nextLong();
        int lenghtX = String.valueOf(x).length();
        if (lenghtX < 15) {
            throw new NumberTooShort("Ati introdus o valoare prea nica pentru X.Este nevoie de un nr cu mai mut de 15 cifre.");
        }
        System.out.println("Introdu o valoare pentru variabila y.");
        long y = scan.nextLong();
        int lenghtY = String.valueOf(y).length();
        if (lenghtY < 15) {
            throw new NumberTooShort("Ati introdus o valoare prea nica pentru Y.Este nevoie de un nr cu mai mut de 15 cifre.");
        }
        System.out.println("Rezultatul impartirii este: ");
        System.out.println(Long.divideUnsigned(x, y));
        return Long.divideUnsigned(x, y);

    }

}
