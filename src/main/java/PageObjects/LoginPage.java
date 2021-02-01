package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(className = "radius")
    private WebElement loginButon;
    @FindBy(id = "flash")
    private WebElement error ;
    @FindBy(css = "#flash")
    private WebElement success;


    public LoginPage(WebDriver driver, Logger logger){
        super(driver, logger);
    }

    public LogoutPage login (String passw, String userName){
        logger.info("Executing login test");
        username.sendKeys(passw);
        password.sendKeys(userName);
        click(loginButon);
        return new  LogoutPage(driver, logger);

        }
        public boolean curUrl (){
            boolean currentUrl = driver.getCurrentUrl().contains(AppConfig.expectedUrl);
            return currentUrl;
        }

        public String checkErrorMessage(){
        waitForElementToBeVisible(error);
        return error.getText();
        }

        public String getSuccessMessage(){
          waitForElementToBeVisible(success);
          return success.getText();
        }
 }
