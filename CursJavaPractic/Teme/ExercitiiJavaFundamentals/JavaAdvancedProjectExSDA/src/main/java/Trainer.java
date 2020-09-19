public class Trainer extends Person {
    private boolean authorized;

    public Trainer(String name, String surname, String dateOfBirth,boolean authorized ) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.authorized = authorized;
    }
    public String getAuthorized(){
        if(authorized){
            return "Acest trainer are autorizatie.";
        }else{
            return "Acest trainer nu este autorizat.";
        }
    }

    @Override
    public String toString() {
        return "Trainer: " + getName() + ";" + getSurname() + ";nascut la data de: " + getDateOfBirth() + ";" + getAuthorized();
    }
}
