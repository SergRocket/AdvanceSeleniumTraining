package TestCases;

import PageObjects.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DrudAndDropTest extends BaseTest {
    @Test
    public void dragAndDropTest(){
        logger.info("Start testing drug and drop");
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver,logger);
        dragAndDropPage.openDrugDropLink();
        dragAndDropPage.drugFromTo();
        String columnAText = dragAndDropPage.getColumnAText();
        Assert.assertTrue(columnAText.equals("B"), "Unexpected column text");
        String columnBText = dragAndDropPage.getColumnBText();
        Assert.assertTrue(columnBText.equals("A"), "Unexpected column text");
    }
}
