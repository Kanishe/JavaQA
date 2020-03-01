package confeguration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LaunchManager {
    public WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LaunchManager.class);


    @BeforeMethod
    public void setupBrowser(){
        String browser = BrowserType.CHROME;
        if (browser == BrowserType.CHROME){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Selected Browser - Chrome");
        } else if(browser == BrowserType.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logger.info("Selected Browser - Firefox");
        }
    }
    @AfterMethod
    public void terDown(){
        if(driver != null){
            driver.quit();
        }
    }
}