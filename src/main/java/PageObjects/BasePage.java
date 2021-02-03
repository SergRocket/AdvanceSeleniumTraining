package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;


    public BasePage(WebDriver driver, Logger logger) {
        this.logger=logger;
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(AppConfig.TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void click(WebElement element){
        waitForElementToBeVisible(element);
        element.click();
    }
    public void openFirstUrl (){
        driver.get(AppConfig.url);
    }

    protected List<WebElement> findAll(By checkbox){
        return driver.findElements(checkbox);
    }

    protected WebElement find(WebElement element){
        return element;
    }

    protected Alert switchToAlert(){
      wait.until(ExpectedConditions.alertIsPresent());
      return driver.switchTo().alert();
    }
    public void switchToWinWithTitle(String expectedTitle){
        String firstWin = driver.getWindowHandle();
        Set<String> allWin = driver.getWindowHandles();
        Iterator<String> winIterator = allWin.iterator();
        while (winIterator.hasNext()){
            String windowHandle = winIterator.next().toString();
            if(!windowHandle.equals(firstWin)){
                driver.switchTo().window(windowHandle);
                if(getCurrentPageTitle().equals(expectedTitle)){
                    break;
                }
            }
        }
    }
    public String getCurrentPageTitle(){
        return driver.getTitle();
    }
    public String getCurrentPageSource(){
        return  driver.getPageSource();
    }
    protected void switchToFrame(WebElement element){
        driver.switchTo().frame(find(element));
    }
    public void openCkickPageURL(){
        logger.info("Open needed url");
        driver.get(AppConfig.KeyPressUrl);
    }
    protected void pressKey(WebElement element, Keys key){
        find(element).sendKeys(key);
    }
    public void pressKeyOnPage(Keys key){
        logger.info("Pressing "+key.name()+" using Actions class");
        Actions actions = new Actions(driver);
        actions.sendKeys(key).build().perform();
    }
    protected void type(String text, WebElement element) {
        waitForElementToBeVisible(element);
        find(element).sendKeys(text);
    }
    public void scrollToButtom(){
        logger.info("Scrolling to the buttom of the page");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    protected void performDrugAndDrop(WebElement from, WebElement to){
        /*Alternative way how to perfom drug and drop test
        Actions actions = new Actions(driver);
        action.dragAnddrop(find(from), find(to).build().perform());
         */
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(
                "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                        + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                        + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                        + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                        + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);", find(from), find(to));

    }
    protected void hoverOverElement(WebElement element){
        Actions actions= new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    public void setCookie(Cookie cookie){
        logger.info("Adding cookie: " + cookie.getDomain());
        driver.manage().addCookie(cookie);
        logger.info("Cookie added");
    }

    public String getCookie(String name){
        logger.info("Getting value " + name);
        return driver.manage().getCookieNamed(name).getValue();
    }

}
