package webDriver.test.bringItOnTest;

import org.testng.Assert;
import org.testng.annotations.*;
import webDriver.page.pastebin.PastebinResultOfCreationPastePage;
import webDriver.page.pastebin.PastebinHomePage;
import webDriver.test.BaseTest;

public class CheckingAddNewPasteTest extends BaseTest {
    private PastebinResultOfCreationPastePage googleCloudWindow;
    
    @Test(description = "checks if the paste was created successfully")
    public void createNewPaste() {
        googleCloudWindow = new PastebinHomePage()
                .enterCode("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .chooseBashInSyntaxHighlighting()
                .choose10MinutesInPasteExpiration()
                .enterPasteName("how to gain dominance among developers")
                .addNewPaste();
        Assert.assertTrue(googleCloudWindow.isPastCreated());
    }
    
    @Test(dependsOnMethods = "createNewPaste",
            description = "checks if the title is contains \"how to gain dominance among developers\"")
    public void checkTitleHeaderEqualsParseNameTest() {
        Assert.assertTrue(googleCloudWindow.getTitleBrowser().contains("how to gain dominance among developers"));
    }
    
    @Test(dependsOnMethods = "createNewPaste",
            description = "checks if syntax highlighting is choose correctly")
    public void checkSyntaxHighlightingForBash() {
        Assert.assertEquals(googleCloudWindow.getSyntaxHighlighted(), "Bash",
                "Syntax isn't highlight for Bash");
    }
    
    @Test(dependsOnMethods = "createNewPaste",
            description = "checks if code is entered correctly")
    public void checkCodeEnteredCorrectly() {
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        Assert.assertEquals(googleCloudWindow.getCodePaste(), code);
    }
}
