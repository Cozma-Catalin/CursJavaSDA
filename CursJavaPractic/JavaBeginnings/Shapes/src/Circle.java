public class Circle extends Shapes {
    private int raza;

    public Circle() {

    }

    public Circle(int nrEdges, int raza) {
        this.nrEdges = nrEdges;
        this.raza = raza;
    }

    public String draw() {
        return "Desenez un cerc...";
    }

    public double perimetru() {
        return 2 * 3.14 * raza;
    }

    public double arie() {
        return 3.14 * raza * raza;
    }

    public int getRaza() {
        return raza;
    }

    @Override
    public String toString() {
        return "This shape has " + getNrEdges() + " edges and the ray " + getRaza() + ".";
    }
}
