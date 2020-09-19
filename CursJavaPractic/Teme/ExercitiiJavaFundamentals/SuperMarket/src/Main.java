import javax.xml.crypto.Data;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
// sa se modeleze cosul de cump dintr un superMarket
//fiecare prod sa fie rep de un obiect(nume,pret)
//cosul de cump va fi rep de un array de prod
//sa se afis un meniu cu produsele dorite
//bazat pe ce introducem de la tastatura adaugam in cos
// sa se calc costul total de cumparaturi
//platim cosul de cuparaturi


public class Main {
    public static void main(String[] args) {
        Produs[] cos = new Produs[10];

        System.out.println("Meniu cumparaturi");
        System.out.println("1.Mere");
        System.out.println("2.Oua");
        System.out.println("3.Detergent");
        System.out.println("4.Pasta de dinti");
        System.out.println("5.Mustar");
        System.out.println("6.Bere");
        System.out.println("7.Suc");
        System.out.println("Va rugam alegeti produse din meniu");
        Scanner scan = new Scanner(System.in);
        int optiune = scan.nextInt();
        int pret = 0;
        while (optiune != 0) {
            if (optiune == 1) {
                Produs mere = new Produs("mere", 5);
                cos[0] = mere;
                System.out.println("Ati adaugat " + mere.getNumeProd() + " cu pretul " + mere.getPret() + " in cosul de cumparaturi.");
            } else if (optiune == 2) {
                Produs oua = new Produs("oua", 10);
                cos[1] = oua;
                System.out.println("Ati adaugat " + oua.getNumeProd() + " cu pretul " + oua.getPret() + " in cosul de cumparaturi.");
            } else if (optiune == 3) {
                Produs detergent = new Produs("Detergent0", 32);
                cos[2] = detergent;
                System.out.println("Ati adaugat " + detergent.getNumeProd() + " cu pretul " + detergent.getPret() + " in cosul de cumparaturi.");
            } else if (optiune == 4) {
                Produs pastaDeDinti = new Produs("pasta de dinti", 12);
                cos[3] = pastaDeDinti;
                System.out.println("Ati adaugat " + pastaDeDinti.getNumeProd() + " cu pretul " + pastaDeDinti.getPret() + " in cosul de cuparaturi.");
            } else if (optiune == 5) {
                Produs mustar = new Produs("Mustar", 3);
                cos[4] = mustar;
                System.out.println("Ati adaugat " + mustar.getNumeProd() + " cu pretul " + mustar.getPret() + " in cosul de cumparaturi.");
            } else if (optiune == 6) {
                Produs bere = new Produs("Bere", 8);
                cos[5] = bere;
                System.out.println("Ati adaugat " + bere.getNumeProd() + " cu pretul " + bere.getPret() + " in cosul de cumparaturi.");
            } else if (optiune == 7) {
                Produs suc = new Produs("Suc", 6);
                cos[6] = suc;
                System.out.println("Ati adaugat " + suc.getNumeProd() + " cu pretul " + suc.getPret() + " in cosul de cumparaturi.");
            } else {
                System.out.println("Produsul nu exista.");
            }
            optiune = scan.nextInt();
        }
        System.out.println("Ati iesit din meniul de cumparaturi.");
        System.out.println("Ati cumparat :");
        for (int i = 0; i < cos.length; i++) {
            if (cos[i] != null) {
                System.out.println(cos[i].getNumeProd());
                pret += cos[i].getPret();
            }
        }
        System.out.println("Cosul de cumparaturi costa " + pret + ".");
        System.out.println("S-a platit suma necesara.");
        System.out.println("O zi buna!");
        pret = 0;
        //sa se rep prod perisabile +data exp
        //sa se sim un cos de cump
        //daca utilizatorul cumpara un prod exp afis"prod exp" si nu l mai adaugam in cos
        //adaugam alergeni la afisarea cosului de cump
        //2 cosuri...1cos prod nonalimentare....2cos alimentare
        Date dataAzi = new Date(2020, 5, 7);

        Produs[] cosDeCumparaturi = new Produs[10];
        ProdusAlimentar[] cosProdAlim = new ProdusAlimentar[10];
        System.out.println("Meniu produse alimentare:");
        System.out.println("1.Lapte");
        System.out.println("2.Carne");
        System.out.println("3.Oua");
        System.out.println("4.Matura");
        System.out.println("5.Bec");
        System.out.println("6.Pronto");

        optiune = scan.nextInt();
        while (optiune != 0) {
            if (optiune == 1) {
                System.out.println("Ati selectat Lapte.");
                ProdusAlimentar lapte = new ProdusAlimentar("lapte", 6, true, new Date(2021, 06, 21));
                cosProdAlim[0] = lapte;
            } else if (optiune == 2) {
                System.out.println("Ati selectat Carne.");
                ProdusAlimentar carne = new ProdusAlimentar("Carne", 32, true, new Date(2021, 7, 22));
                cosProdAlim[1] = carne;
            } else if (optiune == 3) {
                System.out.println("Ati selectat Oua.");
                ProdusAlimentar oua = new ProdusAlimentar("oua", 8, true, new Date(2020, 8, 16));
                cosProdAlim[2] = oua;
            } else if (optiune == 4) {
                System.out.println("Ati selectat Matura.");
                Produs matura = new Produs("matura", 7);
                cosDeCumparaturi[0] = matura;
            } else if (optiune == 5) {
                System.out.println("Ati selectat Bec.");
                Produs bec = new Produs("bec", 4);
                cosDeCumparaturi[1] = bec;
            } else if (optiune == 6) {
                System.out.println("Ati selectat Pronto.");
                Produs pronto = new Produs("Pronto", 14);
                cosDeCumparaturi[2] = pronto;
            } else {
                System.out.println("Ati introdus o optiune gresita");
            }
            optiune = scan.nextInt();
        }
        System.out.println("Produsele non alimentare sunt:");
        for (int i = 0; i < cosDeCumparaturi.length; i++) {
            if (cosDeCumparaturi[i].getNumeProd() != null) {
                System.out.println(cosDeCumparaturi[i].getNumeProd() + " la pretul de : " + cosDeCumparaturi[i].getPret() + ".");
            }
        }
        System.out.println("Produsele alimentare sunt :");
        for (int i = 0; i < cosProdAlim.length; i++) {
            if (cosProdAlim[i] != null) {
                System.out.println(cosProdAlim[i].getNumeProd() + " la pretul de :" + cosProdAlim[i].getPret() + "," + "contine alergeni(" + cosProdAlim[i].getAlergeni() + ") si exp la data de :" + cosProdAlim[i].getDataExp() + ".");
                if (cosProdAlim[i].getDataExp().before(dataAzi)) {
                    System.out.println("Produsul selectat a expirat si va fi scos din cosul de cumparaturi.");
                    cosProdAlim[i] = null;
                }
            }
        }
        System.out.println("Pretul total pentr cosul cu alimente este :" + pret);

        for (int i = 0; i < cosProdAlim.length; i++) {
            if (cosProdAlim[i] != null) {
                pret += cosProdAlim[i].getPret();

            }
            System.out.print(pret);
        }
        pret = 0;
        System.out.println("Pretul total pentr cosul cu non-alimente este :" + pret);

        for (int i = 0; i < cosDeCumparaturi.length; i++) {
            pret += cosDeCumparaturi[i].getPret();
            System.out.print(pret);
        }
        pret = 0;
    }
}