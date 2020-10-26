public class main {
    public static void main(String[] args) {
        System.out.println("start");
        //create file csv
        CsvWritter writter = new CsvWritter("result.csv", -10.0 ,10.0, 0.01);
    }
}
