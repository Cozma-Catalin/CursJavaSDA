public class Meniu {
    private String bauturi = "cola,pepsi,bere";
    //Singleton este un design pattern -->prin care ne asiguram ca intotdeauna vom avea o singura instanta creata pentru mai multe obiect de acelasi fel
    //Pasul 1. --> constructorul clasei trebuie sa fie privat
    //Pasul 2. --> se instantiaza o variabila privata si statica de tipul Meniu si o vom denumi instance
    //Pasul 3. --> oferim accesul catre instanta noastra printr o metoda de tipul get
    //1.
    private Meniu() {

    }

    //2.
    private static Meniu instance = new Meniu();

    //3.
    public static Meniu getInstance(){
        return instance;
    }

    public String getBauturi() {
        return bauturi;
    }

    public void setBauturi(String bauturi) {
        this.bauturi = bauturi;
    }
}
