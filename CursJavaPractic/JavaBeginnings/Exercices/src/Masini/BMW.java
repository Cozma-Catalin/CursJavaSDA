package Masini;

public class BMW extends MasiniSport {
    protected String tractiune;

    public BMW(int year, String color, int engine, int gear, String fuel, int torque, int maxSpeed, String tractiune) {
        super(year, color, engine, gear, fuel, torque, maxSpeed);
        this.tractiune = tractiune;
    }

    public String toString() {
        return year + color + engine + gear + fuel + torque + maxSpeed + tractiune;
    }
}