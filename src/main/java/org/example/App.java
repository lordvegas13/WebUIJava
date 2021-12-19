package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App //авторизация на сайте
{
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

        driver.quit();

    }

}
