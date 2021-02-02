package TestCases;

import PageObjects.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends BaseTest {
    @Test(dataProvider = "data_provider")
    public void fileUpload(int no, String fileName){
        logger.info("Starting testing uploading images # "+ no + " for "+fileName);
        FileUploadPage fileUploadPage = new FileUploadPage(driver,logger);
        fileUploadPage.openPage();
        fileUploadPage.selectFile(fileName);
        fileUploadPage.pushUploadButton();
        String filesNames = fileUploadPage.getUploadFilesNames();
        Assert.assertTrue(filesNames.contains(fileName), "Our file " +fileName+ " is not one thet is uploaded");

    }

}
