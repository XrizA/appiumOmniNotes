package ntut.csie.team3.tests.note.trash.clear;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClearTrashTest extends AbstractTest {
    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();
        moveNotesToTrash();
    }

    // TC08-1
    @Test
    @Order(1)
    public void clearTrashTest() throws InterruptedException {
        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        MobileElement moveNotesToTrash = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/drawer_nav_list']//android.widget.LinearLayout[2]");
        mobileElementClick(moveNotesToTrash);

        MobileElement moreOptions = driver.findElementByAccessibilityId("更多選項");
        mobileElementClick(moreOptions);

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.TextView");
        mobileElementClick(editTextList.get(1));

        MobileElement enterButton = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(enterButton);

        MobileElement alertMessage = driver.findElementById("it.feio.android.omninotes:id/crouton_handle");
        assertNotNull(alertMessage);

        MobileElement textView = driver.findElementById("it.feio.android.omninotes:id/empty_list");
        assertEquals("這裡甚麼都沒有！", textView.getText());

        gotoHomePage();
    }
}
