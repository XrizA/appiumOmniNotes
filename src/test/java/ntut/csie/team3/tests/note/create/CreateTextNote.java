package ntut.csie.team3.tests.note.create;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import ntut.csie.team3.AbstractTest;
import ntut.csie.team3.Note;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateTextNote extends AbstractTest {
    static List<Note> textNotes = new ArrayList<>();

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
        textNotes.add(new Note(NOTE_TITLE, NOTE_CONTENT));

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        assertEquals(NOTE_TITLE, textNotes.get(0).getTitle());
        assertEquals(NOTE_CONTENT, textNotes.get(0).getContent());

        delay(1000);
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
        textNotes.add(new Note("", NOTE_CONTENT));

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        assertEquals(NOTE_CONTENT, textNotes.get(1).getContent());

        delay(1000);
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
        textNotes.add(new Note(NOTE_TITLE, ""));

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        assertEquals(NOTE_TITLE, textNotes.get(2).getTitle());

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

        List<AndroidElement> notes = driver.findElementsById("it.feio.android.omninotes:id/root");
        assertEquals(textNotes.size(), notes.size());

        delay(1000);
    }
}
