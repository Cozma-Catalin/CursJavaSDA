public class Trainee extends Person {
    private boolean priorKnowledge;
    private String city;

    public Trainee(String name, String surname, String dateOfBirth, boolean priorKnowledge, String city) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.priorKnowledge = priorKnowledge;
        this.city = city;
    }

    public String getPriorKnowledge() {
        if (priorKnowledge) {
            return "This student has prior knowledge in programing.";
        } else {
            return "No prior knowledge in programing.";
        }
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trainee: " + getName() + ";" + getSurname() + ";nascut la data de: " + getDateOfBirth()+ ";" + getCity() + ";" + getPriorKnowledge();
    }
}
