package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

    @FindBy(linkText = "Form Authentication")
    private WebElement authentification;
    @FindBy(css = "#content > ul > li:nth-child(6) > a")
    private WebElement checkBoxLink;
    @FindBy(css = "#content > ul > li:nth-child(11) > a")
    private WebElement dropDownLink;
    @FindBy(css = "#content > ul > li:nth-child(29) > a")
    private WebElement alertsLink;
    @FindBy(css = "#content > ul > li:nth-child(33) > a")
    private WebElement multipleWinlink;
    @FindBy(css = "#content > ul > li:nth-child(44) > a")
    private WebElement editorLink;


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
    public CheckBoxPage clickCheck(){
        logger.info("Opening checkbox page");
        click(checkBoxLink);
        return new CheckBoxPage(driver, logger);
    }

    public DropDownPage clickDropDowns(){
        logger.info("Click on drop down link");
        click(dropDownLink);
        return new DropDownPage(driver,logger);
    }
    public JSAlertPage clickAlertsLink(){
      logger.info("Clicking on the alertLink");
      click(alertsLink);
      return new JSAlertPage(driver, logger);
    }
    public WindowsPage clickWinlink(){
        logger.info("click on the win link");
        click(multipleWinlink);
        return new WindowsPage(driver, logger);
    }
    public EditorPage clickWYSIWYGELink(){
        logger.info("Clicking on the WYSIWYGE link");
        click(editorLink);
        return new EditorPage(driver,logger);
    }

}
