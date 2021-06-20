package ntut.csie.team3.tests.note.create.textnote;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTextNoteTest extends AbstractTest {
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

        moveNotesToTrash();
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

        moveNotesToTrash();
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

        moveNotesToTrash();
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

        MobileElement textView = driver.findElementById("it.feio.android.omninotes:id/empty_list");
        assertEquals("這裡甚麼都沒有！", textView.getText());

        clearTrash();
        gotoHomePage();
    }
}
