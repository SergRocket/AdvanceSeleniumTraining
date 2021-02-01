package TestCases;

import PageObjects.LoginPage;
import PageObjects.LogoutPage;
import PageObjects.WelcomePage;
import Utils.AppConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends BaseTest {
    @Test
    public void invalidLog (){
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openWelcomePage();
        LoginPage loginPage = welcomePage.openLoginPage();
        LogoutPage logoutPage = loginPage.login(AppConfig.invalidUsername, AppConfig.invalidPassword);
        String failedLogin = loginPage.checkErrorMessage();

        //Assert.assertTrue(loginPage.curUrl());
        Assert.assertTrue(loginPage.checkErrorMessage().contains(AppConfig.errorMessage));
    }
}
