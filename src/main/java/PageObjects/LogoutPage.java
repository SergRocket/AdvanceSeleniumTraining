package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    @FindBy(xpath = "//a[@class='button secondary radius']")
    private WebElement logoutButton;

    public LogoutPage(WebDriver driver, Logger logger){
         super(driver,logger);
    }

    public void logout (){
       click(logoutButton);
    }

    public boolean isLogoutButtonVisible(){
        return logoutButton.isDisplayed();
    }

    public String getUrl(){
        return AppConfig.expectedUrl;
    }
}
