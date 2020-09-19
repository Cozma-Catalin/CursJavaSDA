public class Main {
    public static void main(String[] args) {
        Masina BMW = new Masina(60, "benzina");
        Masina Audi = new Masina(60, "motorina");
        Persoana Eu = new Persoana("cata", 2000, BMW);
        Persoana Tu = new Persoana("marian", 3000, Audi);
        Benzinarie Mol = new Benzinarie(2000, 5.3, 1500, 6.2);
        System.out.println(Eu.maPlimbInAfaraOrasului(BMW, 500));
        System.out.println(Tu.maPlimbInAfaraOrasului(Audi, 550));
        System.out.println(Tu.maPlimbInOras(Audi, 15));
        System.out.println(Eu.maPlimbInOras(BMW, 10));
        Mol.vandB(Eu);
        Mol.vandM(Tu);
        System.out.println("Ati parcurs "+BMW.km+" km.");
        System.out.println("Ati parcurs "+Audi.km+" km.");
        System.out.println(Mol.getMotorina());
        System.out.println(Mol.getBenzina());
        Mol.vandM(Eu);
        Mol.vandB(Tu);
        System.out.println(Mol.getBenzina());
        System.out.println(Mol.getMotorina());


    }

}


