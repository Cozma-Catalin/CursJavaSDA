public class Crocodil extends Animal implements Carnivore,Salbatic {
    public String move(){
        return "Inoata...";
    }
    public String eat(){
        return "Crocodilul mananca carne...";
    }

    @Override
    public boolean pet() {
        return false;
    }
}
