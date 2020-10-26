import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;

public class TestFunctionLogaLevel2 {

    static double stepStatic =0.01;
    double eps =1E-6;


    double mathTrigo(double x){
        return -Math.sin(x) + Math.cos(x)/Math.sin(x) + 2;
    }

    double mathLoga(double x){
        return (Math.pow(Math.log(x),3)*Math.pow((2*Math.log(x)/Math.log(5)) + Math.log(x) ,6))/Math.pow(Math.log(5),3);
    }

    static ArrayList<Double> testFirstPartGenerated(){
        double start = 0.2;
        double end = 0.6;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            start =Math.round(start* 100000d) / 100000d;
            res.add(start);
            start += stepStatic;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testFirstPartGenerated")
    void testFirstPart(double x){
        Assertions.assertEquals(mathLoga(x), FuncTaylor.funcLoga(x), eps,
                "Wrong value. Тест: first part for funcLoga(" + x +")");
    }

    static ArrayList<Double> testSecondPartGenerated(){
        double start = 0.6;
        double end = 2;
        double step = 0.001;
        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            start =Math.round(start* 100000d) / 100000d;
            res.add(start);
            start += step;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testThirdPartGenerated")
    void testSecondPart(double x){
        Assertions.assertEquals(mathLoga(x), FuncTaylor.funcLoga(x), eps,
                "Wrong value. Тест: third part for funcLoga(" + x +")");
    }

    static ArrayList<Double> testThirdPartGenerated(){
        double start = 2;
        double end = 3;
        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            start =Math.round(start* 100000d) / 100000d;
            res.add(start);
            start += stepStatic;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testThirdPartGenerated")
    void testThirdPart(double x){
        Assertions.assertEquals(mathLoga(x), FuncTaylor.funcLoga(x), eps,
                "Wrong value. Тест: third part for funcLoga(" + x +")");
    }

    static ArrayList<Double> testLimitLeft(){
        double start = 0;
        double end = 1.9;
        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            start =Math.round(start* 100000d) / 100000d;
            res.add(start);
            start += stepStatic;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testThirdPartGenerated")
    void testLimitLeft(double x){
        Assertions.assertEquals(mathLoga(x), FuncTaylor.funcLoga(x), eps,
                "Wrong value. Тест: limit left part for funcLoga(" + x +")");
    }
}
