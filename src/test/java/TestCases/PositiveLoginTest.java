package TestCases;

import PageObjects.LoginPage;
import PageObjects.LogoutPage;
import PageObjects.WelcomePage;
import Utils.AppConfig;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends BaseTest {

    @Test
    public void ValidLogin (){
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openWelcomePage();
        LoginPage loginPage = welcomePage.openLoginPage();
        LogoutPage logoutPage = loginPage.login(AppConfig.userName, AppConfig.passw);
        String successLogin = loginPage.getSuccessMessage();
        Assert.assertTrue(logoutPage.isLogoutButtonVisible());
        Assert.assertTrue(loginPage.curUrl());
        Assert.assertTrue(Boolean.parseBoolean(successLogin), AppConfig.expectedSuccessMessage);
        }
}
