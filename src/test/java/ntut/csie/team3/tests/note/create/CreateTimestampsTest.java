package ntut.csie.team3.tests.note.create;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateTimestampsTest extends AbstractTest {

    // TC26
    @Test
    @Order(1)
    public void createTimestamps() throws InterruptedException {
        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabNote = driver.findElementById(BUTTON_FAB_NOTE_ID);
        mobileElementClick(buttonFabNote);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, NOTE_TITLE);
        assertEquals(NOTE_TITLE, editDetailTitle.getText());

        MobileElement editDetailContent = driver.findElementById(EDIT_DETAIL_CONTENT_ID);
        editDetailContent.click();

        MobileElement menuAttachment = driver.findElementById(MENU_ATTACHMENT_ID);
        mobileElementClick(menuAttachment);

        MobileElement timestamps = driver.findElementById(TIMESTAMPS_ID);
        mobileElementClick(timestamps);

        assertNotNull(editDetailContent.getText());

        goBack();
        moveNotesToTrash();
        gotoTrashPage();
        clickClearTrash();
        gotoHomePage();
    }
}
