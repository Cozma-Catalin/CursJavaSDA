public class Tigru extends Animal implements Carnivore,Salbatic {
    public String move(){
        return "Alearga...";
    }
    public String eat(){
        return "Tigrul vaneaza...";
    }

    @Override
    public boolean pet() {
        return true;
    }
}
