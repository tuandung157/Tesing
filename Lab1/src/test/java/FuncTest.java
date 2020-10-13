import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FuncTest {
    FuncSec sec = new FuncSec();
    final double EPS = 1.0e-8, INF = 10e8;

    private boolean EPS_Equals(double a, double b){
        return Math.abs(b - a) <= EPS;
    }

    @Test
    void testResult(){
        assertEquals(1/Math.cos(0),sec.calc(0),"test with param 0");

        assertTrue(EPS_Equals(1/Math.cos(Math.PI),sec.calc(Math.PI)),"test with param PI");
        assertTrue(EPS_Equals(1/Math.cos(-Math.PI),sec.calc(-Math.PI)),"test with param -PI");

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
    void testLimitException(){
        assertTrue(Math.abs(sec.calc(Math.PI/2)) >= INF,"test with param PI/2");
        assertTrue(Math.abs(sec.calc(3*Math.PI/2)) >= INF,"test with param 3*PI/2");
        assertTrue(Math.abs(sec.calc(5*Math.PI/2)) >= INF, "test with param 5PI/2");
    }

}
