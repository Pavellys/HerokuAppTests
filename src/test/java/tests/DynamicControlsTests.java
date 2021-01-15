package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;


public class DynamicControlsTests extends BaseTests {
    public final String EXP_RESULT_MESSAGE_CHECKBOX = "It's gone!";
    public final String EXP_RESULT_MESSAGE_INPUTFIELD = "It's enabled!";
    public final boolean expResultCheckbox = false;
    public final boolean expResultInputfield = true;

    @Test
    public void testCheckbox(){
        DynamicControlsPage dynamicControl = new DynamicControlsPage(driver);
        dynamicControl.openPage();
        dynamicControl.isCheckboxDisplayed();
        dynamicControl.findElementForCheckbox().click();
        dynamicControl.waiterCheckbox();
        Assert.assertEquals(dynamicControl.isCheckboxDisplayed(), expResultCheckbox);
        Assert.assertEquals(dynamicControl.getRemoveResultText(), EXP_RESULT_MESSAGE_CHECKBOX);
    }
    @Test
    public void testFieldInput(){
        DynamicControlsPage dynamicControl = new DynamicControlsPage(driver);
        dynamicControl.openPage();
        dynamicControl.findInputElement().isEnabled();
        dynamicControl.findButtonEnable().click();
        dynamicControl.isInputFieldEnabled();
        Assert.assertEquals(dynamicControl.getEnableResultText(), EXP_RESULT_MESSAGE_INPUTFIELD);
        Assert.assertEquals(dynamicControl.isInputFieldEnabled(), expResultInputfield);
    }
}
