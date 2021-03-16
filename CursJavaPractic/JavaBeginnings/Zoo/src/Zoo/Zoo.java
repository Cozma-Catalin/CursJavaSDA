package Zoo;

public class Zoo {
    public static void main(String[] args) {

        Animal A = new Animal("male", 3, "medium", "black");
        System.out.println(A);
        A.eating();
        Carnivore B = new Carnivore("female", 2, "large", "brown", true);
        System.out.println(B);
        B.move();
        Herbivore C = new Herbivore("F", 5, "large", "brown", false);
        C.sleeping();
        System.out.println(C);
        Herbivore D = new Herbivore("M", 4, "large", "blue", false);
        D.hunt();
        System.out.println(D);
        Lyon E = new Lyon("M",6,"L","brown",true,true,true);
        E.eating();
        System.out.println(E);
        Dolphin F = new Dolphin("F",2,"M","grey",true);
        F.move();
        System.out.println(F);
        Animal G = new Dolphin("F",6,"large","space grey",true);
        G.move();
        G.eating();

    }
}
