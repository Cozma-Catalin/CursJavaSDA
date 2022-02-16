import java.util.ArrayList;
import java.util.List;


public class Lambda {


    public static void main(String[] args) {

        Person p1 = new Person("Catalin","male");
        Person p2 = new Person("Cata","male");
        Person p3 = new Person("Catalina","female");
        Person p4 = new Person("Caragiale","male");


        Person[] persons = {p1,p2,p3,p4};

        for(Person p:persons){
            System.out.println(p);
        }


        Child c1 =  new Child();
        c1.sayHello();
        System.out.println(c1.sayHello("Cata"));
    }



}
