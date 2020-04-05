package ru.otus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class CheckUrl1 {
    private WebDriver driver;
    private BaseTest baseTest;

    @BeforeMethod
    void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setVersion("78.0");
        desiredCapabilities.setCapability("enableVNC",true);
        desiredCapabilities.setCapability("enableVideo",false);
        driver = new RemoteWebDriver(
                new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities
        );
        baseTest = new BaseTest(driver);
        driver.get("https://habr.com/ru/flows/develop/");
    }

    @Test
    void test(){
        baseTest
                .clickHubsLink()
                .checkUrl()
                ;

    }


    @AfterMethod
    void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
