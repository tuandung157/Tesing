public class FuncSec {


    public double calc(double xRadian){
        double sec = 1;
        double eps = 1.0e-8;
        double INF = 1.0e8;
        int i = 0;
        double sign = 1,fact =1, pow =1,element = 1;

        while(element > eps){
            i++;
            sign = sign * -1;
            fact = fact * (2 * i -1) * (2*i);
            pow = pow * xRadian * xRadian;
            element =  pow / fact;
            //System.out.println("element = "+element);
            sec = sec + sign *element;
        }
        sec = 1/sec;
        System.out.println(sec);
        return sec;
    }
}
