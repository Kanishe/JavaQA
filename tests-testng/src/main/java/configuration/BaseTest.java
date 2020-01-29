package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
  public WebDriver driver;
  @BeforeTest
  public static void setUpClass() {
    WebDriverManager.chromedriver().setup();
    WebDriverManager.firefoxdriver().setup();
  }
  @AfterTest
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
