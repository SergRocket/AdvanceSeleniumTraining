package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
    @FindBy(id = "range")
    private WebElement rangeLocator;
    @FindBy(tagName = "input")
    private WebElement sliderLocator;
    public SliderPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
    public void openSliderPage(){
        logger.info("Open slider page");
        driver.get(AppConfig.urlSlider);
        logger.info("The page is opened");
    }
    public void setSliderTo(String value){
        logger.info("Move slider to"+value);
        // Move slider normal method
        // Find the xOffset using given value
        // int width = find(sliderLocator).getSize().getWidth();
        // double percent = Double.parseDouble(value) / 5;
        // int xOffset = (int) (width * percent);

        // Actions action = new Actions(driver);
        // action.dragAndDropBy(find(sliderLocator), xOffset, 0).build().perform();

        // Workaround method
        // Calculate number of steps
        int steps = (int)(Double.parseDouble(value)/0.5);
        pressKey(sliderLocator, Keys.ENTER);
        for (int i = 0; i<steps; i++){
            pressKey(sliderLocator, Keys.ARROW_RIGHT);
        }
    }
    public String getSliderValue() {
        String value = find(rangeLocator).getText();
        logger.info("Slider value is " + value);
        return value;
     }
}
