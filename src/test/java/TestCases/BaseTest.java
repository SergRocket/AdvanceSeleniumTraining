package TestCases;

import Utils.AppConfig;
import Utils.BrowserDriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;
    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;
    @Parameters({"browser", "chromeProfile"})
    @BeforeMethod
    public void beforeLogin(Method method, @Optional("chrome") String browser, @Optional String profile, ITestContext testContext) {
        String testName = testContext.getCurrentXmlTest().getName();
        logger = LogManager.getLogger(testName);
        BrowserDriverFactory browserDriverFactory = new BrowserDriverFactory(browser, logger);
        //if(profile != null){
            driver = browserDriverFactory.createChromeWithProfile(profile);
        //}else {
         //   driver = browserDriverFactory.createDriver();
        //}
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(AppConfig.TIMEOUT));
        driver.get(AppConfig.url);
        this.testSuiteName = testContext.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    @AfterMethod
    public void shuttingDown() {
        driver.close();
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "data_provider")
    protected static Object[][] data_provider() {
        return new Object[][]{
                {1, "index.html"},
                {2, "groot.jpg"},
        };
    }

    protected void takeScreenshot(String fileName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + File.separator + "test-outpit" + File.separator + "screenshots" +
                File.separator + getTodayDate() + File.separator + testSuiteName + File.separator + testName + File.separator
                + testMethodName + File.separator + getSystemTime() + " " + fileName + " .png";
        try {
            FileUtils.copyFile(srcFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String getTodayDate(){
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }
    public String getSystemTime(){
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }
    protected List<LogEntry> getBrowserLogs(){
        LogEntries logEntries = driver.manage().logs().get("browser");
        List<LogEntry> logEntries1 = logEntries.getAll();
        return logEntries1;
    }
}
