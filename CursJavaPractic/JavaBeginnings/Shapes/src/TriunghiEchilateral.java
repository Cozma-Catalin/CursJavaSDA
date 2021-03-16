public class TriunghiEchilateral extends Triangle {
    public TriunghiEchilateral(int nrEdges,int latura1){
        this.nrEdges = nrEdges;
        this.latura1 = latura1;
    }
    public String draw(){
        return "Desenez un triunghi echilateral.";
    }
    public double perimetru(){
        return 3*latura1;
    }
}
