package Masini;

public class Masini {

    protected int year;
    protected String color;
    protected int engine;
    protected int gear;
    protected String fuel;

    public Masini(int year, String color, int engine, int gear, String fuel) {
        this.year = year;
        this.color = color;
        this.engine = engine;
        this.gear = gear;
        this.fuel = fuel;
    }

    public void start() {
        System.out.println("Masina a pornit.");
    }

    public void stop() {
        System.out.println("Masina s a orpit.");
    }

    public void acceleration() {
        System.out.println("Acceleram.");
    }

    public void alimentare() {
        System.out.println("Alimentez masina.");
    }


    public String toString() {
        return year + color + engine + gear + fuel;
    }
}

