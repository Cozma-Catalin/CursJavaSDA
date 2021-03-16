import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args){

        System.out.println("Am început cursul de Java la Galați.");
        System.out.println("Azi este Sâmbătă.");
        displayNumber();
        displayTemp();
        String info = "Ce vreme frumoasa este afara.";

        //date & time
        Date now = new Date();
        long millis = System.currentTimeMillis();
        now = new Date(millis);
        System.out.println(now);

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.println(date);

        cal.setTime(now); // convert Date to Calendar
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.DAY_OF_YEAR));
        System.out.println(cal.get(Calendar.WEEK_OF_YEAR));






        char caracterVazut = 'm';
    int place = info.indexOf(caracterVazut);
        System.out.println("Pozitia este " + place + ".");
    // Al catelea caracter este un caracter
    char caracterCautat = 'f';
    int position = info.indexOf(caracterCautat);
        System.out.println("Pozitia este " + position + ".");

    //Caracterul de la o anumita pozitie
        System.out.print("Aici vom afisa caracterul de la pozitia 8: ");
    char caracterGasit = info.charAt(7);
        System.out.println("Caracterul gasit este " + caracterGasit+ ".");

    }

    public static void displayNumber(){

        System.out.println("1");
        System.out.println("2");

    }
    public static void displayTemp(){
        System.out.println("La Galati sunt 12 grade celsius. ");

    }

}
