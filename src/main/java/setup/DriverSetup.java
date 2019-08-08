package setup;

import enums.Device;
import enums.PropertyFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Initialize a driver with test properties
 */
public class DriverSetup extends TestProperties {
    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    protected DesiredCapabilities capabilities;


    // Properties to be read from properties file
    protected String AUT; // (mobile) app under testing
    protected String SUT; // site under testing
    protected String TEST_PLATFORM;
    protected String DRIVER;
    protected String PACKAGE_NAME;
    protected String SITE_TITLE;

    protected Device device;

    /**
     * Constructor initializes properties on driver creation     *
     *
     * @param device       device using for testing
     * @param propertyFile property file depending on application type (native/web)
     * @throws IOException
     */
    protected DriverSetup(Device device, PropertyFile propertyFile) throws IOException {
        super(propertyFile);
        this.device = device;
        AUT = getProperty("aut");
        String t_sut = getProperty("sut");
        SUT = t_sut == null ? null : "http://" + t_sut;
        TEST_PLATFORM = getProperty("platform");
        DRIVER = getProperty("driver");
        PACKAGE_NAME = getProperty("package_name");
        SITE_TITLE = getProperty("siteTitle");
    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application type     *
     *
     * @throws Exception if Unknown mobile platform
     */
    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.toString());
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, web (or hybrid)
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }
        // Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) {
            driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        }
        //Set an object to handle timeouts
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 10);
        }
    }

    /**
     * Get driver instance
     */
    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) {
            prepareDriver();
        }
        return driverSingle;
    }

    /**
     * Get driver wait instance
     */
    protected WebDriverWait driverWait() {
        return waitSingle;
    }
}