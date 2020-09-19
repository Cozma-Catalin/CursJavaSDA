import java.util.ArrayList;
import java.util.List;

public class Family {

    private List<Person> familyMembers = new ArrayList<>();

    private static Family instance = new Family();

    private Family(){

    }

    public List<Person> getFamilyMembers() {
        return familyMembers;
    }

    public static Family getInstance() {
        return instance;
    }

}
