package persistence.entities;


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
    @Column(name = "subscription_type")
    private String subscriptionType;
    @Column(name = "number_of_courses")
    private int nrOfCourses;
    @Column(name = "price")
    private int price;
    @Column(name = "enroll")
    private String enroll;
    @Column(name = "end_of_enrollment")
    private String endOfEnrollment;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subscriptions_courses",
    joinColumns = {@JoinColumn(name = "subscriptions_id")},
    inverseJoinColumns = {@JoinColumn(name = "courses_id")})
    private Set<Course> courseSet;

    public Subscription() {
    }

    public Subscription(String name,String subscriptionType,int nrOfCourses,int price ,String enroll, String endOfEnrollment) {
        this.name = name;
        this.subscriptionType = subscriptionType;
        this.nrOfCourses = nrOfCourses;
        this.enroll = enroll;
        this.endOfEnrollment = endOfEnrollment;
        this.price = price;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public int getNrOfCourses() {
        return nrOfCourses;
    }

    public void setNrOfCourses(int nrOfCourses) {
        this.nrOfCourses = nrOfCourses;
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

    public String getEndOfEnrollment() {
        return endOfEnrollment;
    }

    public void setEndOfEnrollment(String endOfEnrollment) {
        this.endOfEnrollment = endOfEnrollment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    @Override
    public String toString() {
        return "Subscription: "+ name + " , " +  subscriptionType + ", number of courses: " + nrOfCourses + ",price: " + price + ", enrolled: " + enroll + ", end of enrollment: " + endOfEnrollment ;
    }
}
