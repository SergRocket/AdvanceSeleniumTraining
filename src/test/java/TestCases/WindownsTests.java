package TestCases;

import PageObjects.NewWindowPage;
import PageObjects.WelcomePage;
import PageObjects.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindownsTests extends  BaseTest {
    @Test
    public void newWinTest(){
        logger.info("Starting windows test");
        WelcomePage welcomePage = new WelcomePage(driver,logger);
        welcomePage.openWelcomePage();
        WindowsPage windowsPage = welcomePage.clickWinlink();
        windowsPage.openNewWindow();
        NewWindowPage newWindowPage = windowsPage.switchToNewWinPage();
        String pageSource = newWindowPage.getCurrentPageSource();
        Assert.assertTrue(pageSource.contains("New Window"), "New page was not opened");
    }
}
