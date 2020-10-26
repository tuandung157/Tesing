import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;

public class TestFunctionTrigoLevel2 {

    static double steps =0.01;
    double eps =1E-6;

    double mathTrigo(double x){
        return -Math.sin(x) + Math.cos(x)/Math.sin(x) + 2;
    }
    double mathLoga(double x){
        return (Math.pow(Math.log(x),3)*Math.pow((2*Math.log(x)/Math.log(5)) + Math.log(x) ,6))/Math.pow(Math.log(5),3);
    }
    // for function trigo
    static ArrayList<Double> testFirstPartGenerated(){
        double start = -6.4;
        double end = -3.4;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            start =Math.round(start* 100000d) / 100000d;
            res.add(start);
            start += steps;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testFirstPartGenerated")
    void testFirstPart(double x){
        Assertions.assertEquals(mathTrigo(x), FuncTaylor.funTrigo(x), eps,
                "Wrong value. Тест: first part for TrigoFunc(" + x +")");
    }

    static ArrayList<Double> testSecondPartGenerated(){
        double start = -3.4;
        double end = -0.1;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            start =Math.round(start* 100000d) / 100000d;
            res.add(start);
            start += steps;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testSecondPartGenerated")
    void testSecondPart(double x){
        Assertions.assertEquals(mathTrigo(x), FuncTaylor.funTrigo(x), eps,
                "Wrong value. Тест: second part for TrigoFunc(" + x +")");
    }

    @Test
    void InfinityValue(){
        Assertions.assertEquals(Double.NaN, FuncTaylor.funTrigo(0),"should be limited");
    }

    //for function Loga

}
