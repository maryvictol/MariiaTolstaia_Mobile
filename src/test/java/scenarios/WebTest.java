package scenarios;

import enums.Device;
import enums.PropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertTrue;

/**
 * Tests for web application
 */
@Test(groups = {"web"})
public class WebTest extends Hooks {
    protected WebTest() throws IOException {
        super(Device.EMULATOR, PropertyFile.WEB);
        //super(Device.DEVICE, PropertyFile.WEB);
    }

    @Test(description = "Open website")
    public void simplestTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        assertTrue(driver().getTitle().equalsIgnoreCase(SITE_TITLE),
                "Site title not equals to expected.");
        System.out.println("Site opening done");
    }
}
