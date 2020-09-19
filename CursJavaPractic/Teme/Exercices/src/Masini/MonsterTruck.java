package Masini;

public class MonsterTruck extends Masini {
    protected int tyre;
    protected boolean fuselaj;

    public MonsterTruck(int year, String color, int engine, int gear, String fuel, int tyre, boolean fuselaj) {
        super(year, color, engine, gear, fuel);
        this.tyre = tyre;
        this.fuselaj = fuselaj;
    }

    void stunts() {
        System.out.println("Busim masini.");
    }

    public String toString() {
        return year + color + engine + gear + fuel + tyre + fuselaj;
    }
}
