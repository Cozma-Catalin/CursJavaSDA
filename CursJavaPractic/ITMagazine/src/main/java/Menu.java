import subscriptions.GoldSubscription;
import subscriptions.PlatinumSubscription;
import subscriptions.Subscription;
import subscriptions.SubscriptionFactory;

import java.util.Scanner;

public class Menu {
    public void display() {
        Scanner scanner = new Scanner(System.in);
        SubscriptionFactory subscriptionFactory = new SubscriptionFactory();
        System.out.println("Welcome on our website !");
        System.out.println("1. Basic Subscription");
        System.out.println("2. Gold Subscription");
        System.out.println("3. Platinum Subscription");
        System.out.println("Choose a subscription from menu:");
        int userInput = scanner.nextInt();
        if (userInput == 1) {
            Subscription basicSubscription = subscriptionFactory.getSubscription("basic");
            System.out.println("Basic Subscription selected." + basicSubscription.getPrice());
        } else if (userInput == 2) {
            Subscription goldSubscription = subscriptionFactory.getSubscription("gold");
            System.out.println("Gold Subscription selected.Price: " + goldSubscription.getPrice() + ((GoldSubscription) goldSubscription).getAcces());
        } else if (userInput == 3) {
            Subscription platinumSubscription = subscriptionFactory.getSubscription("platinum");
            System.out.println("Platinum Subscription selected.Price: " + platinumSubscription.getPrice() + ((PlatinumSubscription) platinumSubscription).getAcces());
        } else {
            System.out.println("This option doesn't exist.");
        }
    }

}
