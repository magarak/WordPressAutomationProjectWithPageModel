package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName) {

        WebElement element = driver.findElement(By.id("usernameOrEmail"));
        element.clear();
        element.sendKeys(userName);
    }

    public void setPassword(String password) {

        WebElement element = driver.findElement(By.id("password"));
        element.clear();
        element.sendKeys(password);
    }

    public void clickOnContinueButton() {

        WebElement element = driver.findElement(By.xpath("//button[text()='Continue']"));
        element.click();
    }

    public void clickOnLoginButton() {

        WebElement element = driver.findElement(By.xpath("//button[text()='Log In']"));
        element.click();
    }


}
