package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTests extends BaseTests{
    @Test
    public void contextMenuTest(){
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.openPage();
        contextMenuPage.rightClickToElement();
        Assert.assertEquals(contextMenuPage.getAlertText(), contextMenuPage.EXP_RESULT_ALERT, "Results not right" );
    }
}
