package TestCases;

import PageObjects.CheckBoxPage;
import PageObjects.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {
    @Test
    public void checkBoxClick(){
        logger.info("Checkbox test was started");
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openWelcomePage();
        CheckBoxPage checkBoxPage = welcomePage.clickCheck();
        checkBoxPage.clickOnAllCheckboxes();
        Assert.assertTrue(checkBoxPage.areAllCheckboxesAreSelected(), "Not all checkboxes are selected");
    }
}
