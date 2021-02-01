package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;


    public BasePage(WebDriver driver, Logger logger) {
        this.logger=logger;
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(AppConfig.TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void click(WebElement element){
        waitForElementToBeVisible(element);
        element.click();
    }
    public void openFirstUrl (){
        driver.get(AppConfig.url);
    }
}
