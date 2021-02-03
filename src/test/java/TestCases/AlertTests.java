package TestCases;

import PageObjects.JSAlertPage;
import PageObjects.WelcomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertTests extends BaseTest {
    SoftAssert softAssert;
    @Test
    public void jsAlertTest(){
        logger.info("the testing of the alerts was started");
        softAssert = new SoftAssert();
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openWelcomePage();
        JSAlertPage jsAlertPage = welcomePage.clickAlertsLink();
        jsAlertPage.clickOnAlertButton();
        jsAlertPage.acceptAlert();
        String result = jsAlertPage.getResults()+"[FAIL]";
        softAssert.assertTrue(result.equals("I am a JS Alert"), "Alert message is not expected");
        softAssert.assertTrue(result.equals("You successfuly clicked an alert"), "Unexpected result");
        softAssert.assertAll();
    }
    @Test
    public void jsAlertDismissTest(){
        logger.info("Starting dismiss test");
        WelcomePage welcomePage = new WelcomePage(driver,logger);
        welcomePage.openWelcomePage();
        JSAlertPage alertPage = welcomePage.clickAlertsLink();
        alertPage.clickOnAlertButton();
        String alertMessage = alertPage.getResults()+"[FAIL]";
        alertPage.dismissAlert();
        String result = alertPage.getResults()+"[FAIL]";
        softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"), "Alert message is not expected");
        softAssert.assertTrue(result.equals("You clicked: Cancel"), "Unexpected result");
        softAssert.assertAll();
    }

    @Test
    public void jsPromptTest(){
        logger.info("Starting prompt Alert test");
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openWelcomePage();
        JSAlertPage jsAlertPage = welcomePage.clickAlertsLink();
        jsAlertPage.clickOnAlertJSPrompt();
        String alertMessage = jsAlertPage.getResults()+"[FAIL]";
        jsAlertPage.inputTextInAlert("Hello Alert, its Serg here");
        softAssert.assertTrue(alertMessage.equals("I am a JS prompt"), "Unexpected result");
        softAssert.assertTrue(alertMessage.equals("You entered: Hello Alert, its Serg here "), "Unexpected text");
        softAssert.assertAll();
    }

}
