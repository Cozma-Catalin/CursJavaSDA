package persistance.entities;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "year_of_birth")
    private int yearOfBirth;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gym_id")
    private Gym gym;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_id")
    private Workout workout;


    public Person() {
    }

    public Person(String name, String surname, int yearOfBirth, Gym gym ,Subscription subscription, Workout workout) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.gym = gym;
        this.subscription = subscription;
        this.workout = workout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    @Override
    public String toString() {
        return "Person: " + name + ", " + surname + ", yearOfBirth: " + yearOfBirth + ", gym: " + gym + ", subscription: " + subscription + ", workout: " + workout ;
    }
}