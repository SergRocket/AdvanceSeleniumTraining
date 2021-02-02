package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyPressPage extends BasePage {
    @FindBy(css = "#target")
    public WebElement body;
    @FindBy(css = "#result")
    public WebElement result;
    public KeyPressPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
    public void openPage(){
       logger.info("Opening page: "+ AppConfig.KeyPressUrl);
       openCkickPageURL();
       logger.info("Page is opened");
    }
    public void pressKey(Keys key){
        logger.info("Pressing: "+key.name());
        pressKey(body, key);
    }
    public String getResultText(){
        String result = find(this.result).getText();
        logger.info("Result text is: "+result);
        return result;
    }
}
