import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator X5 = new Calculator();
        System.out.println(X5.inmultire(3, 8));
        System.out.println(X5.impartire(6, 9));
        System.out.println(X5.adunare(4, 9));
        System.out.println(X5.scadere(8, 5));

        // invatam sa folosim scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Va rugam introduceti primul nr.");
        int primulNr = scanner.nextInt();
        System.out.println("Va rugam introduceti al doilea nr.");
        int alDoileaNr = scanner.nextInt();
        System.out.println("Nr introduse sunt : " + primulNr + ", " + alDoileaNr);
        int adunare = X5.adunare(primulNr, alDoileaNr);
        System.out.println("Rezultatul adunarii este : " + adunare);
        int scadere = X5.scadere(primulNr, alDoileaNr);
        System.out.println("Rezultatul scaderii este " + scadere);
        int inmultire = X5.inmultire(primulNr, alDoileaNr);
        System.out.println("Rezulatatul inmultirii este " + inmultire);
        int impartire = X5.impartire(primulNr, alDoileaNr);
        System.out.println("Rezultatul impartirii este " + impartire);

        CalculatorStiintific calc = new CalculatorStiintific();
        System.out.println("radicalul lui " + primulNr + " este : " + calc.radical(4));
        System.out.println("logaritm in baza 10 al nr-lui " + primulNr + " este " + calc.logaritmBaza10(7));
        System.out.println("logaritmul nr-lui" + primulNr + " este  " + calc.logaritm(6));
        System.out.println("puterea nr-lui " + primulNr + " este " + calc.ridicareLaPutere(3, 8));

        System.out.println("Va rugam introduceti nr ptr ridicarea la putere");
        primulNr = scanner.nextInt();
        System.out.println("va rog introduceti al doilea nr ptr ridicarea la putere");
        alDoileaNr = scanner.nextInt();
        double putere = calc.ridicareLaPutere(primulNr, alDoileaNr);

        System.out.println(primulNr + " la puterea " + alDoileaNr + " este: " + putere);
        System.out.println("Introduceti nr pentru radical");
        primulNr = scanner.nextInt();
        double radical = calc.radical(primulNr);
        System.out.println("Radicalul nr-lui " + primulNr + " este : " + radical);

        System.out.println("Introduceti nr ptr logaritm");
        primulNr = scanner.nextInt();
        double log = calc.logaritm(primulNr);
        System.out.println("Logaritmul nr-lui: " + primulNr + " este: " + log);

        System.out.println("Introduceti nr ptr logaritm baza 10");
        primulNr = scanner.nextInt();
        double log10 = calc.logaritmBaza10(primulNr);
        System.out.println("Logaritm in baza 10 de " + primulNr + " este: " + log10);

        //sa se introduca 2 nr
        int optiune = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti primul nr");
        primulNr = sc.nextInt();
        System.out.println("Introduceti al doilea nr");
        alDoileaNr = sc.nextInt();
        //afisam nr
        System.out.println("Numerele alese sunt " + primulNr + "," + alDoileaNr);
        //sa se afis meniul
        System.out.println("Meniu");
        //1.adunare
        System.out.println("1.Adunare");
        //2.inmultire
        System.out.println("2.Inmultire");
        //3.radical
        System.out.println("3.Radical");
        //4.scadere
        System.out.println("4.Scadere");
        //afisam msg "alegeti o optiune"
        System.out.println("Alegeti una din optiuni");
        //sa se real op in fct de alegere
        //afisam rez
        optiune = sc.nextInt();
        while (optiune != 9) {
            if (optiune == 1) {
                System.out.println("Ati ales optiunea adunare");
                System.out.println("Rezultatul adunarii este =" + calc.adunare(primulNr, alDoileaNr));
            } else if (optiune == 2) {
                System.out.println("Ati ales optiunea inmultire");
                System.out.println("Rezultatul inmultirii este =" + calc.inmultire(primulNr, alDoileaNr));
            } else if (optiune == 3) {
                System.out.println("Ati ales optiunea radical");
                System.out.println("Rezultatul radicalului primului nr este =" + calc.radical(primulNr));
                System.out.println("Rezultatul radicalului celui de al doilea nr este =" + calc.radical(alDoileaNr));
            } else if (optiune == 4) {
                System.out.println("Ati ales optiunea scadere");
                System.out.println("Rezultatul scaderii este =" + calc.scadere(primulNr, alDoileaNr));
            } else {
                System.out.println("Ati introdus o optiune gresita.");
            }
            optiune = sc.nextInt();
        }
        System.out.println("Ati iesit din meniu.O zi buna.");
    }
}
