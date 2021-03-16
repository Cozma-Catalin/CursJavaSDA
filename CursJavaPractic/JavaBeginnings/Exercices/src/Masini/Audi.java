package Masini;

public class Audi extends MasiniSport {
    protected String tractiune;

    public Audi(int year, String color, int engine, int gear, String fuel, int torque, int maxSpeed, String tractiune) {
        super(year, color, engine, gear, fuel, torque, maxSpeed);
        this.tractiune = tractiune;
    }

    public String toString() {
        return year + color + engine + gear + fuel + torque + maxSpeed + tractiune;
    }
}
