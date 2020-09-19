public class Dad extends Person {
    private Dad(String name, String surname, String age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    private static Dad dadInstance = new Dad("Vasile","Ghioaga","52");

    public static Dad getDadInstance() {
        return dadInstance;
    }
}
