package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoverPage extends BasePage {
   private By avatarLocator = By.xpath("//div[@class='figure']");
   private By viewProfileLinkLocator = By.xpath(".//a[contains(text(),'View profile')]");
    public HoverPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
    public void openHoverPage(){
        logger.info("Open hover link");
        driver.get(AppConfig.urlHover);
        logger.info("Page is opened");
    }
    public void openUserProfile(int i){
        logger.info("Open user profile");
        List<WebElement> avatars = findAll(avatarLocator);
        WebElement specifiedUserAvatar = avatars.get(i-1);
        hoverOverElement(specifiedUserAvatar);
        specifiedUserAvatar.findElement(viewProfileLinkLocator).click();
    }
}
