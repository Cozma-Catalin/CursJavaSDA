import java.util.*;

public class Main {
    public static void main(String[] args) {
        //proiect prin care exemplificam folosirea colectiilor din Java

        // Set
        //sa se declare un set in care adaugam 10 din capitalele europei
        Set<String> capitals = new HashSet<String>();
        //adaugam 10 capitale
        capitals.add("Bucuresti");
        capitals.add("Viena");
        capitals.add("Madrid");
        capitals.add("Roma");
        capitals.add("Sofia");
        capitals.add("Budapest");
        capitals.add("Berlin");
        capitals.add("Prague");
        capitals.add("Lisabona");
        capitals.add("London");

        //stergem din set: remove()
        capitals.remove("London");

        //adaugam o intrarea duplicata
        capitals.add("Berlin");
        //deoarece set nu poate contine duplicate Berlin a fost adaugat o singura data.
        //Java verifica daca obj exista in set si nu l mai afiseaza.Verificarea se face folosind metoda HashCode


        //parcurgerea unui set
        for (String capital : capitals) {
            System.out.println("Capitala este " + capital);
        }

        //List
        //sa se adauge intr o lista 10 culori
        //ArrayList

        List<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("black");
        colors.add("yellow");

        for (String color : colors) {
            System.out.println("Culoarea este " + color);
        }

        //LinkedList
        List<Integer> numere = new LinkedList<>();
        numere.add(34);
        numere.add(35);
        numere.add(65);
        for (Integer numar : numere) {
            System.out.println("Numarul este " + numar);
        }

        //Collectiones --> clasa Java care ne ofere aperatii cu colectii gata implementate
        //Metodele din clasa Collectiones sunt statice

        List<Integer> numbers = new LinkedList<>();
        numbers.add(34);
        numbers.add(12);
        numbers.add(65);

        //Sortare
        Collections.sort(numbers);
        for (Integer number : numbers) {
            System.out.println(number);
        }

        Collections.sort(colors);
        for (String color : colors) {
            System.out.println(color);
        }
        //Cautare-->returneaza indexul/pozitia elementului cautat
        int result = Collections.binarySearch(numbers, 65);
        System.out.println(result);
        int max = Collections.max(numbers);
        System.out.println(max);
        int min = Collections.min(numbers);
        System.out.println(min);


        //Map
        //sa se declare un Map in care sa se stocheze fiecare tara cu capitala ei din Europa

        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("Romania", "Bucharest");
        countryCapitalMap.put("Hungary", "Budapest");
        countryCapitalMap.put("Bulgary", "Sofia");

        //perechea key- value--> putem sa luam din map, valoarea in fct de key(daca o stim)
        System.out.println("Capitala Ungariei este:" + countryCapitalMap.get("Hungary"));
        System.out.println("Capitala Bulgariei este:" + countryCapitalMap.get("Bulgary"));

        Map<String, Integer> personMap = new HashMap<>();
        personMap.put("Popescu", 25);
        personMap.put("Ionescu", 35);

        //parcurgem un map
        Set<String> countryCapitalKeys = countryCapitalMap.keySet();
        for (String key : countryCapitalKeys) {
            System.out.println("Valoarea din CountryCapitalMap cheii" + key + "este" + countryCapitalMap.get(key));
        }

        //Map<String,Object>
        //Map<String,List<String>>






    }
}

