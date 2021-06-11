package ntut.csie.team3.tests.note.edit.checklist;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnableChecklist extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();

        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement moreOption = driver.findElementByAccessibilityId("更多選項");
        mobileElementClick(moreOption);

        MobileElement enableChecklist = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        mobileElementClick(enableChecklist);
    }

    // TC13
    @Test
    @Order(1)
    public void unableChecklist() throws InterruptedException {
        MobileElement moreOption = driver.findElementByAccessibilityId("更多選項");
        mobileElementClick(moreOption);

        MobileElement unableChecklist = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        mobileElementClick(unableChecklist);

        try {
            MobileElement checkBox = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.CheckBox");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            assertEquals("https://www.seleniumhq.org/exceptions/no_such_element.html", e.getSupportUrl());
        }

        delay(2000);
    }
}
