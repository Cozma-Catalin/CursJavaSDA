package Zoo;

public class Animal {
    protected String gender;
    protected int age;
    protected String size;
    protected String color;

    public Animal(){

    }

    public Animal(String gender, int age, String size, String color) {
        this.gender = gender;
        this.age = age;
        this.size = size;
        this.color = color;
    }
    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void eating() {
        System.out.println("eating...");
    }

    public void sleeping() {
        System.out.println("sleeping...");
    }

    public void move() {
        System.out.println("running...");
    }
    public void hunt(){
        System.out.println("hunting...");
    }

    public String toString() {
        return "Animals gender is " + getGender() + " " + " it's age is " + getAge() + ", size " + getSize() + " " + " and color " + getColor() + ".";
    }
}

