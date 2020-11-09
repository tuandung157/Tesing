import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
    private static WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver = WebDriverInit.init();
    }
    @Test
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

    @Test
    public void changeProfile(){
        login();
        //navigative to profile
        driver.navigate().to("https://passport.yandex.ru/profile/public");

        WebElement userName = driver.findElement(By.xpath("//*[@id=\"display_name\"]"));
        String curName = userName.getAttribute("value");
        String nameChange = "";

        //2 option for the name
        if(curName.equals("le"))  nameChange = "anh";
        else nameChange = "le";
        //clear name
        for(int i =0; i< 5; i++) {
            userName.sendKeys(Keys.BACK_SPACE);
        }
        System.out.println("name change "+nameChange);
        //input new name
        userName.sendKeys(nameChange);
        //save new name
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button"));
        saveButton.click();
    }
}
