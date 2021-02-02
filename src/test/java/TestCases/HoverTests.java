package TestCases;

import PageObjects.HoverPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTests extends BaseTest {
    @Test
    public void user2ProfileTest(){
        logger.info("Starting hover test");
        HoverPage hoverPage = new HoverPage(driver, logger);
        hoverPage.openHoverPage();
        hoverPage.openUserProfile(2);
        Assert.assertTrue(hoverPage.getCurrentPageTitle().contains("Internet"),"Unexpected title");
    }
}
