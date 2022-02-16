import java.util.*;
import java.util.stream.Collectors;


public class ArrayListEx {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add(0, "Galati");
        cities.add(1, "Braila");
        cities.add(2, "Bucuresti");
        cities.add("Craiova");
        cities.add("Giurgiu");
        cities.add("Hunedoara");

        System.out.println("=======================");

        cities.forEach(System.out::println);
        System.out.println("=======================");

        List<String> bCities = cities.stream()
                .filter(c -> c.toLowerCase().startsWith("g"))
                .collect(Collectors.toList());
        bCities.forEach(System.out::println);

        System.out.println("======================>");
        List<String> sortedCities = cities.stream()
                .sorted().collect(Collectors.toList());
        sortedCities.forEach(System.out::println);

        System.out.println("<====================");
        List<String> unsortedCities = cities.stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        unsortedCities.forEach(System.out::println);

        int res = Collections.binarySearch(sortedCities,"Galati");
        System.out.println("Index of Galati = "+res);

    }
}


