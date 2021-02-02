package TestCases;

import PageObjects.LoginPage;
import PageObjects.WelcomePage;
import Utils.CsvDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLoginTest extends BaseTest {
    @Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void invalidLog (Map<String, String> testData){
        String no= testData.get("no");
        String username= testData.get("username");
        String password= testData.get("password");
        String expectedMessage= testData.get("expectedMessage");
        String description= testData.get("description");
        logger.info("Starting negative login test #"+no+" for "+description);
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openWelcomePage();
        LoginPage loginPage = welcomePage.openLoginPage();
        loginPage.login(username, password);
        String failedLogin = loginPage.checkErrorMessage();
        Assert.assertTrue(failedLogin.contains(expectedMessage), "Login ws not completed");
       }
}
