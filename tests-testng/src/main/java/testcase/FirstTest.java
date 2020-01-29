package testcase;

import configuration.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class FirstTest extends BaseTest {
  private static final Logger logger = LogManager.getLogger(FirstTest.class);

  @Test
  public void goToMainPage(String[] args) {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    driver = new ChromeDriver(options);
    logger.info("Поехали!");
    driver.get("https://otus.ru/");
    logger.info("Приехали");
    driver.quit();
    logger.info("Стоп машина");
  }
}
