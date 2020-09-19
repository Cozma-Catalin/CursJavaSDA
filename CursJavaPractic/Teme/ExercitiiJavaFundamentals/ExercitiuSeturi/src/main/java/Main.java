import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //sa se citeasca dintr un fisier info despre angajatii unei comp
        //nume,prenume,departament(IT,Vanzari)
        //dupa citire le punem in doua seturi separate(It si Vanzari)
        //afisam cele 2 seturi


        Set<Employee> itSet = new HashSet<>();

        Set<Employee> vanzatoriSet = new HashSet<>();

        Set<Employee> alteOcupatiiSet = new HashSet<>();


        try {
            String path = "C:\\Users\\Catalin\\Desktop\\Angajati.txt";
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String text=bufferedReader.readLine();
            while (text != null) {
                String[] cuvinte = text.split(",");
                Employee emp = new Employee(cuvinte[0], cuvinte[1], cuvinte[2]);
                if (emp.getDepartment().equals("IT")) {
                    itSet.add(emp);
                } else if (emp.getDepartment().equals("Vanzator")) {
                    vanzatoriSet.add(emp);
                } else {
                    alteOcupatiiSet.add(emp);
                }
                text = bufferedReader.readLine();
            }


        } catch (IOException e) {
            System.out.println("A aparut o exceptie" + e.getMessage());
        }

        System.out.println("Primul set este:");
        for (Employee it : itSet) {
            System.out.println("Angajatul din dep IT este:" + it);
        }
        System.out.println("Al doilea set este:");
        for (Employee vanzatori : vanzatoriSet) {
            System.out.println("Angajatul din dep Vanzatori este:" + vanzatori);
        }
        System.out.println("Al treilea set este:");
        for (Employee alteOcupatii : alteOcupatiiSet) {
            System.out.println("Angajatii din dep alte ocupatii este:" + alteOcupatii);
        }

    }
}
