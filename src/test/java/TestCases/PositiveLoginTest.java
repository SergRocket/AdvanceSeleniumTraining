package TestCases;

import PageObjects.LoginPage;
import PageObjects.LogoutPage;
import PageObjects.WelcomePage;
import Utils.AppConfig;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends BaseTest {

    @Test
    public void ValidLogin (){
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openWelcomePage();
        takeScreenshot("Welcome page is opened");
        LoginPage loginPage = welcomePage.openLoginPage();
        //takeScreenshot("Login page is opened");
        Cookie cookie = new Cookie("optimizelySegments", "%7B%7D", "http://the-internet.herokuapp.com",
                "/", null);
        //loginPage.setCookie(cookie);
        LogoutPage logoutPage = loginPage.login(AppConfig.userName, AppConfig.passw);
        String usermane = loginPage.getCookie("optimizelySegments");
        logger.info("Usermane cookie: " + usermane);
        String session = loginPage.getCookie("rack.session");
        logger.info("Session cookie: " + session);
        String successLogin = loginPage.getSuccessMessage();
        takeScreenshot("login was completed");
        Assert.assertTrue(logoutPage.isLogoutButtonVisible());
        Assert.assertTrue(loginPage.curUrl());
        Assert.assertTrue(successLogin.contains(AppConfig.expectedSuccessMessage), "Login wan not completed");
        System.out.print(session);
        System.out.print(usermane);
        }
}
