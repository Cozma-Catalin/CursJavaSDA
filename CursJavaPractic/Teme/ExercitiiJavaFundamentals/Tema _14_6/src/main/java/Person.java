public abstract class Person {
    protected String name;
    protected String surname;
    protected String age;

    public Person(){
    }

    @Override
    public String toString() {
        return name + "," + surname + "," + age + ".";
    }
}
