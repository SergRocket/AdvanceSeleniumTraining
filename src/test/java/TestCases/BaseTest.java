package TestCases;

import Utils.AppConfig;
import Utils.BrowserDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;
    @Parameters({"browser"})
    @BeforeMethod
    public void beforeLogin(@Optional("chrome")String browser, ITestContext testContext) {
        String testName = testContext.getCurrentXmlTest().getName();
        logger = LogManager.getLogger(testName);
        BrowserDriverFactory browserDriverFactory = new BrowserDriverFactory(browser, logger);
        driver=browserDriverFactory.createDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(AppConfig.TIMEOUT));
        driver.get(AppConfig.url);
    }

    @AfterMethod
    public void shuttingDown() {
        driver.close();
        if (driver != null) {
            driver.quit();
        }
    }
    @DataProvider(name = "data_provider")
    protected static Object[][] data_provider(){
        return new Object[][]{
                {1,"index.html"},
                {2,"groot.jpg"},
        };
    }
}
