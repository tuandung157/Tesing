import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInit {
    public static WebDriver init(String driverName){
        WebDriver driver;
        if(driverName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\Projects\\Tesing\\Lab3\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().setSize(new Dimension(1920, 1080));

        }else{
            System.setProperty("webdriver.chrome.driver", "D:\\Projects\\Tesing\\Lab3\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1920, 1080));
        }
        return driver;
    }
}
