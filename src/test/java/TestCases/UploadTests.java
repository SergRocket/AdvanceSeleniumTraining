package TestCases;

import PageObjects.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends BaseTest {
    @Test
    public void imageUpload(){
        logger.info("Starting testing uploading images");
        FileUploadPage fileUploadPage = new FileUploadPage(driver,logger);
        fileUploadPage.openPage();
        String fileName = "groot.jpg";
        fileUploadPage.selectFile(fileName);
        fileUploadPage.pushUploadButton();
        String filesNames = fileUploadPage.getUploadFilesNames();
        Assert.assertTrue(filesNames.contains(fileName), "Our file " +fileName+ " is not one thet is uploaded");

    }
}
