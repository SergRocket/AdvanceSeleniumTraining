package TestCases;

import PageObjects.JSAlertPage;
import PageObjects.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {
    @Test
    public void jsAlertTest(){
        logger.info("the testing of the alerts was started");
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openWelcomePage();
        JSAlertPage jsAlertPage = welcomePage.clickAlertsLink();
        jsAlertPage.clickOnAlertButton();
        jsAlertPage.acceptAlert();
        String result = jsAlertPage.getResults();
        Assert.assertTrue(result.equals("I am a JS Alert"), "Alert message is not expected");
        Assert.assertTrue(result.equals("You successfuly clicked an alert"), "Unexpected result");
    }
    @Test
    public void jsAlertDismissTest(){
        logger.info("Starting dismiss test");
        WelcomePage welcomePage = new WelcomePage(driver,logger);
        welcomePage.openWelcomePage();
        JSAlertPage alertPage = welcomePage.clickAlertsLink();
        alertPage.clickOnAlertButton();
        String alertMessage = alertPage.getResults();
        alertPage.dismissAlert();
        String result = alertPage.getResults();
        Assert.assertTrue(alertMessage.equals("I am a JS Confirm"), "Alert message is not expected");
        Assert.assertTrue(result.equals("You clicked: Cancel"), "Unexpected result");
    }

    @Test
    public void jsPromptTest(){
        logger.info("Starting prompt Alert test");
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openWelcomePage();
        JSAlertPage jsAlertPage = welcomePage.clickAlertsLink();
        jsAlertPage.clickOnAlertJSPrompt();
        String alertMessage = jsAlertPage.getResults();
        jsAlertPage.inputTextInAlert("Hello Alert, its Serg here");
        String result = jsAlertPage.getResultsAfterInput();
        Assert.assertTrue(alertMessage.equals("I am a JS prompt"), "Unexpected result");
        Assert.assertTrue(alertMessage.equals("You entered: Hello Alert, its Serg here "), "Unexpected text");
    }

}
