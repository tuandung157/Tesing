import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest {
    private static WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver = WebDriverInit.init();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @RepeatedTest(10)
    public void searchBar(){
        String findString = "nutella";

        driver.get("https://market.yandex.ru/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //fill search bar
        //*[@id="header-search"]
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"header-search\"]"));
        searchInput.sendKeys(findString);

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/noindex/div/div/div[2]/div[2]/div/form/div/div[2]/button"));
        searchButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header-search\"]")));
        WebElement searchRes = driver.findElement(By.xpath("//*[@id=\"header-search\"]"));
//        System.out.println("check "+searchRes.getText());

        //check search tag
        String curUrl = driver.getCurrentUrl();
        int a = curUrl.indexOf("?text="+findString);
        Assertions.assertTrue(a>0,"cant not find");
    }
}
