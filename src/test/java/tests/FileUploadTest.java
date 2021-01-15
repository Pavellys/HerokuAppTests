package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class FileUploadTest extends BaseTests{
    public final String FILE_PATH = "C:\\Users\\dkwr2\\OneDrive\\Desktop\\test.txt";
    public final String EXP_FILE_NAME = "test.txt";

    @Test
    public void fileUploadTest() {
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.openPage();
        fileUploadPage.uploadFile(FILE_PATH);
        fileUploadPage.clickToButtonUpload(fileUploadPage.BUTTON_UPLOAD);
        fileUploadPage.waiterUpload();
        fileUploadPage.isFileUploadDone();
        Assert.assertEquals(fileUploadPage.getFileUploadText(), EXP_FILE_NAME);
    }
}
