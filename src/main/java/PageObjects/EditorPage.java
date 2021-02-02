package PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditorPage extends BasePage {
    @FindBy(id = "tinymce")
    private WebElement editorLocator;
    @FindBy(tagName = "iframe")
    private WebElement frame;
    public EditorPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public String getEditorText(){
        switchToFrame(frame);
        String text = find(editorLocator).getText();
        logger.info("Text from editor: "+text);
        return text;
    }
}
