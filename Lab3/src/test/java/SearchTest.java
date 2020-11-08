import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest {
    @BeforeEach
    private void initWebDriver(){

    }

    @Test
    public void searchBar(){
        String findString = "iphone";
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\Projects\\Tesing\\Lab3\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://market.yandex.ru/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //fill search bar
        //*[@id="header-search"]
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"header-search\"]"));
        searchInput.sendKeys(findString);

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/noindex/div/div/div[2]/div[2]/div/form/div/div[2]/button"));
        searchButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header-search\"]")));
        WebElement searchRes = driver.findElement(By.xpath("//*[@id=\"header-search\"]"));
//        System.out.println("check "+searchRes.getText());

        //check search tag in url
        String curUrl = driver.getCurrentUrl();
        int a = curUrl.indexOf("?text="+findString);
        Assertions.assertTrue(a>0,"cant not find");
    }
}
