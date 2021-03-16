import org.w3c.dom.ls.LSOutput;

public class exercitiu3 {
    public static void main(String [] args){
        int a = 3;
        int b = 66;
        int c = 465;
        int d = 1000;

        boolean rezultat = suma(a,b,c,d);
        System.out.println(rezultat);
        String rezultatScadere = scadere(a,b,c,d);
        System.out.println(rezultatScadere);
        nrPare(a);
        nrPare(b);
        nrPare(c);
        nrPare(d);
        int varsta = 0;

        while(varsta < 18){
            System.out.println("Copilul este intretinut de parinti.");
            varsta += 3;
            System.out.println(varsta);
        }
    }
    static boolean suma(int a, int b, int c, int d){
        int suma = a+b+c+d;
        if (suma>100){
            return true;
        } else{
            return false;
        }
    }
    static String scadere(int a, int b, int c, int d) {
        int scadere = a - b - c - d;
        if (scadere > 0) {
            return "Adevarat";

        } else {
            return "False";
        }
    }
        static void nrPare(int a){
          if (a%2==0){
            System.out.println("Numarul " + a +" este par.");
        }else {
            System.out.println("Numarul " + a + " este impar.");
        }
    }

//sa se declare o variabila care sa reprezinte 1 zi a lunii
    //sa se afiseze msg "Duminica daca ziua si luna se imparte la 7
    //sa se afiseze msg "sambata daca ziua din luna se imp la 6
    //sa se afiseze s a terminat luna daca ziua este egala cu 28
    //sa se declare o variabila care sa rep luna din an
    //sa se afiseze toate lunile anului
    //sa se afiseze msg concediu daca luna este iul
    //sa se afis craciun daca luna este dec
    //sa se afis incepe scoala daca luna este sept
 int ziLuna = 1;

}
