public class Triangle extends Shapes {
    protected int latura1;
    protected int latura2;
    protected int latura3;
    protected int height;

    public Triangle() {

    }

    public Triangle(int nrEdges, int latura1, int latura2, int latura3, int height) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.height = height;
        this.nrEdges = nrEdges;

    }

    public String draw() {
        return "Desenez un triunghi...";
    }

    public double perimetru() {
        return latura1 + latura2 + latura3;
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

    public int getHeight() {
        return height;
    }

    public double arie() {
        return (latura3 * height) / 2;
    }

    @Override
    public String toString() {
        return "This shape has " + getNrEdges() + " edges and they are " + getLatura1() + "," + getLatura2() + "," + getLatura3() + " and the height is " + getHeight() + ".";
    }
}
