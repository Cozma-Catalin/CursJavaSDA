import java.util.Set;

public class SoftwareDevelopmentAcademy {
    private Set<Group> groups;

    private SoftwareDevelopmentAcademy(){
    }

    private static SoftwareDevelopmentAcademy instance = new SoftwareDevelopmentAcademy();

    public static SoftwareDevelopmentAcademy getInstance(){
        return instance;
    }

    public Set<Group> getGroups(){
        return groups;
    }

    public void setGroup(Group group) {
        this.groups = groups;
    }
}
