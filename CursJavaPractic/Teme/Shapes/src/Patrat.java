public class Patrat extends Patrulater {
    public Patrat(int nrEdges, int latura1) {
        this.nrEdges = nrEdges;
        this.latura1 = latura1;
    }

    public String draw() {
        return "Desenez un patrat.";
    }

    public double perimetru() {
        return 4 * latura1;
    }
}
