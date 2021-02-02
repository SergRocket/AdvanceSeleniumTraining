package TestCases;

import PageObjects.EditorPage;
import PageObjects.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTests extends BaseTest {
    @Test
    public void defaultEditorTest(){
        logger.info("Start testing default editor value ");
        WelcomePage welcomePage = new WelcomePage(driver,logger);
        welcomePage.openWelcomePage();
        welcomePage.scrollToButtom();
        EditorPage editorPage = welcomePage.clickWYSIWYGELink();
        String editorTest = editorPage.getEditorText();
        Assert.assertTrue(editorTest.equals("Your content goes here."), "Unexpected editor text "+editorTest);
    }
}
