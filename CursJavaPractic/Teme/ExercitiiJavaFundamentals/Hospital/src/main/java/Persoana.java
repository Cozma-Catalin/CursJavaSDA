public abstract class Persoana {
    protected String nume;
    protected String prenume;
    protected String specializare;


    public Persoana(String nume, String prenume,String specializare){
        this.nume = nume;
        this.prenume = prenume;
        this.specializare = specializare;
    }

    public abstract String goingToHospital();
}
