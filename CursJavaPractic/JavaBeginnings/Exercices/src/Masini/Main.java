package Masini;

public class Main {
    public static void main(String[] args) {
        Audi R8 = new Audi(2018, "grey", 2200, 7, "diesel", 5000, 250, "4x4");
        System.out.println(R8.maxSpeed);
        Masini Mazda = new MasiniSport(2019, "red", 1600, 7, "gas", 3500, 230);
        Mazda.acceleration();
        Masini X5 = new BMW(2017, "black", 2200, 7, "diesel", 4000, 240, "Xdrive");
        X5.start();
        X5.alimentare();
        X5.stop();
        MasiniFitza Cayene = new Porsche(2020, "white", 3000, 7, "diesel", "manele");
        Cayene.gyro();
        MonsterTruck Aro = new MonsterTruck(1990, "yellow", 5000, 5, "bienzina", 50, true);
        Aro.stunts();
        System.out.println(R8);
        System.out.println(Mazda);
        System.out.println(X5);
        System.out.println(Cayene);
        System.out.println(Aro);
    }
}
