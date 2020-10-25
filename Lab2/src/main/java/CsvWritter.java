import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvWritter {
    private File file;
    funcTaylor funcTaylor = new funcTaylor();
    StringBuilder sb = new StringBuilder();

    public CsvWritter(String fileName, double start, double end, double step){
        try (PrintWriter log = new PrintWriter(new File(fileName))) {
            sb.append("x"); sb.append(',');
            sb.append("Value"); sb.append(',');
            sb.append("sin(x)"); sb.append(',');
            sb.append("cos(x)"); sb.append(',');
            sb.append("sec(x)"); sb.append(',');
            sb.append("csc(x)"); sb.append(',');
            sb.append("ln(x)"); sb.append(',');
            sb.append("log_3(x)"); sb.append(',');
            sb.append("log_5(x)"); sb.append("\n");

            Double i = start;
            while (i < end) {
                this.write(i);
                i += step;
            }

            log.write(sb.toString());
            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void write(Double x) {
        System.out.println(x);
        if (x<=0){
            sb.append(x); sb.append(',');
            sb.append(funcTaylor.mainFunction(x)); sb.append(',');
            sb.append(funcTaylor.sin(x)); sb.append(',');
            sb.append(funcTaylor.cos(x)); sb.append(',');
            sb.append(funcTaylor.sec(x)); sb.append(',');
            sb.append(funcTaylor.csc(x)); sb.append(',');
            sb.append("Null"); sb.append(',');
            sb.append("Null"); sb.append(',');
            sb.append("Null"); sb.append("\n");
        } else {
            sb.append(x); sb.append(',');
            sb.append(funcTaylor.mainFunction(x)); sb.append(',');
            sb.append(funcTaylor.sin(x)); sb.append(',');
            sb.append(funcTaylor.cos(x)); sb.append(',');
            sb.append(funcTaylor.sec(x)); sb.append(',');
            sb.append(funcTaylor.csc(x)); sb.append(',');
            sb.append(funcTaylor.ln(x)); sb.append(',');
            sb.append(funcTaylor.log_3(x)); sb.append(',');
            sb.append(funcTaylor.log_5(x)); sb.append("\n");
        }

    }

}