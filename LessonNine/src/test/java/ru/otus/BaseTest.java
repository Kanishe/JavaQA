package ru.otus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BaseTest {
    private WebDriver driver;
    public BaseTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private static final String HUBS_LINK = ".//a[contains(text(),'Разработка')]";

    @FindBy(xpath = HUBS_LINK)
    private WebElement elHubsLinks;

    public BaseTest checkUrl() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://habr.com/ru/flows/develop/");
    return this;
    }

    public BaseTest clickHubsLink() {
        elHubsLinks.
                click();
        return this;
    }
}