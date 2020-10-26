package subscriptions;

public class GoldSubscription extends Subscription {

    private String message;
    public GoldSubscription() {
        this.message = "Your login details for online magazine: " +
                "username: *** " + "password: *** ";

    }

    public GoldSubscription( String message) {

        this.message = message;
    }

    public String getPrice() {
        return "5 $.";
    }

    public String getAcces() {
        return message;
    }
}
