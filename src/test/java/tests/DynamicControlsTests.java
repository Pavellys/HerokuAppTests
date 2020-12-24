package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;


public class DynamicControlsTests extends BaseTests {
    @Test
    public void testCheckbox(){
        DynamicControlsPage dynamicControl = new DynamicControlsPage(driver);
        dynamicControl.openPage();
        dynamicControl.isCheckbox();
        dynamicControl.findElementForTest(dynamicControl.BUTTON_REMOVE).click();
        dynamicControl.waiterCheckbox();
        Assert.assertEquals(dynamicControl.isCheckbox(), dynamicControl.EXP_RESULT_CHECKBOX);
        Assert.assertEquals(dynamicControl.getTextAfterRemove(), dynamicControl.EXP_RESULT_MESSAGE_CHECKBOX);
    }
    @Test
    public void testFieldInput(){
        DynamicControlsPage dynamicControl = new DynamicControlsPage(driver);
        dynamicControl.openPage();
        dynamicControl.findElementForTest(dynamicControl.FIELD_INPUT).isEnabled();
        dynamicControl.findElementForTest(dynamicControl.BUTTON_ENABLE).click();
        dynamicControl.waiterEnable();
        Assert.assertEquals(dynamicControl.getTextAfterEnable(), dynamicControl.EXP_RESULT_MESSAGE_INPUTFIELD);
        Assert.assertEquals(dynamicControl.isEnableInputField(), dynamicControl.EXP_RESULT_INPUTFIELD);
    }
}
