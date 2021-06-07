package ntut.csie.team3.note.create;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CreateTextNote extends AbstractTest {

    // TC01-1
    @Test
    @Order(1)
    public void createTextNoteTest() throws InterruptedException {
        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabNote = driver.findElementById(BUTTON_FAB_NOTE_ID);
        mobileElementClick(buttonFabNote);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, NOTE_TITLE);
        assertEquals(NOTE_TITLE, editDetailTitle.getText());

        MobileElement editDetailContent = driver.findElementById(EDIT_DETAIL_CONTENT_ID);
        mobileElementSendKeys(editDetailContent, NOTE_CONTENT);
        assertEquals(NOTE_CONTENT, editDetailContent.getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        MobileElement textViewNoteTitle = driver.findElementById(TEXT_VIEW_NOTE_TITLE_ID);
        assertEquals(NOTE_TITLE, textViewNoteTitle.getText());

        MobileElement textViewNoteContent = driver.findElementById(TEXT_VIEW_NOTE_CONTENT_ID);
        assertEquals(NOTE_CONTENT, textViewNoteContent.getText());

        delay(2000);
    }

    // TC01-2
    @Test
    @Order(2)
    public void createTextNoteWithNoInputTitle() throws InterruptedException {
        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabNote = driver.findElementById(BUTTON_FAB_NOTE_ID);
        mobileElementClick(buttonFabNote);

        MobileElement editDetailContent = driver.findElementById(EDIT_DETAIL_CONTENT_ID);
        mobileElementSendKeys(editDetailContent, NOTE_CONTENT);
        assertEquals(NOTE_CONTENT, editDetailContent.getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        MobileElement textViewNoteTitle = driver.findElementById(TEXT_VIEW_NOTE_TITLE_ID);
        assertEquals("", textViewNoteTitle.getText());

        MobileElement textViewNoteContent = driver.findElementById(TEXT_VIEW_NOTE_CONTENT_ID);
        assertEquals(NOTE_CONTENT, textViewNoteContent.getText());

        delay(2000);
    }

    // TC01-3
    @Test
    @Order(3)
    public void createTextNoteWithNoInputContent() throws InterruptedException {
        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabNote = driver.findElementById(BUTTON_FAB_NOTE_ID);
        mobileElementClick(buttonFabNote);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, NOTE_TITLE);
        assertEquals(NOTE_TITLE, editDetailTitle.getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        MobileElement textViewNoteTitle = driver.findElementById(TEXT_VIEW_NOTE_TITLE_ID);
        assertEquals(NOTE_TITLE, textViewNoteTitle.getText());

        delay(1000);
    }

    // TC01-4
    @Test
    public void createTextNoteWithNoInputTitleAndContent() throws InterruptedException {
        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabNote = driver.findElementById(BUTTON_FAB_NOTE_ID);
        mobileElementClick(buttonFabNote);

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        MobileElement statusBar = driver.findElementByXPath(STATUS_BAR_XPATH);
        assertNotNull(statusBar);

//        MobileElement textView = statusBar.findElementByClassName("android.widget.TextView");
//        System.out.print(textView);
//        assertEquals("無法儲存空白筆記", statusBar.getText());

        delay(2000);
    }
}
