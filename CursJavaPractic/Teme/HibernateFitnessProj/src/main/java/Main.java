import persistance.dao.GymDAO;
import persistance.dao.PersonDAO;
import persistance.dao.SubscriptionDAO;
import persistance.dao.WorkoutDAO;
import persistance.entities.Gym;
import persistance.entities.Person;
import persistance.entities.Subscription;
import persistance.entities.Workout;

public class Main {
    public static void main(String[] args) {
        //Sa se modeleze o sala de fitness
        //Avem urmatoarele entitati:
        //- o persoana care are nume, prenume, anul nasterii
        //- abonament: nume, pret, data de inceput, data de sfarsit
        //- antrenament: nume, durata, daca e aerobic sau nu (boolean)
        //- sala de antrenament: o singura sala tine un anumit antrenament
        //
        //1. Sa se modeleze BD cu relatiile aferente intre tabele
        //2. Sa se modeleze entitatile cu relatiile aferente intre ele (evitam relatiile many to many)
        //3. Sa se insereze 5 persoane, 3 abonamente si 10 antrenamente (din Java)
        //4. Se se respecte Hibernate best practices
        //
        //Folosim one to one si one to many

        PersonDAO personDAO = new PersonDAO();
        GymDAO gymDAO = new GymDAO();
        SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
        WorkoutDAO workoutDAO = new WorkoutDAO();

        Workout workout = new Workout("Weight lifting","45 min",0);
        //workoutDAO.insertWorkout(workout);

        Gym gym = new Gym("Lulu's","Galati","Brailei");
        // gymDAO.insertGym(gym);

        Subscription subscription = new Subscription("Standard","800","22.02.2020","22.03.2020",gym);
        //subscriptionDAO.insertSubscription(subscription);



        Person person = new Person("Gica","Neaga",1965,gym,subscription,workout);
        personDAO.insertPerson(person);



    }
}
