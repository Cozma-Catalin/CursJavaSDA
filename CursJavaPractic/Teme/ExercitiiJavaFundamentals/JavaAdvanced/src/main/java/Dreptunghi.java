public class Dreptunghi extends Shape implements Calcule {

    public String draw() {
        return "Desenez un dreptunghi.";
    }

    @Override
    public String arie() {
        return "Se calculeaza aria dreptunghiului...";
    }

    @Override
    public String perimetru() {
        return "Se calculeaa perimetrul dreptunghiului...";
    }
}
