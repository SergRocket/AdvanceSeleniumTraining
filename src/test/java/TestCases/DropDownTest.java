package TestCases;

import PageObjects.DropDownPage;
import PageObjects.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends BaseTest {

    @Test
    public void dropDownSelecting(){
        logger.info("Start testing dropDown");
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openWelcomePage();
        DropDownPage dropDownPage = welcomePage.clickDropDowns();
        dropDownPage.selectFromDropDown(2);
        String selectedOption = dropDownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"), "Option 2 was not selected. Instead selected "
                +selectedOption);
    }
}
