package scenarios;

import enums.PropertyFile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.DriverSetup;

import java.io.IOException;

@Test(groups = {"native", "web"})
public class Hooks extends DriverSetup {
    /**
     * Required variables will be initialized by inherited constructor
     *
     * @param propertyFile property file depending on application type (native/web)
     * @throws IOException
     */
    Hooks(PropertyFile propertyFile) throws IOException {
        super(propertyFile);
    }

    /**
     * Preparing driver for running concrete test: web/native.
     * Singletone-style.
     *
     * @throws Exception if Unknown mobile platform
     */
    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver();
    }

    /**
     * Closing driver on all tests completion.
     *
     * @throws Exception
     */
    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
    }
}
