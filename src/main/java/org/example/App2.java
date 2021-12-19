package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class App2 { // авторизация -> добавление товара в корзину -> оформление заказа

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://www.saucedemo.com");

        WebElement webElementLogin = driver.findElement(By.xpath("//input[@id='user-name']"));
        webElementLogin.click();
        webElementLogin.sendKeys("standard_user");

        WebElement webElementPassword = driver.findElement(By.xpath("//input[@id='password']"));
        webElementPassword.click();
        webElementPassword.sendKeys("secret_sauce");

        WebElement webElementEnter = driver.findElement(By.xpath("//input[@id='login-button']"));
        webElementEnter.click();

        WebElement webElementAnd = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        webElementAnd.click();

        WebElement webElementAnd2 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        webElementAnd2.click();

        WebElement webElementBasket = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        webElementBasket.click();

        WebElement webElementCheckout = driver.findElement(By.xpath("//button[@id='checkout']"));
        webElementCheckout.click();

        WebElement webElementFirstname = driver.findElement(By.xpath("//input[@id='first-name']"));
        webElementFirstname.click();
        webElementFirstname.sendKeys("Початок");

        WebElement webElementLastname = driver.findElement(By.xpath("//input[@id='last-name']"));
        webElementLastname.click();
        webElementLastname.sendKeys("Кукурузы");

        WebElement webElementZip = driver.findElement(By.xpath("//input[@id='postal-code']"));
        webElementZip.click();
        webElementZip.sendKeys("8642-8642");

        WebElement webElementContinue = driver.findElement(By.xpath("//input[@id='continue']"));
        webElementContinue.click();

        JavascriptExecutor jse = (JavascriptExecutor)driver; jse.executeScript("window.scrollBy(0,250)");

        WebElement webElementFinish = driver.findElement(By.xpath("//button[@id='finish']"));
        webElementFinish.click();

        WebElement webElementBack = driver.findElement(By.xpath("//button[@id='back-to-products']"));
        webElementBack.click();

        driver.quit();

    }
}
