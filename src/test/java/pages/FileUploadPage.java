package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FileUploadPage extends BasePage{
    public final String FILE_UPLOAD_URL = "http://the-internet.herokuapp.com/upload";
    public final String FILE_PATH = "C:\\Users\\dkwr2\\OneDrive\\Desktop\\test.txt";
    public final By UPLOAD_PATH = By.id("file-upload");
    public final By BUTTON_UPLOAD = By.id("file-submit");
    public final By PATH_UPLOAD_DONE = By.id("uploaded-files");
    public static final String ERROR = "error";
    public final String EXP_FILE_NAME = "test.txt";
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }
    /**
    *Open website http://the-internet.herokuapp.com/upload
     */
    @Override
    public void openPage() {
        driver.get(FILE_UPLOAD_URL);
    }
    /**
    Enter path to file
     */
    public void uploadFile(String filePath){
        driver.findElement(UPLOAD_PATH).sendKeys(filePath);
    }
    /**
    *Click to button "Upload"
     */
    public void clickToButtonUpload(By path){
        driver.findElement(path).click();
    }
    /**
    *Wait until upload file
     */
    public void waiterUpload() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PATH_UPLOAD_DONE));
    }
    /**
    *Checking upload file
     */
    public boolean isFileUploadDone(){
        return driver.findElement(PATH_UPLOAD_DONE).isDisplayed();
    }
    /**
    *Checking message after upload file
     */
    public String getFileUploadText(){
        if(isFileUploadDone()){
            return driver.findElement(PATH_UPLOAD_DONE).getText();
        }else{
            return ERROR;
        }
    }
}
