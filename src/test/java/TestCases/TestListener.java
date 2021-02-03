package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

;

public class TestListener implements ITestListener {
    Logger logger;
    String testName;
    String testMethodName;
    @Override
    public void onTestStart(ITestResult iTestResult) {
        this.testMethodName = iTestResult.getMethod().getMethodName();
        logger.info("[Starting " + testMethodName + "]");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
         logger.info("[Starting " + testMethodName + " passed]");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("[Starting " + testMethodName + " failed]");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("[Starting " + testMethodName + " skipped]");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
         this.testName = iTestContext.getCurrentXmlTest().getName();
         this.logger = LogManager.getLogger(testName);
         logger.info("[TEST " + testName + " STARTED]");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("[ALL " + testName + " FINISHED]");
    }
}
