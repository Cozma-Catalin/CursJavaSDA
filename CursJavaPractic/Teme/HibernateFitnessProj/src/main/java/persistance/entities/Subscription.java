package persistance.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "begin_subscription")
    private String beginSubscription;
    @Column(name = "end_of_subscription")
    private String endOfSubscription;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_id")
    private Workout workout;
    @OneToMany(mappedBy = "subscription",cascade = CascadeType.ALL)
    private Set<Person> person;
    @OneToOne(mappedBy = "subscription",cascade = CascadeType.ALL)
    private Gym gym;






    public Subscription(){}


    public Subscription(String name,String price,String beginSubscription,String endOfSubscription,Gym gym){
        this.name = name;
        this.price = price;
        this.beginSubscription = beginSubscription;
        this.endOfSubscription = endOfSubscription;
        this.gym = gym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBeginSubscription() {
        return beginSubscription;
    }

    public void setBeginSubscription(String beginSubscription) {
        this.beginSubscription = beginSubscription;
    }

    public String getEndOfSubscription() {
        return endOfSubscription;
    }

    public void setEndSubscription(String endSubscription) {
        this.endOfSubscription = endOfSubscription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEndOfSubscription(String endOfSubscription) {
        this.endOfSubscription = endOfSubscription;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    @Override
    public String toString() {
        return "Subscription "+ name + ", price: " + price + ", begining date of Subscription: " + beginSubscription + ", ending date of Subscription: " + endOfSubscription ;
    }
}
