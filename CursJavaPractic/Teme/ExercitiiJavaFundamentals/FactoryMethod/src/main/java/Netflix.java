import java.util.Scanner;

public class Netflix {
    public static void main(String[] args) {

        //sa se introduca de la tastatura optiunea de abonament aleasa
        //in fct de opt aleasa sa se afiseze un msg cu opt aleasa si pretul

        System.out.println("Meniu abonamente Netflix: ");
        System.out.println("1. Standard");
        System.out.println("2. Bussiness");
        System.out.println("3. Premium");
        System.out.println("Alegeti o optiune din meniu.");
        Scanner scan = new Scanner(System.in);
        int optiune = scan.nextInt();
        SubscriptionFactory subscriptionFactory = new SubscriptionFactory();

        if (optiune == 1) {
            Standard standardSuscription = (Standard) subscriptionFactory.getSubscription("Standard");
            System.out.println("Ati ales optiunea Standard cu pretul de :" + standardSuscription.getPrice());
        } else if (optiune == 2) {
            Bussiness bussinessSubscription = (Bussiness) subscriptionFactory.getSubscription("Bussiness");
            System.out.println("Ati ales optiunea Bussiness cu pretul de :" + bussinessSubscription.getPrice());
        } else if (optiune == 3) {
            Premium premiumSubscription = (Premium) subscriptionFactory.getSubscription("Premium");
            System.out.println("Ati ales optiunea Premium cu pretul de :" + premiumSubscription.getPrice());
        } else {
            System.out.println("Nu avem optiunea aceasta.");
        }
        System.out.println("Va multumim. O zi buna!");
    }
}
