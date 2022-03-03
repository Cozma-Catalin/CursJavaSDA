public class K2view {
    public int param_a;
    public int param_b;
    public String str;



    public void greet(String name){
        System.out.println("Greetings " + name);
    }

    public void calculate(int a ,int b){
        param_a = a;
        param_b = b;
        str = String.valueOf(a+b);
        System.out.println("a =" + this.param_a + " b= " +this.param_b + " str= "+ this.str);
    }

}
