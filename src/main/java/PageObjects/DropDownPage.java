package PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {
 @FindBy(css = "#dropdown")
 private WebElement dropDownMenu;

    public DropDownPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void selectFromDropDown(int a){
      logger.info("Selecting option "+a+" from drop down");
      WebElement dropdownElement = find(dropDownMenu);
      Select dropdown = new Select(dropdownElement);
      //dropdown.deselectByValue(""+a);
      dropdown.selectByIndex(2);
      //Another is  dropdown.selectByVisibleText("Option " + a);
    }

    public String getSelectedOption(){
        WebElement dropdownElement = find(dropDownMenu);
        Select dropdown = new Select(dropdownElement);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        logger.info(selectedOption+" is selected");
        return selectedOption;
    }
}
