public class funcTaylor {

    public double preProcess(double x){
        x = x% (Math.PI*2);
        return x;
    }
    public double cos(double rad){
        //preProcess(rad);
        double cos = 1;
        double eps = 1.0E-8;
        double INF = 1.0E8;
        int i = 0;
        double sign = 1,fact =1, pow =1,element = 1;

        while(Math.abs(element) > eps){
            i++;
            sign = sign * -1;
            fact = fact * (2 * i -1) * (2*i);
            pow = pow * rad * rad;
            element =  pow / fact;
            cos = cos + sign *element;
        }
//        cos = Math.round(cos * 100000000d) / 100000000d;
        System.out.println("cos " + cos);
        return cos;
    }

    public double sin(double rad){
        //preProcess(rad);
        double sin = 0;
        double cos = this.cos(rad);
        sin = Math.sqrt( 1 - cos*cos);
//        sin = Math.round(sin * 100000000d) / 100000000d;
        System.out.println("sin " + sin);
        return sin;
    }

    public double tan(double rad){

        return sin(rad)/cos(rad);
    }
    public double cot(double rad){
        return cos(rad)/sin(rad);
    }

    public double sec(double rad){
        return 1/cos(rad);
    }
    public double csc(double rad){
        return 1/sin(rad);
    }
    public static double pow(double x, int n){
        double res = x;
        int loop = Math.abs(n);
        for (int i=2; i<=loop; i++) res *= x;
        if (n == 0) return 1;
        if (n < 0) return 1/res;
        return res;
    }
    public double ln(double x){
        double thisEps = 1E-10;
        double before, after, xn, base;
        int n;

        n = 2;
        xn = (x-1)/(x+1);
        base = xn*xn;
        after = xn;

        do {
            before = after;
            xn *= base;
            after += xn/(2*n-1);
            n++;
        } while (Math.abs(Math.abs(after) - Math.abs(before)) > thisEps);
        return 2*after;
    }

    public double log_3(double x){
        return ln(x)/ln(3);
    }

    public double log_5(double x){
        return ln(x)/ln(5);
    }
}
