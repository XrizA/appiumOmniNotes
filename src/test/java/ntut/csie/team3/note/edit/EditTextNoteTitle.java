package ntut.csie.team3.note.edit;

import io.appium.java_client.MobileElement;

import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditTextNoteTitle extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();
    }

    // TC09-1
    @Test
    @Order(1)
    public void editTextNoteTitleWithNoInputTitle() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementClear(editDetailTitle);

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        MobileElement textViewNoteTitle = driver.findElementById(TEXT_VIEW_NOTE_TITLE_ID);
        assertEquals(EMPTY_STRING, textViewNoteTitle.getText());

        delay(2000);
    }

    // TC09-2
    @Test
    @Order(2)
    public void editTextNoteTitle() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, NOTE_TITLE);
        assertEquals(NOTE_TITLE, editDetailTitle.getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        MobileElement textViewNoteTitle = driver.findElementById(TEXT_VIEW_NOTE_TITLE_ID);
        assertEquals(NOTE_TITLE, textViewNoteTitle.getText());

        delay(2000);
    }
}
