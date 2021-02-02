package TestCases;

import PageObjects.KeyPressPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressTest extends BaseTest {
    @Test
    public void pressKeyTest(){
        logger.info("Starting testing pressing keys");
        KeyPressPage keyPressPage = new KeyPressPage(driver,logger);
        keyPressPage.openPage();
        keyPressPage.pressKey(Keys.ARROW_UP);
        String result = keyPressPage.getResultText();
        Assert.assertTrue(result.equals("You entered: UP"), "Unexpected message result");
    }

    @Test
    public void pressKeyOnPage(){
        logger.info("Testing pressing key on the page");
        KeyPressPage keyPressPage = new KeyPressPage(driver, logger);
        keyPressPage.openPage();
        keyPressPage.pressKeyOnPage(Keys.SPACE);
        String result = keyPressPage.getResultText();
        Assert.assertTrue(result.equals("You entered: SPACE"), "Unexpected result");
    }
}
