package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContextMenuPage extends BasePage {
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public static final String CONTEXT_MENU_URL = "http://the-internet.herokuapp.com/context_menu";
    public static final By ELEMENT_RIGHT_CLICK = By.xpath("//*[@id='hot-spot']");
    public final String EXP_RESULT_ALERT = "You selected a context menu";
    /**
     * Open website http://the-internet.herokuapp.com/context_menu
     */
    public void openPage() {
        driver.get(CONTEXT_MENU_URL);
    }
    /**
    Find element for test and context click
     */
    public void rightClickToElement() {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(ELEMENT_RIGHT_CLICK);
        actions.contextClick(element).perform();
        wait.until(ExpectedConditions.alertIsPresent());
    }
    /**
    *Checking the warning after a click
     */
    public String getAlertText(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}

