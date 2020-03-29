package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterMobile {
    private WebDriver driver;
    private WebDriverWait wait;
    public static final Logger logger = LogManager.getLogger(FilterMobile.class);

   public FilterMobile(WebDriver driver){
       this.driver = driver;
       wait = new WebDriverWait(driver,10);
    }

   public void filterManufactory(){
       driver.findElement(By.xpath(".//button[contains(text(),'Показать всё')]")).click();
       logger.info("filterManufactory is open");
   }
   public void selectManufactoryApple(){
       driver.findElement(By.xpath("//span[contains(text(),'Apple')]")).click();
       logger.info("selected Apple");
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(text(),'Свернуть')]")));
       driver.findElement(By.xpath(".//button[contains(text(),'Свернуть')]")).click();
       logger.info("selected Xiaomi");
   }

   public void sortByPrice(){
       driver.findElement(By.xpath(".//a[contains(text(),'по цене')]")).click();
       logger.info("sort by Price");
   }
}
