package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DynamicControlsPage extends BasePage {
    public static final String DYNAMIC_CONTROLS_URL = "http://the-internet.herokuapp.com/dynamic_controls";
    public final By CHECKBOX_ELEMENT = By.id("checkbox");
    public final By BUTTON_ENABLE = By.xpath("//*[text() = 'Enable']");
    public final By FIELD_INPUT = By.xpath("//*[@id='input-example']/input");
    public final By BUTTON_REMOVE = By.xpath("//*[@id='checkbox-example']/button");
    public final By TEXT_AFTER_CLICK_ENABLE = By.id("message");
    public final By REMOVE_RESULT_TEXT = By.id("message");

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }
    /**
    *Open website http://the-internet.herokuapp.com/dynamic_controls
     */
    @Override
    public void openPage() {
        driver.get(DYNAMIC_CONTROLS_URL);

    }
    /**
    *Checking checkbox
     */
    public boolean isCheckboxDisplayed() {
        try {
            driver.findElement(CHECKBOX_ELEMENT).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    /**
    *Find element for Checkbox test
     */
    public WebElement findElementForCheckbox() {
        return driver.findElement(BUTTON_REMOVE);
    }
    /**
    *Waits until the element disappears
     */
    public void waiterCheckbox() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(CHECKBOX_ELEMENT));
    }
    /**
    *Waits until the element to appears
     */
    public void waitForCheckboxDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(REMOVE_RESULT_TEXT));
    }
    /**
    *Get text after click to button "Remove"
     */
    public String getRemoveResultText() {
        return driver.findElement(REMOVE_RESULT_TEXT).getText();
    }
    /**
    *Get text after click to button "Enable"
     */
    public String getEnableResultText() {
        return driver.findElement(TEXT_AFTER_CLICK_ENABLE).getText();
    }
    /**
    *Checking input field
     */
    public boolean isInputFieldEnabled(){
        return driver.findElement(FIELD_INPUT).isEnabled();
    }
    /**
     *Find element for Input field
     */
    public WebElement findInputElement() {
        return driver.findElement(FIELD_INPUT);
    } /**
     *Find element for Button Enable
     */
    public WebElement findButtonEnable() {
        return driver.findElement(BUTTON_ENABLE);
    }
}
