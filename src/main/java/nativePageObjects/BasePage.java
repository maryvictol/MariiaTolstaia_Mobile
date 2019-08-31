package nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


@Getter
public class BasePage {
    AppiumDriver driver;

    final static String NAME_PACKAGE = "com.example.android.contactmanager:id/";

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = NAME_PACKAGE + "addContactButton")
    private MobileElement addContactButton;

    @AndroidFindBy(id = "android:id/title")
    private MobileElement appTitle;

    public BasePage checkApplicationTitle(String title) {
        assertEquals(appTitle.getText(), title);
        return this;
    }

    /**
     * Check that Add Contact button is displayed and enabled
     *
     * @return
     */
    public BasePage checkAddContactButtonIsDisplayed() {
        assertTrue(addContactButton.isDisplayed(), "Add Contact button isn't displayed");
        assertTrue(addContactButton.isEnabled(), "Add Contact button isn't enabled");
        return this;
    }

    public BasePage pushAddContactButton() {
        addContactButton.click();
        return this;
    }
}
