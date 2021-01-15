package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramesPage;

public class FramesTests extends BaseTests{
    public final String EXP_TEXT_FROM_FRAME = "Your content goes here.";

    @Test
    public void iframeElement(){
        FramesPage framesPage = new FramesPage(driver);
        framesPage.openPage();
        framesPage.clickToElementIFrame();
        framesPage.waitForPageLoaded();
        Assert.assertEquals(framesPage.searchTextInFrame(), EXP_TEXT_FROM_FRAME);
    }
}
