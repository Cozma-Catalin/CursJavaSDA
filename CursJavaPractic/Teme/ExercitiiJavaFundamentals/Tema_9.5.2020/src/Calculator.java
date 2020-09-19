import java.util.Calendar;

public class Calculator {
    double x;
    double y;


    public Calculator() {

    }

    public Calculator(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double adunare(double x, double y) {
        return x + y;
    }

    public double scader(double x, double y) {
        return x - y;
    }

    public double inmultire(double x, double y) {
        return x * y;
    }

    public double impartire(double x, double y) {
        return x / y;
    }
}
