import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;

public class TestFunctionLevel1 {
    static double steps =0.1;
    double eps =1E-4;


    double mathTrigo(double x){
        return -Math.sin(x) + Math.cos(x)/Math.sin(x) + 2;
    }
    double mathLoga(double x){
        return (Math.pow(Math.log(x),3)*Math.pow((2*Math.log(x)/Math.log(5)) + Math.log(x) ,6))/Math.pow(Math.log(5),3);
    }

    double mainFunction(double x){
        if(x <=0) return mathTrigo(x);
        else return mathLoga(x);
    }
    // for function main
    static ArrayList<Double> testFunctionSystem(){
        double start = -10;
        double end = 10;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            start =Math.round(start* 100000d) / 100000d;
            res.add(start);
            start += steps;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testFunctionSystem")
    void testFunction(double x){
        Assertions.assertEquals(mainFunction(x), FuncTaylor.functionSystem(x), eps,
                "Wrong value. Тест: first part for mainFunction(" + x +")");
    }



}
