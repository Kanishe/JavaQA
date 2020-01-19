import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import static org.testng.Assert.fail;

public class ApplicationManager {

  public String browser;
  public WebDriver driver;
  public StringBuffer verificationErrors = new StringBuffer();
  private static final Logger logger = LogManager.getLogger(FirstTest.class);

  public ApplicationManager(String browser) { //todo конструктор для выбора используемого браузера
    this.browser=browser;
    logger.info("Запуск");

  }

  public void init() {
    logger.info("Открываем баузер");

    if (browser.equals(BrowserType.CHROME)){
      System.setProperty("webdriver.chrome.driver","/Users/alexandrkanishevskii/IdeaProjects/JavaQA/tests-testng/src/main/resources/chromedriver");
      driver = new ChromeDriver();

    } else {
      System.setProperty("webdriver.gecko.driver","/Users/alexandrkanishevskii/IdeaProjects/JavaQA/tests-testng/src/main/resources/geckodriver");
      driver= new FirefoxDriver();

    }
    driver.get("https://otus.ru/");
  }


  public void quit() {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}