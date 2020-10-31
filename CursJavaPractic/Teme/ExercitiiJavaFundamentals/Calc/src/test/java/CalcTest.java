import org.junit.Test;


import static junit.framework.TestCase.assertEquals;

public class CalcTest {
Calc calc = new Calc();
    @Test
    public void adunareTest(){
        System.out.println("Testam adunarea.");
        //given
        int a = 5;
        int b = 9;
        //when
        int result = calc.adunare(a,b);
        //then
        assert result ==14;
    }
    @Test
    public void scadereTest(){
        int a = 9;
        int b = 5;
        int result = calc.scadere(a,b);
        assertEquals(result,4);
    }
    @Test
    public void inmultireTest(){
        int a = 4;
        int b = 6;
        int result = calc.inmultire(a,b);
        assert result == 24;
    }
    @Test
    public void impartireTest() {
        int a = 6;
        int b = 2;
        double result = calc.impartire(a, b);
        assert result == 3;
    }
}
