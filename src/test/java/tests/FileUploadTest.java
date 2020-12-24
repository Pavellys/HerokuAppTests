package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class FileUploadTest extends BaseTests{
    @Test
    public void fileUploadTest() {
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.openPage();
        fileUploadPage.uploadFilePath();
        fileUploadPage.clickToButtonUpload(fileUploadPage.BUTTON_UPLOAD);
        fileUploadPage.waiterUpload();
        fileUploadPage.isFileUploadDone();
        Assert.assertEquals(fileUploadPage.getFileUploadText(), fileUploadPage.EXP_FILE_NAME);
    }
}
