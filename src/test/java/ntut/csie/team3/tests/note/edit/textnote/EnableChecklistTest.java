package ntut.csie.team3.tests.note.edit.textnote;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnableChecklistTest extends AbstractTest{

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();
    }

    // TC12
    @Test
    @Order(1)
    public void enableChecklist() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement moreOption = driver.findElementByAccessibilityId(BUTTON_OPTIONS_ID);
        mobileElementClick(moreOption);

        MobileElement enableChecklist = driver.findElementByXPath("//android.widget.ListView//android.widget.LinearLayout[1]");
        mobileElementClick(enableChecklist);

        MobileElement checkbox = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.CheckBox");
        assertTrue(checkbox.isDisplayed());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }
}
