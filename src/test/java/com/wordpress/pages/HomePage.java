package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public void clickOnLoginPage(){
       WebElement element = driver.findElement(By.xpath("//button[text()='Log In']"));
       element.click();
    }


}
