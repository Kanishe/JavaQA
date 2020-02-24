import factory.WebDriverFactory;
import factory.WebDriverName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class MainTestFactory {

        private static final Logger log = LogManager.getLogger(MainTestFactory.class);
        private static WebDriver driver;
        private static String browser = System.getProperty("browser", "cHrOmE").toUpperCase();

        @BeforeClass
        public static void setup() {
            driver = WebDriverFactory.createDefault(WebDriverName.valueOf(browser));
            log.info("Setup driver");
        }

        @Test
        public void test() {
            log.info("Run test");
            String url = "https://habr.com/ru/post/489456/";
            log.info("Open Habr");
            driver.get(url);
            Assert.assertEquals(driver.getTitle(), "Рекомендации после приёма хирурга-стоматолога" + " / Хабр");
            log.info("Test passed");
        }

        @AfterClass
        public static void tearDown() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }


