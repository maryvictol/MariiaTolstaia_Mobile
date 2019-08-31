package scenarios;

import nativePageObjects.AddContactPage;
import nativePageObjects.BasePage;
import enums.PropertyFile;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Tests for native application
 */
@Test(groups = {"native"})
public class NativeTest extends Hooks {
    protected NativeTest() throws IOException {
         super(PropertyFile.NATIVE);
    }

    @Test(description = "This simple test just click on button 'Add contact'")
    public void simplestTest() throws Exception {
        //Click on button 'Add contact'
        new BasePage(driver())
                .checkApplicationTitle("Contact Manager")
                .checkAddContactButtonIsDisplayed()
                .pushAddContactButton()
                .checkApplicationTitle("Add Contact");

        //Check active results
        new AddContactPage(driver()).checkAddContactPageElements();
        System.out.println("Simplest Appium test done");
    }
}
