package webDriver.test.iCanWinTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webDriver.page.pastebin.PastebinHomePage;
import webDriver.test.BaseTest;

public class SimplePasteTest extends BaseTest {
    
    @Test(description = "enter 3 data, no create paste")
    public void enterElements() {
        SoftAssert assertSoft = new SoftAssert();
        PastebinHomePage window = new PastebinHomePage()
                .enterCode("Hello from WebDriver")
                .choose10MinutesInPasteExpiration()
                .enterPasteName("helloweb");
        assertSoft.assertEquals(window.getCode(), "Hello from WebDriver");
        assertSoft.assertEquals(window.getExpirationInDropList(), "10 Minutes");
        assertSoft.assertEquals(window.getNamePaste(), "helloweb");
        assertSoft.assertAll();
    }
}
