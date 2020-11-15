package persistance.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "duration")
    private String duration;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainers_id")
    private Trainer trainer;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gyms_workouts",
            joinColumns = {@JoinColumn(name = "workouts_id")},
            inverseJoinColumns = {@JoinColumn(name = "gyms_id")})
    private Set<Gym> gymSet;


    public Workout() {
    }

    public Workout(String name, String duration, Trainer trainer,Set<Gym> gymSet) {
        this.name = name;
        this.duration = duration;
        this.trainer = trainer;
        this.gymSet = gymSet;
    }

    public Workout(String name, String duration, Trainer trainer) {
        this.name = name;
        this.duration = duration;
        this.trainer = trainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }


    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Set<Gym> getGymSet() {
        return gymSet;
    }

    public void setGymSet(Set<Gym> gymSet) {
        this.gymSet = gymSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Workout " + name + ", duration: " + duration;
    }
}
