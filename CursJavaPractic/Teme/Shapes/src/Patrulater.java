public class Patrulater extends Shapes {
    protected int latura1;
    protected int latura2;
    protected int latura3;
    protected int latura4;

    public Patrulater() {

    }

    public Patrulater(int nrEdges, int latura1, int latura2, int latura3, int latura4) {
        this.nrEdges = nrEdges;
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;

    }

    public String draw() {
        return "Desenez unu patrulater";
    }

    public double perimetru() {
        return latura1 + latura2 + latura3 + latura4;
    }

    public double arie() {
        return latura1 * latura2;
    }

    public int getLatura1() {
        return latura1;
    }

    public int getLatura2() {
        return latura2;
    }

    public int getLatura3() {
        return latura3;
    }

    public int getLatura4() {
        return latura4;
    }

    @Override
    public String toString() {
        return "This shape has " + getNrEdges() + " edges and they are : " + getLatura1() + "," + getLatura2() + "," + getLatura3() + "," + getLatura4() + ".";
    }
}
