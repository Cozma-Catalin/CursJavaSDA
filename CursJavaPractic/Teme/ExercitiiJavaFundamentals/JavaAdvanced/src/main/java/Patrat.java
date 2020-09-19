public class Patrat extends Shape implements Calcule {


    public String draw() {
        return "Desenez un patrat.";
    }

    @Override
    public String arie() {
        return "Se calculeaza aria patratului...";
    }

    @Override
    public String perimetru() {
        return "Se calculeaza perimetrul patratului...";
    }
}
