import java.util.Scanner;

public class Main {

    //sa se repr un calculator care face op simple,op stiintifice dar si urm op cu stringuri
// (concat,verif daca stringul contine un char,aduna lungimea a2 stringuri,verif daca lungimea unui string este nr par sau nu
// ,transforma un string in sir de char,verific da stringul incepe cu o voc,numara spatiile dintr un string)
    public static void main(String[] args) {
        Calculator x1 = new Calculator(4, 6);
        System.out.println(x1.adunare(4,7));
        System.out.println(x1.scader(3,1));
        System.out.println(x1.impartire(6,2));
        System.out.println(x1.inmultire(4,7));

        CalculatorStiintific x2 = new CalculatorStiintific(5, 8);
        System.out.println(x2.percentage(34));
        System.out.println(x2.pow(6));
        System.out.println(x2.sqrt(9));

        String text = " sa se repr un calculator care face op simple,op stiintifice dar si urm op cu stringuri";
        String textNou = "a se repr un calculator care face op simple,op stiintifice dar si urm op cu stringuri(concat,verif daca stringul contine un char,aduna lungimea a2 stringuri";
        CalculatorStringuri x3 = new CalculatorStringuri(text, textNou);
        System.out.println(x3.concat(text, textNou));
        System.out.println(x3.containsChar(text,"q"));
        System.out.println(x3.incepeCuVocala(text));
        System.out.println(x3.incepeCuVocala(textNou));
        System.out.println(x3.lungimeaTextelor(text, textNou));
        System.out.println(x3.nrSpatii(text));
        System.out.println(x3.parSauImpar(text));
        System.out.println(x3.parSauImpar(textNou));
        System.out.println(x3.sirChars(text));
        System.out.println(x3.pow(5));
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti primul string");
        String string = scan.nextLine();
        System.out.println(x3.incepeCuVocala(string));
        System.out.println("Introduceti al doilea string" );
        String string2 = scan.nextLine();
        System.out.println(x3.concat(string,string2));
        System.out.println(x3.sirChars(string));

    }
}
