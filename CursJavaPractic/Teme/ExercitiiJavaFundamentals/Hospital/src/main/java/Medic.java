public class Medic extends Persoana implements Ortoped,Radiolog,Chirurg {
    protected boolean deTura;


    public Medic(String nume, String prenume, String specializare, boolean deTura) {
        super(nume, prenume, specializare);
        this.deTura = deTura;
    }




    @Override
    public String goingToHospital() {
        return "Merg la serviciu.";
    }


    @Override
    public void operez() {
        if(this.specializare.equals("Chirurgie")){
            System.out.println("Acest medic opereaza.");
        }else {
            System.out.println("Acest medic nu opereaza.");
        }
    }

    @Override
    public void consultCopii() {
        if(this.specializare.equals("Ortopedie")){
            System.out.println("Acest doctor consulta copii.");
        }else{
            System.out.println("Acest doctor nu consulta copii.");
        }
    }

    @Override
    public void facRadiografie() {
        if(this.specializare.equals("Radiologie")){
            System.out.println("Acest doctor face radiografii.");
        }else{
            System.out.println("Acest doctor nu face radiografii.");
        }
    }


    @Override
    public String toString() {
        return  nume + "," + prenume + "," + specializare + "," + deTura;
    }


}
