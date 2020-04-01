import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckUrl1 {
    private WebDriver driver;
    private BaseTest baseTest;

    @BeforeMethod
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
