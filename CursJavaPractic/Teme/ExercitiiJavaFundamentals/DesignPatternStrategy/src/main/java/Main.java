import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Ne ajuta sa amanam comportamentul pana cand stim ce comportament vom folosi optimizand resursele in runtime


        System.out.println("Optiuni de lupta:");
        System.out.println("1. Attack");
        System.out.println("2. Defense");
        System.out.println("Alegeti strategia.");

        Scanner usersInput = new Scanner(System.in);
        int optiune = usersInput.nextInt();

        if(optiune == 1){
            Strategy attackStrategy = new AttackStrategy();
            BattleField attackBattleField = new BattleField(attackStrategy);
            attackBattleField.executeStrategy();
        }else if(optiune == 2){
            Strategy defenseStrategy = new DefenseStrategy();
            BattleField defenseBattleField = new BattleField(defenseStrategy);
            defenseBattleField.executeStrategy();
        }else {
            System.out.println("Nu avem aceasta strategie.");
        }

    }
}
