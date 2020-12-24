package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DynamicControlsPage extends BasePage {
    public static final String DYNAMIC_CONTROLS_URL = "http://the-internet.herokuapp.com/dynamic_controls";
    public final By CHECKBOX_ELEMENT = By.id("checkbox");
    public final By BUTTON_ENABLE = By.xpath("/html/body/div[2]/div/div[1]/form[2]/button");
    public final By FIELD_INPUT = By.xpath("//*[@id='input-example']/input");
    public final By BUTTON_REMOVE = By.xpath("//*[@id='checkbox-example']/button");
    public final By TEXT_AFTER_CLICK_ENABLE = By.xpath("/html/body/div[2]/div/div[1]/form[2]/p");
    public final By TEXT_AFTER_BUTTON = By.id("message");
    public final boolean EXP_RESULT_CHECKBOX = false;
    public final boolean EXP_RESULT_INPUTFIELD = true;
    public final String EXP_RESULT_MESSAGE_CHECKBOX = "It's gone!";
    public final String EXP_RESULT_MESSAGE_INPUTFIELD = "It's enabled!";

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }
    /*
    Open website http://the-internet.herokuapp.com/dynamic_controls
     */
    @Override
    public void openPage() {
        driver.get(DYNAMIC_CONTROLS_URL);

    }
    /*
    Checking checkbox
     */
    public boolean isCheckbox() {
        try {
            driver.findElement(CHECKBOX_ELEMENT).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    /*
    Find element on the path
     */
    public WebElement findElementForTest(By element) {
        return driver.findElement(element);
    }
    /*
    Waits until the element disappears
     */
    public void waiterCheckbox() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(CHECKBOX_ELEMENT));
    }
    /*
    Waits until the element to appears
     */
    public void waiterEnable(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_AFTER_BUTTON));
    }
    /*
    Get text after click to button "Remove"
     */
    public String getTextAfterRemove() {
        return driver.findElement(TEXT_AFTER_BUTTON).getText();
    }
    /*
    Get text after click to button "Enable"
     */
    public String getTextAfterEnable() {
        return driver.findElement(TEXT_AFTER_CLICK_ENABLE).getText();
    }
    /*
    Checking input field
     */
    public boolean isEnableInputField(){
        return driver.findElement(FIELD_INPUT).isEnabled();
    }
}
