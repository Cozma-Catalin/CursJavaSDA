public class Persoana {
     String name;
     int age;
     String sex;
     String oras;
     Persoana(){
         age = 24;
         name = null;
     }

    Persoana(String name,int age,String sex,String oras) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.oras = oras;

    }


    public String toString() {
        return "Salut " + this.name +  " in varsta de " + this.age + " din orasul " + this.oras + ".";
    }

}
