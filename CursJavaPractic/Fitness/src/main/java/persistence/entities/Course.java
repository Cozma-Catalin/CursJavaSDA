package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "deleteCourse",query = "delete from Course where name= :name"),
        @NamedQuery(name = "countCourse",query = "select count(name) from Course where name= :name")
})

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "course_type")
    private String courseType;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Column(name = "duration")
    private int duration;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainers_id")
    private Trainer trainer;
    @ManyToMany(mappedBy = "courseSet",cascade = CascadeType.ALL)
    private Set<Gym> gymSet;
    @ManyToMany(mappedBy = "courseSet",cascade = CascadeType.ALL)
    private Set<Subscription> subscriptionSet;

    public Course(String name,String courseType, String date, String time, int duration, Trainer trainer) {
        this.name = name;
        this.courseType = courseType;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.trainer = trainer;
    }

    public Course(String courseType, String date, String time, int duration, Trainer trainer, Set<Gym> gymSet) {
        this.courseType = courseType;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.trainer = trainer;
        this.gymSet = gymSet;
    }

    public Course(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Set<Gym> getGymSet() {
        return gymSet;
    }

    public void setGymSet(Set<Gym> gymSet) {
        this.gymSet = gymSet;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Subscription> getSubscriptionSet() {
        return subscriptionSet;
    }

    public void setSubscriptionSet(Set<Subscription> subscriptionSet) {
        this.subscriptionSet = subscriptionSet;
    }

    @Override
    public String toString() {
        return "Course: "+ name + " course type " + courseType + ", date: " + date + ", time:" + time + ", duration: " + duration + ", " + trainer;
    }
}
