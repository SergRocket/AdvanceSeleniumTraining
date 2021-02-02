package TestCases;

import PageObjects.SliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {
    @Test
    public void sliderTest(){
        logger.info("Start testing sliders");
        SliderPage sliderPage = new SliderPage(driver, logger);
        sliderPage.openSliderPage();
        String value = "3.5";
        sliderPage.setSliderTo(value);
        String sliderValue = sliderPage.getSliderValue();
        Assert.assertTrue(sliderValue.equals(value),"Unexpected slider value");
    }
}
