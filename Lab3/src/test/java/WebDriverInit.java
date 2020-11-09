import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInit {
    public static WebDriver init(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\Projects\\Tesing\\Lab3\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        return driver;
    }
}
