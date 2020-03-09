package pages;

import applicationshelper.LauncherDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMraket {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(YandexMraket.class);

    public YandexMraket (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,4);
        logger.info("YandexMraket");
    }
    public void openYandexMarket(){
        driver.get("https://yandex.ru/");
        driver.get("https://market.yandex.ru/");
        logger.info("https://market.yandex.ru/ is opened");
    }

}
