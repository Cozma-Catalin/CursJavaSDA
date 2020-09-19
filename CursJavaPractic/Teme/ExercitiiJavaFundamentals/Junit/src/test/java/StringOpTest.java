import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StringOpTest {

    StringOp stringop = new StringOp();

    @BeforeClass
    public static void initializa() {
        System.out.println("Starting tests..." );
    }

    @Before
    public void beforeRunningTest() {
        System.out.println("Testul a inceput la ora:"+System.currentTimeMillis());
    }

    @Test
    public void stringLengthTest() {
        String text = "Catalin";
        int rezultat = stringop.stringLength(text);
        assertEquals(rezultat, 7);
    }

    @Test
    public void stringConcatTest() {
        String text1 = "Ana";
        String text2 = "mere";
        String rezultat = stringop.concat(text1, text2);

        assert rezultat.equals("Anamere");
    }

    @Test
    public void stringContainsTest() {
        String text1 = "Toamna";
        String text2 = "am";
        boolean result = stringop.stringContains(text1, text2);

        assertTrue(result);
    }

    @After
    public void afterRunning() {
        System.out.println("Testul s a terminat la ora:"+System.currentTimeMillis());
    }

    @AfterClass
    public static void end() {
        System.out.println("Done running tests...");
    }
}
