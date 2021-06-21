package ntut.csie.team3.tests.note.trash.move;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MoveNotesToTrashTest extends AbstractTest {
    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();
    }

    // TC05-1
    @Test
    @Order(1)
    public void moveNotesToTrashTest() throws InterruptedException {
        MobileElement note = driver.findElementById("it.feio.android.omninotes:id/root");
        mobileElementClick(note);

        MobileElement moreOptions = driver.findElementByAccessibilityId("更多選項");
        mobileElementClick(moreOptions);

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.TextView");
        mobileElementClick(editTextList.get(3));

        MobileElement alertMessage = driver.findElementById("it.feio.android.omninotes:id/crouton_handle");
        assertNotNull(alertMessage);

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        MobileElement moveNotesToTrash = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/drawer_nav_list']//android.widget.LinearLayout[2]");
        mobileElementClick(moveNotesToTrash);

        MobileElement noteTitle = driver.findElementById("it.feio.android.omninotes:id/note_title");
        assertEquals(NOTE_TITLE, noteTitle.getText());

        MobileElement noteContent = driver.findElementById("it.feio.android.omninotes:id/note_content");
        assertEquals(NOTE_CONTENT, noteContent.getText());

        clickClearTrash();
        gotoHomePage();
    }
}
