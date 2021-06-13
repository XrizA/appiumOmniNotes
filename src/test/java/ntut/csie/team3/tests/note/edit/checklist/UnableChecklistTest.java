package ntut.csie.team3.tests.note.edit.checklist;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnableChecklistTest extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();

        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement moreOption = driver.findElementByAccessibilityId(BUTTON_OPTIONS_ID);
        mobileElementClick(moreOption);

        MobileElement enableChecklist = driver.findElementByXPath("//android.widget.ListView//android.widget.LinearLayout[1]");
        mobileElementClick(enableChecklist);
    }

    // TC13
    @Test
    @Order(1)
    public void unableChecklist() throws InterruptedException {
        MobileElement moreOption = driver.findElementByAccessibilityId(BUTTON_OPTIONS_ID);
        mobileElementClick(moreOption);

        MobileElement unableChecklist = driver.findElementByXPath("//android.widget.ListView//android.widget.LinearLayout[1]");
        mobileElementClick(unableChecklist);

        try {
            MobileElement checkBox = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.CheckBox");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            assertEquals("https://www.seleniumhq.org/exceptions/no_such_element.html", e.getSupportUrl());
        }

        delay(2000);
    }
}
