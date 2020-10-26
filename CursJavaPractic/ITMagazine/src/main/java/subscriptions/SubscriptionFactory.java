package subscriptions;

public class SubscriptionFactory {

    public Subscription getSubscription(String subscriptionType) {
        if(subscriptionType.equalsIgnoreCase("basic")){
            return new BasicSubscription();
        }else if(subscriptionType.equalsIgnoreCase("gold")){
            return new GoldSubscription();
        }else if(subscriptionType.equalsIgnoreCase("platinum")){
            return new PlatinumSubscription();
        }else{
            return null;
        }
    }
}
