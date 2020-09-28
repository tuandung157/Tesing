import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FuncTest {
    FuncSec sec = new FuncSec();
    final double EPS = 1.0e-8, INF = 1.0e8;

    private boolean EPS_Equals(double a, double b){
        System.out.println("a " + a);
        System.out.println("b " + b);
        return Math.abs(b - a) < EPS;
    }

    @Test
    void testResult(){
        assertEquals(1/Math.cos(0),sec.calc(0),"test with param PI/2");
        assertEquals(1/Math.cos(Math.PI), sec.calc(Math.PI), "test with param PI");
        assertEquals(1/Math.cos(-Math.PI), sec.calc(-Math.PI), "test with param -PI");

        assertTrue(EPS_Equals(1/Math.cos(Math.PI/3),sec.calc(Math.PI/3)),"test with param PI/3");
        assertTrue(EPS_Equals(1/Math.cos(-Math.PI/3),sec.calc(-Math.PI/3)),"test with param -PI/3");
        assertTrue(EPS_Equals(1/Math.cos(Math.PI/4),sec.calc(Math.PI/4)),"test with param PI/4");
        assertTrue(EPS_Equals(1/Math.cos(-Math.PI/4),sec.calc(-Math.PI/4)),"test with param -PI/4");
        assertTrue(EPS_Equals(1/Math.cos(Math.PI/5),sec.calc(Math.PI/5)),"test with param PI/5");
        assertTrue(EPS_Equals(1/Math.cos(-Math.PI/5),sec.calc(-Math.PI/5)),"test with param -PI/5");
        assertTrue(EPS_Equals(1/Math.cos(Math.PI/6),sec.calc(Math.PI/6)),"test with param PI/6");
        assertTrue(EPS_Equals(1/Math.cos(-Math.PI/6),sec.calc(-Math.PI/6)),"test with param -PI/6");
        assertTrue(EPS_Equals(1/Math.cos(Math.PI/8),sec.calc(Math.PI/8)),"test with param PI/8");
        assertTrue(EPS_Equals(1/Math.cos(-Math.PI/8),sec.calc(-Math.PI/8)),"test with param -PI/8");
        assertTrue(EPS_Equals(1/Math.cos(Math.PI/12),sec.calc(Math.PI/12)),"test with param PI/12");
        assertTrue(EPS_Equals(1/Math.cos(-Math.PI/12),sec.calc(-Math.PI/12)),"test with param -PI/12");

    }

    @Test
    void testLimit(){
        assertTrue(EPS_Equals(INF,sec.calc(Math.PI/2)),"test with param PI/2");
    }



}
