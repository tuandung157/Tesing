import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class TestImplementFunctionLevel3 {
    //test cos
    double eps = 1E-6;

    static ArrayList<Double> testTrigoGenerated(){
        double step = 0.1;
        double start = -3.14;
        double end = 3.14;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            start =Math.round(start* 100000d) / 100000d;
            res.add(start);
            start += step;
        }
        return  res;
    }


    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testValueCos(double x){
        Assertions.assertEquals(Math.cos(x), FuncTaylor.cos(x), eps,
                "Wrong value. Тест: cos(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testPeriodCos(double x){
        Assertions.assertEquals(FuncTaylor.cos(x+2*Math.PI), FuncTaylor.cos(x), eps,
                "Wrong value. Тест: period cos(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testValueSec(double x){
        Assertions.assertEquals(1/Math.cos(x), FuncTaylor.sec(x), eps,
                "Wrong value. Тест: sec(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testPeriodSec(double x){
        Assertions.assertEquals(FuncTaylor.sec(x+2*Math.PI), FuncTaylor.sec(x), eps,
                "Wrong value. Тест: period sec(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testValueCsc(double x){
        Assertions.assertEquals(1/Math.sin(x), FuncTaylor.csc(x), eps,
                "Wrong value. Тест: csc(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testPeriodCsc(double x){
        Assertions.assertEquals(FuncTaylor.csc(x+2*Math.PI), FuncTaylor.csc(x), eps,
                "Wrong value. Тест: period csc(" + x +")");
    }

    static ArrayList<Double> testLogarGenerated(){
        double step = 0.1;
        double start = step;
        double end = 5;
        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            start =Math.round(start* 100000d) / 100000d;
            res.add(start);
            start += step;
        }

        step = 2;
        start = 5 + step;
        end = 100;
        while (start <= end){
            start =Math.round(start* 100000d) / 100000d;
            res.add(start);
            start += step;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testLogarGenerated")
    void testValueLog3(double x){
        Assertions.assertEquals(Math.log(x)/Math.log(3), FuncTaylor.log_3(x), eps,
                "Wrong value. Тест: csc(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testLogarGenerated")
    void testValueLog5(double x){
        Assertions.assertEquals(Math.log(x)/Math.log(5), FuncTaylor.log_5(x), eps,
                "Wrong value. Тест: csc(" + x +")");
    }


//    @Test
//    public void test(){
//        FuncTaylor test = Mockito.mock(FuncTaylor.class);
//
//        when(test.tan(0)).thenReturn(0.0);
//
//        Assertions.assertEquals(test.tan(0),0.0);
//    }
}
