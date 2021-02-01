package PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxPage extends BasePage {

    private By checkbox= By.xpath("//input[@type='checkbox']");

    public CheckBoxPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void clickOnAllCheckboxes(){
       logger.info("all checkboxes are selected");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }
    }

    public boolean areAllCheckboxesAreSelected(){
        logger.info("Make sure all checkboxes are selected");
        List<WebElement> checkboxes = findAll(checkbox);
        //checkbox in checkboxes list
        for (WebElement checkbox : checkboxes){
            if(!checkbox.isSelected()){
                return false;
            }
        }
        return true;
    }
 }
