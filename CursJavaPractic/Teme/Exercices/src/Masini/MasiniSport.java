package Masini;

public class MasiniSport extends Masini {
    protected int torque;
    protected int maxSpeed;

    public MasiniSport(int year, String color, int engine, int gear, String fuel, int torque, int maxSpeed) {
        super(year, color, engine, gear, fuel);
        this.torque = torque;
        this.maxSpeed = maxSpeed;
    }

    public void acceleration() {
        System.out.println("Prinde 100 in 3 sec.");
    }

    public void start() {
        System.out.println("Masina asta porneste mai repede.");
    }

    public String toString() {
        return year + color + engine + gear + fuel + torque + maxSpeed;
    }
}
