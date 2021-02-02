package PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {
    @FindBy(css = "#content > div > a")
    private WebElement openNewWinButton;
    public WindowsPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
    public void openNewWindow(){
        logger.info("Click to open new window");
        openNewWinButton.click();
    }
    public NewWindowPage switchToNewWinPage(){
        logger.info("Looking for new window");
        switchToWinWithTitle("New Window");
        return new NewWindowPage(driver,logger);
    }

}
