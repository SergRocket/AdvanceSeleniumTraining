package TestCases;

import PageObjects.JSErrorPage;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JSErrorTest extends BaseTest {
    @Test
    public void jsErrorTest(){
        logger.info("Starting jserror testing");
        SoftAssert softAssert = new SoftAssert();
        JSErrorPage jsErrorPage = new JSErrorPage(driver, logger);
        jsErrorPage.openJsErrorPage();
        List<LogEntry> logEntries = getBrowserLogs();
        for (LogEntry logEntry : logEntries){
            if(logEntry.getLevel().toString().equals("SEVERE")){
                softAssert.fail("Severe error: "+ logEntry.getMessage());
                System.out.print("Errors are: "+logEntry.getMessage());
            }
        }
    }
}
