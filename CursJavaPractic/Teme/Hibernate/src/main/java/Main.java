import entities.Student;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class Main {
    public static void main(String[] args) {
        System.out.println("Primul ex in care folosim frameworkul  hibernate");

        // vrem sa salvam un student in baza de date

        // Pasul 1: incarcarea config de hibernate in memoria prog
        //ServiceRegistry - ne ajuta sa incarcam in memoria

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        //Pasul 2 : deschidem o sesiune de comunicare intre programul nostru java(framework ul hibernate si baza de date
        Session session = metadata.getSessionFactoryBuilder().build().openSession();
        session.beginTransaction();
        Student student = new Student();
        student.setName("Marian");
        student.setSurname("Cozma");


        student.setYearOfBirth(1987);
        student.setMajor("Geografie");

        session.save(student);

        session.close();


    }
}
