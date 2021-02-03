package Utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserDriverFactory {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger logger;


    public BrowserDriverFactory(String browser, Logger logger){
        this.browser=browser.toLowerCase();
        this.logger=logger;

    }

    public WebDriver createDriver(){
        logger.info("Created browser " + browser);
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver.set(new OperaDriver());
                break;
            case "operaheadless":
                WebDriverManager.operadriver().setup();
                driver.set(new OperaDriver());
                break;
            case "chromeheadless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver.set(new ChromeDriver(chromeOptions));
                break;
            case "phantomjs":
                System.setProperty("phantomjs.binary.path","src/main/resources/phantomjs.exe");
                driver.set(new PhantomJSDriver());
                break;
            case "htmlunit":
                driver.set(new HtmlUnitDriver());
                break;
            default:
                logger.info("Failed to use browser");
        }
        return driver.get();
    }
    public WebDriver createChromeWithProfile(String profile){
        logger.info("Startig chrome driver with profile: " + profile);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=src/main/resources/Profiles" + profile);
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver(chromeOptions));
        return driver.get();
    }
    public WebDriver createdChromeWithMobileEmulation(String deviceName){
        logger.info("Starting driver with " + deviceName + " emulator");
        Map<String, String> mobileEmulator = new HashMap<>();
        mobileEmulator.put("deviceName", deviceName);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulator", mobileEmulator);
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver(chromeOptions));
        return driver.get();
    }
}
