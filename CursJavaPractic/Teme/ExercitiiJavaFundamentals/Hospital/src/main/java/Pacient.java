public class Pacient extends Persoana {
    protected String varsta;


    public Pacient(String nume, String prenume, String specializare,String varsta) {
        super(nume, prenume, specializare);
        this.varsta = varsta;
    }

    @Override
    public String goingToHospital() {
        return "Merg la spital pentru a ma consulta.";
    }

    @Override
    public String toString() {
        return nume + "," + prenume + "," + specializare + "," + varsta ;
    }


}
