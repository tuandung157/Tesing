public class FuncTaylor {

    public static double mainFunction(double x){
        if(x == 0) return Double.POSITIVE_INFINITY;
        double res = 0;
        if(x <= 0) res = funTrigo(x);
        else res = funcLoga(x);
        System.out.println("result " +res);
        return res;
    }
    public static double funTrigo(double x){

        return (((((cot(x)/csc(x))/cos(x))-csc(x)) + cot(x)) + (((pow(sec(x)*cos(x),2))) + (csc(x)-sin(x))));
    }
    public static double funcLoga(double x){
        return pow((pow(log_5(x)+log_5(x) + ln(x),2) * ((log_5(x) - log_3(x)) +log_3(x))),3);
    }
    public static double preProcess(double x){
        x = x% (Math.PI*2);
        return x;
    }
    public static double sin(double x){
        x = preProcess(x);

        double thisEps = 1E-10;
        double before, after, xn;
        int n;
        after = x;
        n = 1;
        xn = x;

        do {
            before = after;
            xn *= (-1)*x*x/2/n/(2*n+1);
            after += xn;
            n++;
        } while (Math.abs(Math.abs(after) - Math.abs(before)) > thisEps);
        return after;
    }

    public static double cos(double x){
        return sin(x+Math.PI/2);
    }

    public double tan(double rad){

        return sin(rad)/cos(rad);
    }
    public static double cot(double rad){
        return cos(rad)/sin(rad);
    }

    public static double sec(double rad){
        return 1/cos(rad);
    }
    public static double csc(double rad){
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
    public static double ln(double x){
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

    public static double log_3(double x){
        return ln(x)/ln(3);
    }

    public static double log_5(double x){
        return ln(x)/ln(5);
    }
}
