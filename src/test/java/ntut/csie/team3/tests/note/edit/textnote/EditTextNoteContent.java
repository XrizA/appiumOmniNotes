package ntut.csie.team3.tests.note.edit.textnote;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditTextNoteContent extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();
    }

    // TC10-1
    @Test
    @Order(1)
    public void editTextNoteContentWithNoInputContent() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement editDetailContent = driver.findElementById(EDIT_DETAIL_CONTENT_ID);
        mobileElementClear(editDetailContent);

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        // 沒有輸入內容的話，沒有Content的欄位
        MobileElement textViewNoteTitle = driver.findElementById(TEXT_VIEW_NOTE_TITLE_ID);
        assertEquals(NOTE_TITLE, textViewNoteTitle.getText());

        delay(2000);
    }

    // TC10-2
    @Test
    @Order(2)
    public void editTextNoteContent() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

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
}
