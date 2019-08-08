package scenarios;

import enums.Device;
import enums.PropertyFile;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Tests for native application
 */
@Test(groups = {"native"})
public class NativeTest extends Hooks {
    protected NativeTest() throws IOException {
         super(Device.EMULATOR, PropertyFile.NATIVE);
        //super(Device.DEVICE, PropertyFile.NATIVE);
    }

    @Test(description = "This simple test just click on button 'Add contact'")
    public void simplestTest() throws Exception {
        //Click on button 'Add contact'
        By add_btn = By.id(PACKAGE_NAME + "addContactButton");
        driver().findElement(add_btn).click();

        //Check active results
        checkPageElement("Target Account");
        checkPageElement("Contact Name");
        checkPageElement("Contact Phone");
        checkPageElement("Contact Email");
        checkPageElement("Save");
        System.out.println("Simplest Appium test done");
    }

    /**
     * Check element existence by Id
     *
     * @param elementId element Id
     * @throws Exception if element Id doesn't exist
     */
    protected void checkPageElement(String elementId) throws Exception {
        assertTrue(driver().findElementByAccessibilityId(elementId).isDisplayed(),
                "Element not found: " + elementId);
    }
}
