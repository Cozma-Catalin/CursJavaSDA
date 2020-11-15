import persistance.dao.CustomerDAO;
import persistance.dao.WorkoutDAO;
import persistance.entities.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Trainer trainer = new Trainer("Lucian","Bute","12.06.1985",2500);
        Set<Workout> workoutSet = new HashSet<>();
        Workout workout = new Workout("Weight lifting","45 min",trainer);
        workoutSet.add(workout);
        Set<Gym> gymSet = new HashSet<>();
        Gym gym = new Gym("Lulu's","Galati","Brailei",workoutSet);
        gymSet.add(gym);


        Subscription subscription = new Subscription("Standard","800","22.02.2020","22.03.2020");
        WorkoutDAO workoutDAO = new WorkoutDAO();
        workoutDAO.insertWorkout(workout);
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = new Customer("Gica","Neaga",1965,gymSet,subscription);
        customerDAO.insertPerson(customer);



    }
}
