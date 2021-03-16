package Zoo;

public class Carnivore extends Animal {
    protected boolean eatsMeat;

    public Carnivore(String gender, int age, String size, String color, boolean eatsMeat) {
        this.eatsMeat = eatsMeat;
        this.gender = gender;
        this.age = age;
        this.size = size;
        this.color = color;
    }

    public void hunt() {
        System.out.println("This animal hunts.");
    }
    public void eating(){
        System.out.println("Eating meat.");
    }

}
