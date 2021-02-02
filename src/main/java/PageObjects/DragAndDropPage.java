package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    @FindBy(id = "column-a")
    private WebElement columnA;
    @FindBy(id = "column-b")
    private WebElement columnB;

    public DragAndDropPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
    public void openDrugDropLink(){
        logger.info("Opening link to the drug and drop");
        driver.get(AppConfig.urlDrugDrop);
        logger.info("Page is opened");
    }
    public void drugFromTo(){
        logger.info("Perroming drug and drop");
        performDrugAndDrop(columnA, columnB);
    }
    public String getColumnAText(){
        logger.info("Get A text value");
        String text = find(columnA).getText();
        logger.info("Column A text: "+text);
        return text;
    }
    public String getColumnBText(){
        logger.info("Get B text value");
        String text = find(columnB).getText();
        logger.info("Column B text: "+text);
        return text;
    }
}
