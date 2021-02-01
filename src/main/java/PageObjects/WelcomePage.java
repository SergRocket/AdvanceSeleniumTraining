package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

    @FindBy(linkText = "Form Authentication")
    private WebElement authentification;


    public WelcomePage(WebDriver driver, Logger logger){
        super(driver,logger);
    }

    public void openWelcomePage(){
        openFirstUrl();
        logger.info("Open page: "+ AppConfig.url);
        logger.info("Page was opened");
    }

    public LoginPage openLoginPage(){
        logger.info("The loging page was open");
        click(authentification);
        return new LoginPage(driver,logger);
    }
}
