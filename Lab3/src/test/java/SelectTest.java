// Generated by Selenium IDE
import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import java.util.*;

public class SelectTest {
  private static WebDriver driver;

  @BeforeEach
  public void setUp() {
    driver = WebDriverInit.init("chrome");

  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  public void selectProduct(String str) throws InterruptedException {
    String product = str;
    System.out.println(product);
    driver.get(product);
    //click button add product
    WebElement addButton = driver.findElement(By.xpath("//span[text()='Добавить в корзину']"));
    addButton.click();
    Thread.sleep(3000);
    WebDriverWait wait = new WebDriverWait(driver, 20);
    //click button go to cart
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[13]/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/a/button")));
    WebElement goToCart = driver.findElement(By.xpath("/html/body/div[1]/div/div[13]/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/a/button"));
    goToCart.click();
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/my/cart\"]")));
    driver.navigate().refresh();
  }
  @Test
  public void selectTestSingleRandom() throws InterruptedException {
    String product = pickRandomProduct();
    System.out.println(product);
    driver.get(product);
    WebElement addButton = driver.findElement(By.xpath("//span[text()='Добавить в корзину']"));
    addButton.click();
    Thread.sleep(1000);
    //click to button cart
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[13]/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/a/button")));
    WebElement goToCart = driver.findElement(By.xpath("/html/body/div[1]/div/div[13]/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/a/button"));
    goToCart.click();
    Thread.sleep(1000);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/my/cart\"]")));
    driver.navigate().refresh();

//    driver.navigate().to("https://pokupki.market.yandex.ru/my/checkout");
  }


  @Test
  public void selectTestAlotProduct() throws InterruptedException {
    //choose product
    String product = pickRandomProduct();
    System.out.println(product);

    selectProduct(product);
    Thread.sleep(1000);
    WebElement inputAmount = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/input"));
    inputAmount.sendKeys(Keys.BACK_SPACE);
    Thread.sleep(1000);
    inputAmount.sendKeys("3");
    Thread.sleep(3000);
    driver.navigate().refresh();
    Thread.sleep(1000);
    //get amount
    WebElement checkamount = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div"));
    System.out.println(checkamount.getText());
    Assertions.assertEquals("В корзине 3 товара",checkamount.getText(),"need to 3 ");
  }

  @Test
  public void selectTestManyKindProduct() throws InterruptedException {
    //choose product
    String product1 = pickRandomProduct();
    String product2 = pickRandomProduct();
    while(product1.equals(product2)) {
      product2 = pickRandomProduct();
    }
    //select product
    selectProduct(product1);
    selectProduct(product2);
    //input number of product
    WebElement inputAMount = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/div/input"));
    inputAMount.sendKeys(Keys.BACK_SPACE);
    Thread.sleep(1000);
    inputAMount.sendKeys("3");
    Thread.sleep(3000);
    driver.navigate().refresh();
    Thread.sleep(1000);

    //check amount added
    WebElement checkamount = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div"));
    System.out.println(checkamount.getText());
    Assertions.assertEquals("В корзине 4 товара",checkamount.getText(),"need to 4 ");
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
    result = list.get(randomNumber);
    return result;
  }
}
