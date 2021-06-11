package ntut.csie.team3.tests.checklist;

import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ntut.csie.team3.AbstractTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnableChecklist extends AbstractTest{

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

        MobileElement moreOption = driver.findElementByAccessibilityId("更多選項");
        mobileElementClick(moreOption);

        MobileElement enableChecklist = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        mobileElementClick(enableChecklist);

        MobileElement checkBox = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.CheckBox");
        assertEquals(true, checkBox.isDisplayed());

        delay(2000);
    }
}
