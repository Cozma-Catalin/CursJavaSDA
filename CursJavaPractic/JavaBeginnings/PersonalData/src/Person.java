public class Person {
    String fname;
    String lname;
    int age;
    String eyecolor;
    String haircolor;
    String oras;
    public Person( String fname, String lname,int age,String eyecolor,String haircolor,String oras){
      this.fname = fname;
      this.lname = lname;
      this.age = age;
      this.eyecolor = eyecolor;
      this.haircolor = haircolor;
      this.oras = oras;
    }

    public String toString() {
        return "Mă numesc " + this.lname +" " + this.fname + " am " + this.age + " de ani " + "am ochii " + this.eyecolor + ", părul  " + this.haircolor + " și sunt din " + this.oras + ".";
    }
}
