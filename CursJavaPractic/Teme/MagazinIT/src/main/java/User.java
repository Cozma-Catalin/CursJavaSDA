import Exceptions.NotEnaughMoneyException;
import Exceptions.NotEnaughQuantityException;

import java.util.Scanner;
import java.util.Set;

public class User {
    private int money;


    public User(int money) {
        this.money = money;
    }

    Store store = Store.getInstance();
    Scanner scanner = new Scanner(System.in);


    public void cart(String productName){

        System.out.println("Your products are: " + productName);
    }

    public void browseMeniu() throws NotEnaughMoneyException, NotEnaughQuantityException {
        store.displayMeniu();
        int usersInput = scanner.nextInt();
        if (usersInput == 1) {
            Set<String> lapTops = store.getLapTop().keySet();
            for (String key : lapTops) {
                if (store.getLapTop().get(key).getPrice() > getMoney()) {
                    throw new NotEnaughMoneyException("You don't have enaugh money...");
                }
                if (store.getLapTop().get(key).getQuantity() <= 0) {
                    throw new NotEnaughQuantityException("We don't have any left !");
                }
                System.out.println(store.getLapTop().get(key));
                System.out.println("Which one you like...?");
                String option = scanner.nextLine();
                if("Acer".equalsIgnoreCase(option)){
                    cart("Acer");
                }
            }
        } else if (usersInput == 2) {
            if (store.getPc().getPrice() > getMoney()) {
                throw new NotEnaughMoneyException("You don't have enaugh money...");
            }
            if (store.getPc().getQuantity() == 0) {
                throw new NotEnaughQuantityException("We don't have any left !");
            }

            System.out.println(store.getPc());
        } else if (usersInput == 3) {
            System.out.println("1. HardDisk ");
            System.out.println("2. Memory ");
            System.out.println("3. Processor");
            System.out.println("4. Video Card");
            int option = scanner.nextInt();
            if (option == 1) {
                if (store.getHardDisk().getPrice() > getMoney()) {
                    throw new NotEnaughMoneyException("You don't have enaugh money...");
                }
                if (store.getHardDisk().getQuantity() <= 0) {
                    throw new NotEnaughQuantityException("We don't have any left !");
                }
                System.out.println(store.getHardDisk());
            } else if (option == 2) {
                if (store.getMemoryCard().getPrice() > getMoney()) {
                    throw new NotEnaughMoneyException("You don't have enaugh money...");
                }

                if (store.getMemoryCard().getQuantity() <= 0) {
                    throw new NotEnaughQuantityException("We don't have any left !");
                }

                System.out.println(store.getMemoryCard());
            } else if (option == 3) {
                if (store.getProcessor().getPrice() > getMoney()) {
                    throw new NotEnaughMoneyException("You don't have enaugh money...");
                }
                if (store.getProcessor().getQuantity() <= 0) {
                    throw new NotEnaughQuantityException("We don't have any left !");
                }

                System.out.println(store.getProcessor());
            } else if (option == 4) {
                if (store.getVideoCard().getPrice() > getMoney()) {
                    throw new NotEnaughMoneyException("You don't have enaugh money...");
                }
                if (store.getVideoCard().getQuantity() <= 0) {
                    throw new NotEnaughQuantityException("We don't have any left !");
                }

                System.out.println(store.getVideoCard());
            } else {
                System.out.println("We don't have that !");
            }
        } else if (usersInput == 4) {
            System.out.println("1. Keyboard");
            System.out.println("2. Mouse");
            System.out.println("3. Web Cam");
            int option = scanner.nextInt();
            if (option == 1) {
                if (store.getKeyboard().getPrice() > getMoney()) {
                    throw new NotEnaughMoneyException("You don't have enaugh money...");
                }
                if (store.getKeyboard().getQuantity() <= 0) {
                    throw new NotEnaughQuantityException("We don't have any left !");
                }

                System.out.println(store.getKeyboard());
            } else if (option == 2) {
                if (store.getMouse().getPrice() > getMoney()) {
                    throw new NotEnaughMoneyException("You don't have enaugh money...");
                }
                if (store.getMouse().getQuantity() <= 0) {
                    throw new NotEnaughQuantityException("We don't have any left !");
                }

                System.out.println(store.getMouse());
            } else if (option == 3) {
                if (store.getWebCam().getPrice() > getMoney()) {
                    throw new NotEnaughMoneyException("You don't have enaugh money...");
                }
                if (store.getWebCam().getQuantity() <= 0) {
                    throw new NotEnaughQuantityException("We don't have any left !");
                }

                System.out.println(store.getWebCam());
            } else {
                System.out.println("We don't have that !");
            }
        } else {
            System.out.println("Wrong input !");
        }

    }

    public int getMoney() {
        return money;
    }
}
