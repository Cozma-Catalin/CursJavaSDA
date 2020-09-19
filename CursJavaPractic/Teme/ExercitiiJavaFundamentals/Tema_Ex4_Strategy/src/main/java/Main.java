import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Strategy for the game:");
        System.out.println("1. Park the buss defending");
        System.out.println("2. Defend");
        System.out.println("3. Attack ");
        System.out.println("4. Aggressive Attack ");
        System.out.println("5. All out attacking");
        System.out.println("Choose your strategy.");

        Scanner usersInput = new Scanner(System.in);
        int option = usersInput.nextInt();

        if (option == 1) {
            Strategy parkTheBusStrategy = new ParkTheBusStrategy();
            FootballField footballField = new FootballField(parkTheBusStrategy);
            footballField.applyStrategy();
        } else if (option == 2) {
            Strategy defendStrategy = new DefendStrategy();
            FootballField footballField = new FootballField(defendStrategy);
            footballField.applyStrategy();
        }else if(option == 3){
            Strategy attackStrategy = new AttackStrategy();
            FootballField footballField = new FootballField(attackStrategy);
            footballField.applyStrategy();
        }else if(option == 4){
            Strategy aggressiveAttackStrategy = new AggressiveAttackStrategy();
            FootballField footballField = new FootballField(aggressiveAttackStrategy);
            footballField.applyStrategy();
        }else if(option == 5){
            Strategy allOutAttackStrategy = new AllOutAttackStrategy();
            FootballField footballField = new FootballField(allOutAttackStrategy);
            footballField.applyStrategy();
        }else{
            System.out.println("We don't know what to do.");
        }
        System.out.println("Have a great game !");
    }
}
