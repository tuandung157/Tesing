import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

class TestBasicfuncTaylorLevel4 {

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
     void testValueSin(double x){
         Assertions.assertEquals(Math.sin(x), FuncTaylor.sin(x), eps,
                 "Wrong value. Тест: sin(" + x +")");
     }

     @ParameterizedTest
     @MethodSource("testTrigoGenerated")
     void testPeriodSin(double x){
         Assertions.assertEquals(FuncTaylor.sin(x+2*Math.PI), FuncTaylor.sin(x), eps,
                 "Wrong value. Тест: period sin(" + x +")");
     }
    static ArrayList<Double> testLogaGenerated(){
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
    @MethodSource("testLogaGenerated")
    void testValueLn(double x){
        Assertions.assertEquals(Math.log(x), FuncTaylor.ln(x), eps,
                "Wrong value. Тест: csc(" + x +")");
    }

}
