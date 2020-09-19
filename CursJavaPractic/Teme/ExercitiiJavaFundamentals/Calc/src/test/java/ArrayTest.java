import org.junit.Test;

import static junit.framework.TestCase.*;

public class ArrayTest {

    int[] array ={56,7,9,3,2,51,4};
    Array arrayA = new Array();
    @Test
    public void lungimeArrayTest(){
        int result = arrayA.lungimeArray(array);
        assert result == 7;
    }
    @Test
    public void numereMaiMariTest(){
        int result = arrayA.numereMaiMari(array);
        assertEquals (result,4);
    }
}
