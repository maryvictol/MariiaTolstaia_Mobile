package scenarios;

import enums.PropertyFile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.DriverSetup;

import java.io.IOException;


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
    @BeforeSuite(groups = {"native", "web"}, description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver();
    }

    /**
     * Closing driver on all tests completion.
     *
     * @throws Exception
     */
    @AfterSuite(groups = {"web"}, description = "Close driver on all tests completion")
    public void tearDownWeb() throws Exception {
        driver().close();
    }

    /**
     * Closing driver on all tests completion.
     *
     * @throws Exception
     */
    @AfterSuite(groups = {"native"}, description = "Close driver on all tests completion")
    public void tearDownNative() throws Exception {
        driver().closeApp();
    }
}
