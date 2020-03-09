package applicationshelper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.YandexMraket;

import java.util.concurrent.TimeUnit;

public abstract class LauncherDriver {
    private static final Logger logger = LogManager.getLogger(LauncherDriver.class);
    protected WebDriver driver;

    @BeforeTest
    public static void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        logger.info("setupBrowser = chromedriver");
    }

    @BeforeTest
    public void viewBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
