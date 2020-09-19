public class CalculatorStiintific extends Calculator {
    double sqrt;
    double percentage;
    double pow;


    public CalculatorStiintific() {

    }

    public CalculatorStiintific(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double sqrt(double x) {
        return Math.sqrt(x);
    }

    public double percentage(double x) {
        return x / 100;
    }

    public double pow(double x) {
        return Math.pow(x, y);
    }
}
