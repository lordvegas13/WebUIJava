import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class NewAppTestHW5 {
    static WebDriver webDriver;


    @BeforeEach
    void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(40));

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Assertions.assertDoesNotThrow(() -> webDriver.navigate().to("https://www.saucedemo.com"), "Страница не доступна");
    }


    @DisplayName("#1 Авторизация на сайте")
    @Test
    void testAuthor(){
        WebElement webElementLogin = webDriver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement webElementPassword = webDriver.findElement(By.xpath("//input[@id='password']"));
        WebElement webElementEnter = webDriver.findElement(By.xpath("//input[@id='login-button']"));

        webElementLogin.click();
        webElementLogin.sendKeys("standard_user");
        webElementPassword.click();
        webElementPassword.sendKeys("secret_sauce");
        webElementEnter.click();

        Actions actions = new Actions(webDriver);

        actions.moveToElement(webDriver.findElement(By.xpath("//div[@id='shopping_cart_container']")))
                .build().perform();

        WebElement logout1 = webDriver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        logout1.click();
        WebElement logout2 = webDriver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logout2.click();

        Assertions.assertEquals(webDriver.getCurrentUrl(),"https://www.saucedemo.com/");
        webDriver.manage().deleteAllCookies();
    }

    @DisplayName("#2 оформление заказа")
    @Test
    void testOrder(){

        WebElement webElementLogin = webDriver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement webElementPassword = webDriver.findElement(By.xpath("//input[@id='password']"));
        WebElement webElementEnter = webDriver.findElement(By.xpath("//input[@id='login-button']"));

        webElementLogin.click();
        webElementLogin.sendKeys("standard_user");
        webElementPassword.click();
        webElementPassword.sendKeys("secret_sauce");
        webElementEnter.click();

        WebElement webElementAnd = webDriver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        webElementAnd.click();

        WebElement webElementAnd2 = webDriver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        webElementAnd2.click();

        WebElement webElementBasket = webDriver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        webElementBasket.click();

        WebElement webElementCheckout = webDriver.findElement(By.xpath("//button[@id='checkout']"));
        webElementCheckout.click();

        WebElement webElementFirstname = webDriver.findElement(By.xpath("//input[@id='first-name']"));
        webElementFirstname.click();
        webElementFirstname.sendKeys("Початок");

        WebElement webElementLastname = webDriver.findElement(By.xpath("//input[@id='last-name']"));
        webElementLastname.click();
        webElementLastname.sendKeys("Кукурузы");

        WebElement webElementZip = webDriver.findElement(By.xpath("//input[@id='postal-code']"));
        webElementZip.click();
        webElementZip.sendKeys("8642-8642");

        WebElement webElementContinue = webDriver.findElement(By.xpath("//input[@id='continue']"));
        webElementContinue.click();

        JavascriptExecutor jse = (JavascriptExecutor)webDriver; jse.executeScript("window.scrollBy(0,250)");

        WebElement webElementFinish = webDriver.findElement(By.xpath("//button[@id='finish']"));
        webElementFinish.click();

        WebElement webElementBack = webDriver.findElement(By.xpath("//button[@id='back-to-products']"));
        webElementBack.click();

        Actions actions = new Actions(webDriver);

        actions.moveToElement(webDriver.findElement(By.xpath("//div[@id='shopping_cart_container']")))
                .build().perform();

        WebElement logout1 = webDriver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        logout1.click();
        WebElement logout2 = webDriver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logout2.click();

        Assertions.assertEquals(webDriver.getCurrentUrl(),"https://www.saucedemo.com/");
        webDriver.manage().deleteAllCookies();
    }

    @DisplayName("#3 Сортировка")
    @Test
    void  testSorting(){

        WebElement webElementLogin = webDriver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement webElementPassword = webDriver.findElement(By.xpath("//input[@id='password']"));
        WebElement webElementEnter = webDriver.findElement(By.xpath("//input[@id='login-button']"));

        webElementLogin.click();
        webElementLogin.sendKeys("standard_user");
        webElementPassword.click();
        webElementPassword.sendKeys("secret_sauce");
        webElementEnter.click();

        Actions actions = new Actions(webDriver);

        actions.moveToElement(webDriver.findElement(By.xpath("//select[@class='product_sort_container']"))).build().perform();

        WebElement sorting = webDriver.findElement(By.xpath("//select[@class='product_sort_container']"));
        sorting.click();

        WebElement sorting1 = webDriver.findElement(By.xpath("//select[@class='product_sort_container']//option[4]"));
        sorting1.click();

        Assertions.assertEquals(webDriver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    @DisplayName("#4 Счетчик корзины")
    @Test
    void  testBasket(){

        WebElement webElementLogin = webDriver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement webElementPassword = webDriver.findElement(By.xpath("//input[@id='password']"));
        WebElement webElementEnter = webDriver.findElement(By.xpath("//input[@id='login-button']"));

        webElementLogin.click();
        webElementLogin.sendKeys("standard_user");
        webElementPassword.click();
        webElementPassword.sendKeys("secret_sauce");
        webElementEnter.click();

        WebElement webElementAnd = webDriver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        webElementAnd.click();

        Actions actions = new Actions(webDriver);

        actions.moveToElement(webDriver.findElement(By.xpath("//span[@class='shopping_cart_badge']")))
                .build().perform();

    }

    @AfterEach
    void exit2(){
        webDriver.close();
    }

    @AfterAll
    static void exit() {
        webDriver.quit();
    }
}
