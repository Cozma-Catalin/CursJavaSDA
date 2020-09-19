import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //motorina,benzina,rep prin calitate,pret pe litrubenz si mot
        //scadem din cantitate...cant<10 afisam msg
        //calc pret
        //obiec pers cu o suma de bani
        //el poate sa plateasca
        //suma platita scade din suma de bani
        //sa primeasca rest
        //daca n are bani afis msg

        Benzinarie OMV = new Benzinarie(500, 2000, 4.32, 5.32);
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti numele persoanei.");
        String nume = scan.nextLine();
        Person client = new Person(nume, 150);
        Scanner meniu = new Scanner(System.in);
        System.out.println("Va rugam alegeti o optiune.");
        System.out.println("!. Benzina");
        System.out.println("2. Motorina");
        int optiune = 0;
        optiune = meniu.nextInt();
        while (optiune != 3) {
            if (optiune == 1) {
                System.out.println("Ati selectat Benzina.");
                System.out.println("Cati litri doriti sa alimentati?");
                int litri = scan.nextInt();
                if (litri < OMV.getBenzina()) {
                    double pret = OMV.vandBenzina(litri);
                    System.out.println("Ati cumparat " + litri + " litri.");
                    System.out.println("Aveti de platit suma de " + pret + ".");
                    //String incasare = OMV.incaseazaBani(client.bani, pret);
                    //System.out.println(incasare);
                    String rezultatTranactie = client.cumparaB(pret);
                    System.out.println(rezultatTranactie);
                    if (rezultatTranactie.startsWith("Nu")) {
                        System.out.println("Pot plati jumatate din suma acum si revin cu restul...?");
                        System.out.println("Ok, aveti de platit: " + pret / 2);
                        String incasare2 = OMV.incaseazaBani(client.bani, pret / 2);
                        client.bani -= pret / 2;
                        System.out.println(incasare2);
                    }

                } else if (litri > OMV.getBenzina()) {
                    System.out.println("Nu avem atata benzina.Alegeti altceva.");
                }
            } else if (optiune == 2) {
                System.out.println("Ati selecctat Motorina.");
                System.out.println("Cati litri doriti sa alimentati?");
                int litri = scan.nextInt();
                if (litri < OMV.getMotorina()) {
                    double pret = OMV.vandMotorina(litri);
                    System.out.println("Ati cumparat " + litri + " litri.");
                    System.out.println("Aveti de platit suma de " + pret + ".");
                    //String incasare = OMV.incaseazaBani(client.bani, pret);
                   // System.out.println(incasare);
                    String rezultatTranzactie = client.cumparaM(pret);
                    System.out.println(rezultatTranzactie);
                    if (rezultatTranzactie.startsWith("Nu")) {
                        System.out.println("Pot plati jumatate din suma acum si revin cu restul...?");
                        System.out.println("Ok, aveti de platit: " + pret / 2);
                        String incasare2 = OMV.incaseazaBani(client.bani, pret / 2);
                        System.out.println(incasare2);
                        client.bani -= pret / 2;
                    }
                } else if (litri > OMV.getMotorina()) {
                    System.out.println("Nu avem atata motorina.Alegeti altceva.");
                }
            } else {
                System.out.println("Nu gasim optiunea.");
            }

            System.out.println("Introduceti urmatoarea optiune.");
            optiune = meniu.nextInt();
        }
        System.out.println("Va multumim, mai poftiti!");
    }
}





