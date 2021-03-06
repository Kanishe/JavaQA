package test;

import applicationshelper.LauncherDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FilterMobile;
import pages.YandexMraket;

public class YandexMraketComparison extends LauncherDriver {

    private static final Logger logger = LogManager.getLogger(YandexMraketComparison.class);
    private YandexMraket yandexMarket;
    private FilterMobile filterMobile;


    @BeforeClass
    public void initPage(){
        yandexMarket = new YandexMraket(driver);
        filterMobile = new FilterMobile(driver);
    }

    @Test
    public void testComparisionTwoItems(){
        yandexMarket.openYandexMarket();
        yandexMarket.openPageElectronics();
        yandexMarket.openPageMobilPhone();
        filterMobile.filterManufactory();
        filterMobile.selectManufactoryApple();
        filterMobile.sortByPrice();

    }
}
