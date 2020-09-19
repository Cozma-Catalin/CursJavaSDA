public class Cerc extends Shape implements Calcule {


    public String draw() {
        return "Desenez un cerc.";
    }
    public String arie(){
        return "Aria cercului este "+2*Math.PI;
    }
    public String perimetru(){
        return "Perimetrul cercului este ";
    }
}
