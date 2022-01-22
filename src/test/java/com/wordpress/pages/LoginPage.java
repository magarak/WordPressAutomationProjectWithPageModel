package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(how = How.ID, using = "usernameOrEmail")
    WebElement userNameElement;

    @FindBy(how=How.ID,using = "password")
    WebElement passwordElement;

    @FindBy(how = How.XPATH,using = "//button[text()='Continue']")
    WebElement continueBtnElement;

    @FindBy(how = How.XPATH,using = "//button[text()='Log In']")
    WebElement logInBtnElement;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,LoginPage.class);
    }

    public void setUserName(String userName) {

      //  WebElement element = driver.findElement(By.id("usernameOrEmail"));
        //  element.clear();
        //element.sendKeys(userName);
        //pagefactorymodelle yukarı elementleri tanımlayıp here methodda kullanmaca
        userNameElement.clear();
        userNameElement.sendKeys(userName);
    }

    public void setPassword(String password) {
        /*WebElement element = driver.findElement(By.id("password"));
        element.clear();
        element.sendKeys(password);*/
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickOnContinueButton() {
//        WebElement element = driver.findElement(By.xpath("//button[text()='Continue']"));
//        element.click();
        continueBtnElement.click();
    }

    public void clickOnLoginButton() {
//        WebElement element = driver.findElement(By.xpath("//button[text()='Log In']"));
//        element.click();
        logInBtnElement.click();
    }


}
