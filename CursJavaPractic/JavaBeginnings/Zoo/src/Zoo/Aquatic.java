package Zoo;

public class Aquatic extends Animal{
    protected boolean fin;

    public Aquatic(String gender,int age,String size,String color,boolean fin){
        this.gender = gender;
        this.age = age;
        this.size = size;
        this.color = color;
        this.fin = fin;

    }
    public void move(){
        System.out.println("This animal swimms.");
    }
    public void eating(){
        System.out.println("Eating fish.");
    }
}
