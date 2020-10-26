package subscriptions;

public class PlatinumSubscription extends Subscription {
    private String message;
    public PlatinumSubscription() {
        this.message =  "Your login details for online magazine:"  + "username: *** " + "password: *** " +
                "login details for 1st friend: " + "username: *** " + "password: *** " +
                "login details for 2nd friend: " + "username: *** " + "password: *** ";
    }

    public PlatinumSubscription(String message) {
        this.message = message;
    }

    public String getPrice() {
        return "7 $.";
    }

    public String getAcces() {
      return message;
    }
}
