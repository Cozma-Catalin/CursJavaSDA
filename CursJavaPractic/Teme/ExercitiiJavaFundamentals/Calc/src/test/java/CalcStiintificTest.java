import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalcStiintificTest {
    CalcStiintific calc = new CalcStiintific();
    @Test
    public void putereTest(){
        int a =3;
        int b = 3;
        double result = calc.putere(a,b);
        assert result == 27;
    }
    @Test
    public void sqrtTest(){
        int a=9;
        double result = calc.sqrt(a);
        assert result== 3;
    }
    @Test
    public void logTest(){
        int a = 27;
        double result = calc.log(a);
        assertEquals (result ,3.295836866004329);
    }

}
