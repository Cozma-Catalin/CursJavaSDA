import java.util.Scanner;

public class Atm {
    private double money = 1000;
    private Client client;

    private Atm() {
    }

    private static Atm instance = new Atm();
    Scanner scanner = new Scanner(System.in);

    public void autentificateClient() throws WrongPinNumber{
        System.out.println("Enter pin number.");
        int pin = scanner.nextInt();
        if(pin == client.getPin()){
           displayMeniu();
        }else{
            throw new WrongPinNumber("Wrong pin number !");
        }
    }

    public void displayMeniu(){
        System.out.println("Meniu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("What would you like to do...?");
        int option = scanner.nextInt();
        if(option == 1){
            client.getBalance();
        }else if(option == 2){
          try {
              client.withdraw();
          }catch (NotEnoughMoney e){
              System.out.println(e.getMessage());
          }
        }else if(option == 3){
            client.deposit();
        }else{
            System.out.println("Wrong input !");
        }
    }
    public double getMoney() {
        return money;
    }

    public static Atm getInstance() {
        return instance;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
