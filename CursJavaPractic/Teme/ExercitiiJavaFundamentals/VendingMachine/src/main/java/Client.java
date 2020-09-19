import java.util.Scanner;

public class Client {

    public Client() {

    }

    VendingMachine vendingMachine = VendingMachine.getInstance();
    ProductFactory productFactory = new ProductFactory();

    public void buy() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Add money.");
            int moneyInput = scanner.nextInt();
            if (moneyInput == 0) {
                throw new AmountNotAcceptedException("No money added");
            } else {
                vendingMachine.displayMeniu();
                int meniuOption = scanner.nextInt();
                if (meniuOption == 1) {
                    productFactory.getProduct("Cola");
                    System.out.println(vendingMachine.getCola());

                    if (vendingMachine.getCola().getQuantity() == 0) {
                        throw new NotEnoughAmountException("We don't have any left.");
                    }
                    if (vendingMachine.getCola().getPrice() > moneyInput) {
                        throw new NotEnoughMoneyException("Not enough money.");
                    } else {
                        System.out.println("Here's your change: " + (moneyInput - vendingMachine.getCola().getPrice()));
                        vendingMachine.getCola().setQuantity(vendingMachine.getCola().getQuantity() - 1);
                        System.out.println(vendingMachine.getCola().getQuantity() + " colas left.");
                    }
                } else if (meniuOption == 2) {
                    productFactory.getProduct("Fanta");
                    System.out.println(vendingMachine.getFanta());
                    if (vendingMachine.getFanta().getQuantity() == 0) {
                        throw new NotEnoughAmountException("We don't have any left.");
                    }
                    if (vendingMachine.getFanta().getPrice() > moneyInput) {
                        throw new NotEnoughMoneyException("Not enough money.");
                    } else {
                        System.out.println("Here's your change: " + (moneyInput - vendingMachine.getFanta().getPrice()));
                        vendingMachine.getFanta().setQuantity(vendingMachine.getFanta().getQuantity() - 1);
                        System.out.println(vendingMachine.getFanta().getQuantity() + " fantas left.");
                    }
                } else if (meniuOption == 3) {
                    productFactory.getProduct("Watter");
                    System.out.println(vendingMachine.getWatter());
                    if (vendingMachine.getWatter().getQuantity() == 0) {
                        throw new NotEnoughAmountException("We don't have any left.");
                    }
                    if (vendingMachine.getWatter().getPrice() > moneyInput) {
                        throw new NotEnoughMoneyException("Not enough money.");
                    } else {
                        System.out.println("Here's your change: " + (moneyInput - vendingMachine.getWatter().getPrice()));
                        vendingMachine.getWatter().setQuantity(vendingMachine.getWatter().getQuantity() - 1);
                        System.out.println(vendingMachine.getWatter().getQuantity() + " watters left.");
                    }
                } else if (meniuOption == 4) {
                    productFactory.getProduct("Esspresso");
                    System.out.println(vendingMachine.getEsspresso());
                    if (vendingMachine.getEsspresso().getQuantity() == 0) {
                        throw new NotEnoughAmountException("We don't have any left.");
                    }
                    if (vendingMachine.getEsspresso().getPrice() > moneyInput) {
                        throw new NotEnoughMoneyException("Not enough money.");
                    } else {
                        System.out.println("Here's your change: " + (moneyInput - vendingMachine.getEsspresso().getPrice()));
                        vendingMachine.getEsspresso().setQuantity(vendingMachine.getEsspresso().getQuantity() - 1);
                        System.out.println(vendingMachine.getEsspresso().getQuantity() + " esspressos left.");
                    }
                } else if (meniuOption == 5) {
                    productFactory.getProduct("Americano");
                    System.out.println(vendingMachine.getAmericano());
                    if (vendingMachine.getAmericano().getQuantity() == 0) {
                        throw new NotEnoughAmountException("We don't have any left.");
                    }
                    if (vendingMachine.getAmericano().getPrice() > moneyInput) {
                        throw new NotEnoughMoneyException("Not enough money.");
                    } else {
                        System.out.println("Here's your change: " + (moneyInput - vendingMachine.getAmericano().getPrice()));
                        vendingMachine.getAmericano().setQuantity(vendingMachine.getAmericano().getQuantity() - 1);
                        System.out.println(vendingMachine.getAmericano().getQuantity() + " americanos left.");
                    }
                } else if (meniuOption == 6) {
                    productFactory.getProduct("Cappucino");
                    System.out.println(vendingMachine.getCappucino());
                    if (vendingMachine.getCappucino().getQuantity() == 0) {
                        throw new NotEnoughAmountException("We don't have any left.");
                    }
                    if (vendingMachine.getCappucino().getPrice() > moneyInput) {
                        throw new NotEnoughMoneyException("Not enough money.");
                    } else {
                        System.out.println("Here's your change: " + (moneyInput - vendingMachine.getCappucino().getPrice()));
                        vendingMachine.getCappucino().setQuantity(vendingMachine.getCappucino().getQuantity() - 1);
                        System.out.println(vendingMachine.getCappucino().getQuantity() + " cappucinos left.");
                    }
                } else if (meniuOption == 7) {
                    productFactory.getProduct("Croissant");
                    System.out.println(vendingMachine.getCroissant());
                    if (vendingMachine.getCroissant().getQuantity() == 0) {
                        throw new NotEnoughAmountException("We don't have any left.");
                    }
                    if (vendingMachine.getCroissant().getPrice() > moneyInput) {
                        throw new NotEnoughMoneyException("Not enough money.");
                    } else {
                        System.out.println("Here's your change: " + (moneyInput - vendingMachine.getCroissant().getPrice()));
                        vendingMachine.getCroissant().setQuantity(vendingMachine.getCroissant().getQuantity() - 1);
                        System.out.println(vendingMachine.getCroissant().getQuantity() + " croissants left.");
                    }
                } else if (meniuOption == 8) {
                    productFactory.getProduct("Chips");
                    System.out.println(vendingMachine.getChips());
                    if (vendingMachine.getChips().getQuantity() == 0) {
                        throw new NotEnoughAmountException("We don't have any left.");
                    }
                    if (vendingMachine.getChips().getPrice() > moneyInput) {
                        throw new NotEnoughMoneyException("Not enough money.");
                    } else {
                        System.out.println("Here's your change: " + (moneyInput - vendingMachine.getChips().getPrice()));
                        vendingMachine.getChips().setQuantity(vendingMachine.getChips().getQuantity() - 1);
                        System.out.println(vendingMachine.getChips().getQuantity() + " bags of chips left.");
                    }
                } else if (meniuOption == 9) {
                    productFactory.getProduct("Protein Bar");
                    System.out.println(vendingMachine.getProteinBar());
                    if (vendingMachine.getProteinBar().getQuantity() == 0) {
                        throw new NotEnoughAmountException("We don't have any left.");
                    }
                    if (vendingMachine.getProteinBar().getPrice() > moneyInput) {
                        throw new NotEnoughMoneyException("Not enough money.");
                    } else {
                        System.out.println("Here's your change: " + (moneyInput - vendingMachine.getProteinBar().getPrice()));
                        vendingMachine.getProteinBar().setQuantity(vendingMachine.getProteinBar().getQuantity() - 1);
                        System.out.println(vendingMachine.getProteinBar().getQuantity() + " protein bars left.");
                    }
                } else {
                    System.out.println("We don't have this option.");
                }


            }


        } catch (AmountNotAcceptedException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughAmountException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
}