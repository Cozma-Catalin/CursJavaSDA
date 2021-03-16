public class Shapes {
    protected int nrEdges;

    public Shapes() {

    }

    public String draw() {
        return " Desenez un ...";
    }

    public double perimetru() {
        return 0;
    }

    public double arie() {
        return 0;
    }

    public int getNrEdges() {
        return nrEdges;
    }

    @Override
    public String toString() {
        return "This shape has " + getNrEdges() + " edges.";
    }
}
