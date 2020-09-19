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
    @Column(name = "aerobic")
    private int aerobic;
    @OneToMany(mappedBy = "workout",cascade = CascadeType.ALL)
    private Set<Person> person;
    @OneToOne(mappedBy = "workout",cascade = CascadeType.ALL)
    private Subscription subscription;


    public Workout(){}

    public Workout(String name,String duration,int aerobic){
        this.name = name;
        this.duration = duration;
        this.aerobic = aerobic;
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

    public boolean getAerobic() {
        if(this.aerobic==0){
            return false;
        }else{
         return true;
        }
    }

    public void setAerobic(int aerobic) {
        this.aerobic = aerobic;
    }

    @Override
    public String toString() {
        return "Workout " + name + ", duration: " + duration + ", aerobic: " + getAerobic() ;
    }
}
