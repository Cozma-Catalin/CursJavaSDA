public class Child extends Person {

    Child(){
        super();
    }


    @Override
    public void sayHello(){

        System.out.println("Hello from child");
    }

    public String sayHello(String s){
       super.sayHello();
        return "Hello from child overload" + s;
    }
}
