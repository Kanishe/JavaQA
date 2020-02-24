package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Arrays;

public class WebDriverFactory {
    public static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
    private static WebDriver create(WebDriverName webDriverName, MutableCapabilities browserOptions) {
        WebDriver driver = null;
        switch (webDriverName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(Arrays.asList("--start-maximized",
                        "--allow-file-access-from-files",
                        "--allow-running-insecure-content",
                        "--disable-notifications",
                        "--disable-infobars",
                        "--disable-file-cookies",
                        "--disable-web-security",
                        "--disable-extensions",
                        "--disable-feature=VizDisplayCompositor"));
                browserOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                browserOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                browserOptions.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

    public static WebDriver createDefault(WebDriverName webDriverName) {
        return create(webDriverName, new MutableCapabilities());
    }
}



