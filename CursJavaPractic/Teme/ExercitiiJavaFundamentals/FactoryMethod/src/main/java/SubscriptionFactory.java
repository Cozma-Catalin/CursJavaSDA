public class SubscriptionFactory {

    public Subscription getSubscription(String subscriptionName) {
        if (subscriptionName.equals("Standard")) {
            return new Standard();
        } else if (subscriptionName.equals("Bussiness")) {
            return new Bussiness();
        } else if (subscriptionName.equals("Premium")) {
            return new Premium();
        } else {
            return null;
        }
    }
}
