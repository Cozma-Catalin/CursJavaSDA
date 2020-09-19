

import java.util.Scanner;

public class Trainee {
    private String nume;
    private int stamina = 1000;
    private int strength;
    private int calorii;

    public Trainee() {

    }


    public Trainee(String nume, int strength, int calorii) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti numele trainee-ului.");
        this.nume = scan.nextLine();
        this.strength = strength;
        this.calorii = calorii;
    }

    public Trainee box(Trainee trainee) {
        System.out.println("Am inceput sesiunea de box.");
        stamina -= 70 - 11;
        strength += 11;
        calorii -= 250;
        return trainee;
    }

    public Trainee cardio(Trainee trainee) {
        System.out.println("Am inceput sesiunea de cardio.");
        stamina -= 30 - 11;
        strength += 11;
        calorii -= 300;
        return trainee;
    }

    public Trainee bodyPump(Trainee trainee) {
        System.out.println("Am inceput sesinea de bodyPump.");
        stamina -= 50 - 11;
        strength += 11;
        calorii -= 500;
        return trainee;
    }

    public String getNume() {
        return nume;
    }


    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }


    public int getCalorii() {
        return calorii;
    }

    public String toString() {
        return "Trainee " + getNume() + " se afla in urmatoarea conditie fizica : -stamina " + getStamina() + " ,-strength " + getStrength() + ",-calorii " + getCalorii() + ".";
    }
}
