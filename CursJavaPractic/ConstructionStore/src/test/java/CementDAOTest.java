import persistance.dao.products.CementDAO;
import org.junit.*;
import static junit.framework.TestCase.assertEquals;
import persistance.entities.products.Cement;
import persistance.entities.structures.Department;
import persistance.entities.structures.Warehouse;

import java.util.HashSet;
import java.util.Set;


public class CementDAOTest {
    CementDAO cementDAO = new CementDAO();

    @BeforeClass
    public static void initialize(){
        System.out.println("Test started...");
    }

    @Before
    public void beforeRunningTest(){
        System.out.println("Test started at: " + System.currentTimeMillis());
    }

    @Test
    public void findCementByBrandTest(){
        Set<Warehouse> warehouses = new HashSet<>();
        Warehouse warehouse = new Warehouse("Depozit 1","Galati","Traian 4");
        Warehouse warehouse1 = new Warehouse("Pietricica","Galati","Cosbuc 34");
        warehouses.add(warehouse1);
        warehouses.add(warehouse);
        String brand = "Ceresit CM 13";
        Department department = new Department("Materiale de constructie");
        Cement result = cementDAO.findCementByBrand(brand);
        assertEquals(result, new Cement("Ceresit CM 13","3 kg",35,100,department,warehouses));
    }

    @AfterClass
    public static void end(){
        System.out.println("The testing ended...");
    }

}
