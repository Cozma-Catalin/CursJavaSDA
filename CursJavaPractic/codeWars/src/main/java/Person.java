import java.io.Serializable;


public class Person implements Serializable {
    private String lang;
    private String name;
    private String sex;
    private String dob;
    private String address;

    public Person() {

    }

    public Person(String name, String sex){
        this.name = name;
        this.sex = sex;

    }


    public Person(String lang ,String name, String sex, String dob, String address) {
        this.lang = lang;
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        this.address = address;

    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void sayHello(){
        System.out.println("Hello from Person");
    }



    @Override
    public String toString() {
        return "Person{" + " lang= '" + lang +
                "' name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                '}';
    }
}
