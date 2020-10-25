import java.io.FileWriter;
import java.io.IOException;

public class fileWritter {
    private FileWriter fw;
    public void print(double start, double end,double step){
        try {
            fw = new FileWriter("csvResule");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
