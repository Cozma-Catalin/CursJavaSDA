import java.util.Scanner;

public class Client {
    private String name;
    private String surname;
    private int pin;
    private double savings;

    public Client(String name, String surname,int pin ,double savings) {
        this.name = name;
        this.surname = surname;
        this.pin = pin;
        this.savings = savings;
    }

    public Client() {
    }

    Atm atm = Atm.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void getBalance() {
        System.out.println("Your balance is : " + getSavings());
    }

    public void withdraw() throws NotEnoughMoney {
        getBalance();
        System.out.println("How much you want to withdraw ?");
        double withdrawAmount = scanner.nextDouble();
        if (atm.getMoney() < withdrawAmount) {
            throw new NotEnoughMoney("We don't have this amount !");
        }
        if (withdrawAmount > getSavings()) {
            System.out.println("You don't have this much.");
        } else {
            savings -= withdrawAmount;
        }
        System.out.println("Your new balance is : " + getSavings());
    }

    public void deposit() {
        System.out.println("How much you want to add ?");
        double depositAmount = scanner.nextDouble();
        savings += depositAmount;
        System.out.println("Your new balance is : " + getSavings());
        atm.setMoney(atm.getMoney() + depositAmount);
    }

    public double getSavings() {
        return savings;
    }

    public int getPin() {
        return pin;
    }

    @Override
    public String toString() {
        return name + ", " + surname + ", savings: " + savings;
    }
}
