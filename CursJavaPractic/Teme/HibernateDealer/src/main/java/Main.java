import entities.Car;
import entities.Client;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
public class Main {
    public static void main(String[] args) {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        Session session = metadata.getSessionFactoryBuilder().build().openSession();
        session.beginTransaction();
        Car car = new Car();
        car.setBrand("Mercedes-benz");
        car.setModel("GLC-250");
        car.setFuelType("Gas");
        car.setColor("Dark Grey");
        car.setProductionYear(2020);
        session.save(car);
        session.getTransaction().commit();

        Client client = new Client();
        client.setName("Vasile");
        client.setSurname("Cretu");
        client.setAge(42);
        client.setAdress("hjgjhakfh");
        client.setId(2);
        session.save(client);
        session.getTransaction().commit();

        session.close();

    }
}
