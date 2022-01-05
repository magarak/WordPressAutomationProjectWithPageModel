package com.wordpress.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {
        LoginTest test = new LoginTest();
        test.testLoginWithValidUserName();
        test.testLoginWithInvalidUserName();
    }

    public void testLoginWithValidUserName() throws InterruptedException {
        //      Test1
        System.setProperty("webdriver.chrome.driver", "/Users/merveagarak/IdeaProjects/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://wordpress.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"lpc-header-nav\"]/div/div/div[1]/div/nav/ul[2]/li[1]/a"));
        loginLink.click();

        WebElement userName = driver.findElement(By.id("usernameOrEmail"));
        userName.clear();
        userName.sendKeys("testagarak");

        WebElement continueBtn = driver.findElement(By.xpath("//button[text()='Continue']"));
        continueBtn.click();

        Thread.sleep(3000);
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("agaraktest12345");

        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Log In']"));
        loginBtn.click();

        WebElement profileIcon = driver.findElement(By.xpath("//*[@id=\"header\"]/a[3]/span/img"));
        boolean isProfileIconExists = profileIcon.isDisplayed();

        if (isProfileIconExists) {
            System.out.println("Test is successful");
        } else {
            System.out.println("Test is failed");
        }

        driver.close();
    }

    public void testLoginWithInvalidUserName() {
        //      Test2
        System.setProperty("webdriver.chrome.driver", "/Users/merveagarak/IdeaProjects/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://wordpress.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"lpc-header-nav\"]/div/div/div[1]/div/nav/ul[2]/li[1]/a"));
        loginLink.click();

        WebElement userName = driver.findElement(By.id("usernameOrEmail"));
        userName.clear();
        userName.sendKeys("sdfaarsgase");

        WebElement continueBtn = driver.findElement(By.xpath("//button[text()='Continue']"));
        continueBtn.click();

        WebElement errorMsgElement = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[1]/div[1]/span"));
        String errorMessage = errorMsgElement.getText();
        if (errorMessage.contains("User does not exist.")) {
            System.out.println("Test is successful");
        } else {
            System.out.println("Test is failed.");
        }
        driver.close();
    }
}
