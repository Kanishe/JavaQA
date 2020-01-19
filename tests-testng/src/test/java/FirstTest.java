import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FirstTest extends TestBase{
  private static final Logger logger = LogManager.getLogger();

  public static void main(String[] args) {
    System.out.println("START");
    logger.info("Поехали!");
    app.init();
    logger.info("Приехали");
    app.quit();
    logger.info("Стоп машина");
  }
}
