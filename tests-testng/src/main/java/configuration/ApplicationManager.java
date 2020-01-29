//package configuration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.BrowserType;
//import org.testng.Assert;
//
//public class ApplicationManager {
//
//  public String browser;
//  public WebDriver driver;
//  public StringBuffer verificationErrors = new StringBuffer();
//
//
//  public ApplicationManager(String browser) { //todo конструктор для выбора используемого браузера
//    this.browser=browser;
//
//  }
//  public void init() {
//
//
//    if (browser.equals(BrowserType.CHROME)){
//      System.setProperty("webdriver.chrome.driver","/Users/alexandrkanishevskii/IdeaProjects/JavaQA/tests-testng/src/main/resources/chromedriver");
//      driver = new ChromeDriver();
//
//    } else {
//      System.setProperty("webdriver.gecko.driver","/Users/alexandrkanishevskii/IdeaProjects/JavaQA/tests-testng/src/main/resources/geckodriver");
//      driver= new FirefoxDriver();
//
//    }
//
//  }
//
//
//  public void quit() {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      Assert.fail(verificationErrorString);
//    }
//  }
//}