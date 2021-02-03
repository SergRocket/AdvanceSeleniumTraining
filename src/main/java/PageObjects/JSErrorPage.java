package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class JSErrorPage extends BasePage {
    public JSErrorPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
    public void openJsErrorPage(){
        logger.info("Opening thejsError page");
        driver.get(AppConfig.urlErrors);
        logger.info("The jspage error is opened");
    }
}
