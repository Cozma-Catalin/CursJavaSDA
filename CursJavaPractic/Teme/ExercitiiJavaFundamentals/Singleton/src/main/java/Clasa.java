public class Clasa {

    private String clasa;

    private Clasa(){

    }

    private static Clasa instance = new Clasa();

    public static Clasa getInstance() {
        return instance;
    }

    public String getClasa() {
        return clasa;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }
}
