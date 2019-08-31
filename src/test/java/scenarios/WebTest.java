package scenarios;

import enums.PropertyFile;
import org.apache.http.HttpStatus;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Tests for web application
 */
@Test(groups = {"web"})
public class WebTest extends Hooks {
    protected WebTest() throws IOException {
        super(PropertyFile.WEB);
    }

    @Test(description = "Open website")
    public void simplestTest() throws Exception {
        driver().get(SUT);
        checkStatus();
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        assertTrue(driver().getTitle().equalsIgnoreCase(SITE_TITLE),
                "Site title not equals to expected.");

        System.out.println("Site opening done");
    }

    /**
     * Check URL Status using HTTP APIs
     *
     * @throws Exception
     */
    public void checkStatus() throws Exception {
        URL url = new URL(SUT);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        assertEquals(conn.getResponseCode(), HttpStatus.SC_OK,
                "HTTP error code: " + conn.getResponseCode());
    }
}
