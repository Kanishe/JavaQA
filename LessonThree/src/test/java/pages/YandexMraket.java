package pages;

import applicationshelper.LauncherDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMraket {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(YandexMraket.class);

    public YandexMraket (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }
    public void openYandexMarket(){
        driver.get("https://yandex.ru/");
        logger.info("https://yandex.ru/ is opened");
        driver.get("https://market.yandex.ru/");
        logger.info("https://market.yandex.ru/ is opened");
    }

    public void openPageElectronics(){
        driver.findElement(By.linkText("Электроника")).click();
        wait.until(ExpectedConditions.titleContains("Электроника"));
        logger.info("page Electronics is opened");
    }
    public void openPageMobilPhone(){
        driver.findElement(By.linkText("Мобильные телефоны")).click();
        wait.until(ExpectedConditions.titleContains("Мобильные телефоны"));
        logger.info("page MobilPhone is opened");
    }
}
