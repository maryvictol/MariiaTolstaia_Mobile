package nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

import static nativePageObjects.BasePage.NAME_PACKAGE;
import static org.testng.Assert.assertTrue;

@Getter
public class AddContactPage {
    public AddContactPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = NAME_PACKAGE + "accountSpinner")
    private MobileElement targetAccountField;

    @AndroidFindBy(id = NAME_PACKAGE + "contactNameEditText")
    private MobileElement contactNameField;

    @AndroidFindBy(id = NAME_PACKAGE + "contactPhoneEditText")
    private MobileElement contactPhoneField;

    @AndroidFindBy(id = NAME_PACKAGE + "contactPhoneTypeSpinner")
    private MobileElement contactPhoneTypeSpinner;

    @AndroidFindBy(id = NAME_PACKAGE + "contactEmailEditText")
    private MobileElement contactEmailField;

    @AndroidFindBy(id = NAME_PACKAGE + "contactEmailTypeSpinner")
    private MobileElement contactEmailTypeSpinner;

    @AndroidFindBy(id = NAME_PACKAGE + "contactSaveButton")
    private MobileElement contactSaveButton;

    /**
     * Check element existence by Id
     *
     * @param element Mobile element Id
     * @throws Exception if element Id doesn't exist
     */
    public void checkPageElement(MobileElement element) throws Exception {
        assertTrue(element.isDisplayed(), "Element isn't found");
    }

    public void checkAddContactPageElements() throws Exception {
        checkPageElement(targetAccountField);
        checkPageElement(contactNameField);
        checkPageElement(contactPhoneField);
        checkPageElement(contactPhoneTypeSpinner);
        checkPageElement(contactEmailField);
        checkPageElement(contactEmailTypeSpinner);
        checkPageElement(contactSaveButton);
    }
}
