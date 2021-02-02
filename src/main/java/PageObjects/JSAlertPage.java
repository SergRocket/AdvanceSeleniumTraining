package PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSAlertPage extends BasePage {
    @FindBy(css = "#content > div > ul > li:nth-child(1) > button")
    private WebElement jsAlert;
    @FindBy(css = "#content > div > ul > li:nth-child(2) > button")
    private WebElement jsAlertConfirm;
    @FindBy(css = "#content > div > ul > li:nth-child(3) > button")
    private WebElement jsAlertPrompt;
    @FindBy(id = "result")
    private WebElement result;
    public JSAlertPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public  void clickOnAlertButton(){
        logger.info("Click on the first alert");
        click(jsAlert);
        }
    public  void clickOnAlertJSConfirm(){
        logger.info("Click on the second alert");
        click(jsAlertConfirm);
    }
    public  void clickOnAlertJSPrompt(){
        logger.info("Click on the third alert");
        click(jsAlertPrompt);
    }
    public void acceptAlert(){
        logger.info("accept alert");
        Alert alert = switchToAlert();
        alert.accept();
    }

    public void dismissAlert(){
        logger.info("Decline alert");
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    public void inputTextInAlert(String text){
        logger.info("Sending text into Alert");
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResults(){
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        logger.info("Alert has test "+alertText);
        return alertText;
    }

    public String getResultsAfterInput(){
        String results = find(result).getText();
        logger.info("Result test is "+results);
        return results;
    }
}
