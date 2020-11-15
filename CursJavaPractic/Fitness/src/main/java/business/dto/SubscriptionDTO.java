package business.dto;

public class SubscriptionDTO {
    private String name;
    private String subscriptionType;
    private int nrOfCourses;
    private int price;
    private String enroll;
    private String endOfEnrollment;

    public SubscriptionDTO() {
    }

    public SubscriptionDTO(String name,String subscriptionType, int nrOfCourses, int price, String enroll, String endOfEnrollment) {
        this.name = name;
        this.subscriptionType = subscriptionType;
        this.nrOfCourses = nrOfCourses;
        this.price = price;
        this.enroll = enroll;
        this.endOfEnrollment = endOfEnrollment;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
}
