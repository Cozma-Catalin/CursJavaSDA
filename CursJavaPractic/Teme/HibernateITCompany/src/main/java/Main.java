import entities.Department;
import entities.Employee;
import entities.Product;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        Session session = metadata.getSessionFactoryBuilder().build().openSession();

        session.beginTransaction();
        Employee employee = new Employee("Catalin", "Cozma", "gafdsfatdsagh", 36, "IT", "junior");
        Employee employee1 = new Employee("Cristian", "Ilie", "jhgfhakfkla", 34, "IT", "junior");
        Employee employee2 = new Employee("Cristian", "Porcaras", "jhgfhakfkla", 28, "IT", "junior");
        Employee employee3 = new Employee("Roxana", "Ioan", "jhgfhakfkla", 27, "IT", "junior");
        Employee employee4 = new Employee("Eduard", "Nastase", "jhgfhakfkla", 29, "IT", "junior");
        Employee employee5 = new Employee("Adrian", "Sava", "jhgfhakfkla", 24, "IT", "junior");
        Employee employee6 = new Employee("Alex", "Ganea", "jhgfhakfkla", 33, "IT", "junior");
        Employee employee7 = new Employee("Cristian", "Codrut", "jhgfhakfkla", 26, "IT", "junior");
        Employee employee8 = new Employee("Marius", "Calarasu", "jhgfhakfkla", 33, "IT", "junior");
        Employee employee9 = new Employee("Alex", "Matei", "jhgfhakfkla", 32, "IT", "Șăf");

        session.save(employee);
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
        session.save(employee5);
        session.save(employee6);
        session.save(employee7);
        session.save(employee8);
        session.save(employee9);

        session.getTransaction().commit();

        session.beginTransaction();

        Product product = new Product("Windows", "10", 900, 6);
        Product product1 = new Product("Bitdefender", "5.6", 700, 20);
        Product product2 = new Product("Kaspersky", "3.2", 750, 35);
        Product product3 = new Product("NOD", "4.1", 800, 110);
        Product product4 = new Product("Firefox", "2.3", 300, 200);
        session.save(product);
        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(product4);

        session.getTransaction().commit();

        session.beginTransaction();
        Department department = new Department("Accounting", 1, 5, "Ion Tiriac");
        Department department1 = new Department("Human Resources", 2, 2, "Viorica Dancila");
        Department department2 = new Department("Development", 3, 4, "Emil Boc");
        Department department3 = new Department("Software Testing", 4, 6, "Carol I");
        Department department4 = new Department("Back End", 5, 20, "Alex Matei");

        session.save(department);
        session.save(department1);
        session.save(department2);
        session.save(department3);
        session.save(department4);

        session.getTransaction().commit();
        //  Sa se mareasca pretul tuturor produselor cu 20%
        session.beginTransaction();
        Query priceChange = session.createNamedQuery("Price_Change");
        int result = priceChange.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();

        // Sa se afisez versiunea unui anumit produs
        session.beginTransaction();
        Query displayVersion = session.createNamedQuery("Display_Version");
        displayVersion.setParameter("name", "Windows");
        List<Product> productList = displayVersion.getResultList();
        for (Product prod : productList) {
            System.out.println(prod);
        }
        session.getTransaction().commit();

        //Sa se stearga produsele care au mai putin de 10 clienti
        session.beginTransaction();
        Query deleteProduct = session.createNamedQuery("Delete_Product");
        result = deleteProduct.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();

        //Sa se afiseze produsele care au mai mult de 200 de clienti
        session.beginTransaction();
        Query displayProduct = session.createNamedQuery("Display_Product");
        List<Product> productList1 = displayProduct.getResultList();
        for (Product prod1 : productList1) {
            System.out.println(prod1);
        }
        
        session.getTransaction().commit();

        //  Sa se stearga departamentele care nu anu nici un angajat
        session.beginTransaction();
        Query deleteDepartmentWithNoEmployees = session.createNamedQuery("Delete_Department_with_no_Employees");
        result = deleteDepartmentWithNoEmployees.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();

        //Sa se afiseze etajul unui anumit departament
        session.beginTransaction();
        Query displayDepartmentByFloor = session.createNamedQuery("Display_Department_By_Floor");
        displayDepartmentByFloor.setParameter("floorNumber", 2);
        List<Department> departmentList = displayDepartmentByFloor.getResultList();
        for (Department dep : departmentList) {
            System.out.println(dep);
        }
        session.getTransaction().commit();

        //Sa se stearga angajatii cu varsta > 65 ani
        session.beginTransaction();
        Query deleteEmployee = session.createNamedQuery("Delete_Employee");
        result = deleteEmployee.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();

        //Sa se modifice functia angajatilor cu varsta intre 35 si 40 ani
        session.beginTransaction();
        Query changePosition = session.createNamedQuery("Change_Position");
        changePosition.setParameter("position", "full stack");
        result = changePosition.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();

        //Sa se afiseze angajatii dintr-un anumit departament
        session.beginTransaction();
        Query displayEmployeesByDepartment = session.createNamedQuery("Display_Employees_by_Department");
        displayEmployeesByDepartment.setParameter("department", "IT");
        List<Employee> employeeList = displayEmployeesByDepartment.getResultList();
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
        session.getTransaction().commit();

        //Sa se afiseze departamentul si functia unui anumit angajat
        session.beginTransaction();
        Query displayEmployeeByDepartmentAndPosition = session.createNamedQuery("Display_Employyes_by_Department_and_Position");
        displayEmployeeByDepartmentAndPosition.setParameter("department", "IT");
        displayEmployeeByDepartmentAndPosition.setParameter("position", "Șăf");
        List<Employee> employeeList1 = displayEmployeeByDepartmentAndPosition.getResultList();
        for (Employee emp1 : employeeList1) {
            System.out.println(emp1);
        }
        session.getTransaction().commit();


        session.close();
    }
}
