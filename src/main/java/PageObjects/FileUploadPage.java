package PageObjects;

import Utils.AppConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {
    @FindBy(id = "file-upload")
    private WebElement choseFileFieldLocator;
    @FindBy(id = "file-submit")
    private WebElement uploadButtonLocator;
    @FindBy(id = "uploaded-files")
    private WebElement uploadedFilesLocator;

    public FileUploadPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
    public void openPage(){
        logger.info("Opening page: "+ AppConfig.urlFileupload);
        openFirstUrl();
        driver.get(AppConfig.urlFileupload);
        logger.info("Page is opened");
    }
    public void pushUploadButton(){
        logger.info("Clicking on upload button");
        click(uploadButtonLocator);
    }
    public void selectFile(String fileName){
        logger.info("Selecting: "+fileName+" file from the folder");
        //we can user full path: String filePath = "C:/uswer/foler/some-file.txt";
        String filePath = System.getProperty("user.dir")+"//src//main//resources//files//"+fileName;
        type(filePath, choseFileFieldLocator);
        logger.info("File selected");
    }
    public String getUploadFilesNames(){
        String names = find(uploadedFilesLocator).getText();
        logger.info("Uploaded files: "+names);
        return names;
    }
}
