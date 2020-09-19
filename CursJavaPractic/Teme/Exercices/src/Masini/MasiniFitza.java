package Masini;

public class MasiniFitza extends Masini {
    protected String muzica;

    public MasiniFitza(int year, String color, int engine, int gear, String fuel, String muzica) {
        super(year, color, engine, gear, fuel);
        this.muzica = muzica;
    }

    void gyro() {
        System.out.println("Mergem la agatat.");
    }

    public String toString() {
        return year + color + engine + gear + fuel + muzica;
    }
}
