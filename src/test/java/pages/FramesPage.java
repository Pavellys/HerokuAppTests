package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.awt.*;

public class FramesPage extends BasePage{
    public static final String FRAMES_URL = "http://the-internet.herokuapp.com/frames";
    public static final By PATH_ELEMENT_IFRAME = By.xpath("//*[@href='/iframe']");
    public static final By PATH_TEXT_IN_FRAME = By.id("tinymce");
    public final String EXP_TEXT_FROM_FRAME = "Your content goes here.";
    public FramesPage(WebDriver driver) {
        super(driver);
    }
    /*
    Open website http://the-internet.herokuapp.com/frames
     */
    @Override
    public void openPage() {
        driver.get(FRAMES_URL);
    }
    /*
    Click to element "iframe"
     */
    public void clickToElementIFrame(){
        driver.findElement(PATH_ELEMENT_IFRAME).click();
    }
    /*
    Waiting load page
     */
    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }
    /*
    Search actual text on page
     */
    public String searchTextInFrame(){
        return driver.switchTo().frame(0).findElement(PATH_TEXT_IN_FRAME).getText();
    }

}
