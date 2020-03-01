package testcase;


import confeguration.LaunchManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class FirstTestGoToOTUS extends LaunchManager {
    private static final Logger logger = LogManager.getLogger(FirstTestGoToOTUS.class);


    @Test
    public void goToOTUS(){
        driver.get("https://otus.ru/");
        logger.info("Test completed Success");
    }
}