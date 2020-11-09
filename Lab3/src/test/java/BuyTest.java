import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuyTest {
    private WebDriver driver;
    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = WebDriverInit.init("chrome");
        login();
        String product =  pickRandomProduct();
        selectProduct(product);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testBuy() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div/span/button")));
        WebElement goToBuy = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div/span/button"));
        goToBuy.click();
        Thread.sleep(5000);

        //nevigate link
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div/div/div/div[2]/div/div[3]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div/button")));
        //WebElement payOnline = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div/div/div/div[2]/div/div[3]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div/button"));
        //click to button pay
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Перейти к оплате')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Перейти к оплате')]")).click();//span[text()='Перейти к оплате']"
        //payOnline.click();

    }
    public void selectProduct(String str) throws InterruptedException {
        String product = str;
        System.out.println(product);
        driver.get(product);
        Thread.sleep(3000);
        WebElement addButton = driver.findElement(By.xpath("//span[text()='Добавить в корзину']"));
        addButton.click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[13]/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/a/button")));
        WebElement goToCart = driver.findElement(By.xpath("/html/body/div[1]/div/div[13]/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/a/button"));
        goToCart.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/my/cart\"]")));
        driver.navigate().refresh();
    }
    public String pickRandomProduct(){
        String result = null;
        String nutella = "https://pokupki.market.yandex.ru/product/nutella-pasta-orekhovaia-s-dobavleniem-kakao-180-g/100405030765?offerid=AIL_CKI-wcmfxIpO_chXBA&show-uid=16048486395241564492116000";
        String milkyWay = "https://pokupki.market.yandex.ru/product/milky-way-shokoladnaia-pasta-200-g/100456829224?show-uid=16048495865248353553606010&offerid=7vD28iJEK4Oyo1aIX5b-rg";
        String mandm = "https://pokupki.market.yandex.ru/product/drazhe-m-m-s-peanut-v-shokoladnoi-glazuri-s-arakhisom-130-g/100441660942?show-uid=16048497162719313977106010&offerid=Qmf5Q276pPtKl3UhXjA9rg";
        String haribo = "https://pokupki.market.yandex.ru/product/marmelad-haribo-fruti-buzzi-assorti-100-g/144306031?show-uid=16048497368621435060506001&offerid=WhARBziDPU12ZoV-slzG1g";
        String snickers = "https://pokupki.market.yandex.ru/product/konfety-snickers-minis-180-g/100409204143?show-uid=16048498855697925966306009&offerid=zra7rS8t0Gn1XE_HTQ2TqQ";
        List<String> list = new ArrayList<>();
        list.add(nutella);
        list.add(milkyWay);
        list.add(mandm);
        list.add(haribo);
        list.add(snickers);
        //random product
        int randomNumber = new Random().nextInt(5);
        System.out.println(randomNumber);
        result = list.get(4);
        return result;
    }
    public void login(){
        driver.get("https://market.yandex.ru/");
        String winHandleBefore = driver.getWindowHandle();
        //find login button
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/noindex/div/div/div[2]/div[3]/div[1]/div[5]/div/div/a"));
        loginButton.click();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        ////*[@id="passp-field-login"]
        System.out.println(driver.getCurrentUrl());
        WebElement inputLogin = driver.findElement(By.xpath("//*[@id=\"passp-field-login\"]"));
        inputLogin.sendKeys("p3400testtpo");

        ////*[@id="root"]/div/div/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div[3]/button
        WebElement enterLogin = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div[3]/button"));
        enterLogin.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passp-field-passwd\"]")));
        ////*[@id="passp-field-passwd"]
        WebElement inputPass = driver.findElement(By.xpath("//*[@id=\"passp-field-passwd\"]"));
        inputPass.sendKeys("1571997");

        ////*[@id="root"]/div/div/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/button
        //click login
        WebElement login = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/button"));
        login.click();
        driver.switchTo().window(winHandleBefore);
        System.out.println(driver.getCurrentUrl());

        //wait load login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/noindex/div/div/div[2]/div[3]/div[1]/div[5]/div/div/div/div/button/div/img")));

        //click avatar
        WebElement avatar = driver.findElement(By.xpath("/html/body/div[2]/div[3]/noindex/div/div/div[2]/div[3]/div[1]/div[5]/div/div/div/div/button/div/img"));
        avatar.click();
        WebElement checkUser = driver.findElement(By.xpath("/html/body/div[2]/div[3]/noindex/div/div/div[2]/div[3]/div[1]/div[5]/div/div/div/div/div/div/div/div/div[1]/a[1]/div/div[2]/div[2]"));
        System.out.println(checkUser.getText());
        Assertions.assertEquals("p3400testtpo@yandex.ru",checkUser.getText(),"need to the same user");
    }
}
