package Zoo;

public class Herbivore extends Animal {
    protected boolean eatsMeat;

    public Herbivore(String gender, int age, String size, String color, boolean eatsMeat) {
        this.gender = gender;
        this.age = age;
        this.size = size;
        this.color = color;
        this.eatsMeat = eatsMeat;
    }

    public void hunt() {
        System.out.println("this animal doesn't hunt.");
    }
    public void eating(){
        System.out.println("Eating plants.");
    }
}
