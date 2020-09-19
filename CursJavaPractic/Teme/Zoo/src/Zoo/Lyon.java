package Zoo;

public class Lyon extends Carnivore {
    protected boolean sharpTeeth;
    protected boolean claws;

    public Lyon(String gender, int age, String size, String color, boolean eatsMeat, boolean sharpTeeth, boolean claws) {
        super(gender, age, size, color, eatsMeat);
        this.sharpTeeth = sharpTeeth;
        this.claws = claws;
    }

    public void move() {
        System.out.println("This animal runs");
    }

}
