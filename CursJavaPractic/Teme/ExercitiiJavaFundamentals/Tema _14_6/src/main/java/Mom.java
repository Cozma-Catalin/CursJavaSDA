public class Mom extends Person {

    private Mom(String name,String surname,String age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    private static Mom momInstance = new Mom("Vasilica","Ghioaga","45");

    public static Mom getMomInstance() {
        return momInstance;
    }
}
