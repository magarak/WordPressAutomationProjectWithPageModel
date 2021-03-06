package com.wordpress.utils;

import com.wordpress.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory implements Constants {

    public static WebDriver driver;
    public String browser = "";

    private final ReadProperties configProperties = new ReadProperties("config/config.properties");

    public void initializeDriver() {

        browser = configProperties.getPropertyValue(key_browser);
        String url = configProperties.getPropertyValue(key_url);

        if (driver == null) {
            if (browser.equalsIgnoreCase(browser_firefox)) {
                String geckoDriverPath = configProperties.getPropertyValue(key_gecko_driver_path);
                System.setProperty(webdriver_gecko_driver, geckoDriverPath);
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase(browser_chrome)) {
                String chromeDriverPath = configProperties.getPropertyValue(key_chrome_driver_path);
                System.setProperty(webdriver_chrome_driver, chromeDriverPath);
                driver = new ChromeDriver();
            } else {
                String chromeDriverPath = configProperties.getPropertyValue(key_chrome_driver_path);
                System.setProperty(webdriver_chrome_driver, chromeDriverPath);
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

}
