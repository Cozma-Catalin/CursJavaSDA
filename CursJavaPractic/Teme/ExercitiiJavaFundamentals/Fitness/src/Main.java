import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //sa se modeleze o sedinta de pers training
        //vom avea Trainee(stamina,strength)-se antreneaza L,Miercur,V,
        // porneste cu stamina 1000 de fiecare data cand exerseaza stamina scade si creste strength
        //cardio -L,Miercuri-body pump,V-box
        // cardio: stamina-30,body pump: stamina-50,box: stamina-70
        Scanner scan = new Scanner(System.in);

        Trainee trainee = new Trainee("cata", 50, 5000);
        System.out.println("Introduceti ziua curenta.");
        String ziCurenta = scan.nextLine();
        while ((ziCurenta.equals("Luni") || ziCurenta.equals("Miercuri") || ziCurenta.equals("Vineri"))) {
            switch (ziCurenta) {
                case "Luni":
                    trainee.cardio(trainee);
                    System.out.println(trainee);
                    trainee.setStamina(1000);
                    break;
                case "Miercuri":
                    trainee.bodyPump(trainee);
                    System.out.println(trainee);
                    trainee.setStamina(1000);
                    break;
                case "Vineri":
                    trainee.box(trainee);
                    System.out.println(trainee);
                    trainee.setStamina(1000);
                    break;
                default:
                    System.out.println("Azi nu mergem la sala.");
                    break;
            }

            ziCurenta = scan.nextLine();

        }
        System.out.println("Nu ne antrenam azi.");
        System.out.println(trainee);
        if (trainee.getStamina() <= 0) {
            System.out.println("Trainee-ul " + trainee.getNume() + " a obosit.");


        }
    }
}