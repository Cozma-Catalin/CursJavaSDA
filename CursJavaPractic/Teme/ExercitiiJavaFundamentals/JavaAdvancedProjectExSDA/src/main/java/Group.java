import java.util.Set;

public class Group {
    private String groupName;
    private Trainer trainer;
    private Set<Trainee> trainees;

    public Group(String groupName, Trainer trainer, Set<Trainee> trainees) {
        this.groupName = groupName;
        this.trainer = trainer;
        this.trainees = trainees;

    }

    public String getGroupName() {
        return groupName;
    }


    public Trainer getTrainer() {
        return trainer;
    }

    public Set<Trainee> getTrainees() {
        return trainees;
    }
}
