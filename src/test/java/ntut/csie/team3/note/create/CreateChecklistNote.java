package ntut.csie.team3.note.create;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateChecklistNote extends AbstractTest {

    // TC02-1
    @Test
    @Order(1)
    public void createChecklistNoteTest() throws InterruptedException {
        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabChecklistNote = driver.findElementById(BUTTON_FAB_CHECKLIST_NOTE_ID);
        mobileElementClick(buttonFabChecklistNote);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, "測試輸入標題");
        assertEquals("測試輸入標題", editDetailTitle.getText());

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.EditText");
        mobileElementClick(editTextList.get(1));
        mobileElementClear(editTextList.get(1));
        mobileElementSendKeys(editTextList.get(1), "測試輸入項目1內容");
        assertEquals("測試輸入項目1內容", editTextList.get(1).getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    // TC02-2
    @Test
    @Order(2)
    public void createChecklistNoteWithNoInputTitle() throws InterruptedException {


        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabChecklistNote = driver.findElementById(BUTTON_FAB_CHECKLIST_NOTE_ID);
        mobileElementClick(buttonFabChecklistNote);

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.EditText");
        mobileElementClick(editTextList.get(1));
        mobileElementClear(editTextList.get(1));
        mobileElementSendKeys(editTextList.get(1), "測試輸入項目1內容");
        assertEquals("測試輸入項目1內容", editTextList.get(1).getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    // TC02-3
    @Test
    @Order(3)
    public void createChecklistNoteWithNoInputContent() throws InterruptedException {


        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabChecklistNote = driver.findElementById(BUTTON_FAB_CHECKLIST_NOTE_ID);
        mobileElementClick(buttonFabChecklistNote);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, "測試輸入標題");
        assertEquals("測試輸入標題", editDetailTitle.getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    // TC02-4
    @Test
    @Order(4)
    public void createChecklistNoteWithNoInputTitleAndContent() throws InterruptedException {

        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabChecklistNote = driver.findElementById(BUTTON_FAB_CHECKLIST_NOTE_ID);
        mobileElementClick(buttonFabChecklistNote);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, "測試輸入標題");
        assertEquals("測試輸入標題", editDetailTitle.getText());

        String expected = "";
        for (int i = 1; i <= 3; i++){
            List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.EditText");
            mobileElementClick(editTextList.get(i));
            mobileElementClear(editTextList.get(i));
            expected = "測試輸入項目" + i + "內容";
            mobileElementSendKeys(editTextList.get(i), expected);
            assertEquals(expected, editTextList.get(i).getText());
        }


        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.CheckBox");
        mobileElementClick(editTextList.get(0));

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    // TC-02-5
    @Test
    @Order(5)
    public void createChecklistNoteWithInputTitleAndContent() throws InterruptedException {

        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabChecklistNote = driver.findElementById(BUTTON_FAB_CHECKLIST_NOTE_ID);
        mobileElementClick(buttonFabChecklistNote);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, "測試輸入標題");
        assertEquals("測試輸入標題", editDetailTitle.getText());

        String expected = "";
        for (int i = 1; i <= 3; i++){
            List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.EditText");
            mobileElementClick(editTextList.get(i));
            mobileElementClear(editTextList.get(i));
            expected = "測試輸入項目" + i + "內容";
            mobileElementSendKeys(editTextList.get(i), expected);
            assertEquals(expected, editTextList.get(i).getText());
        }

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    // TC-02-6
    @Test
    @Order(6)
    public void createChecklistNoteWithInputTitle() throws InterruptedException {

        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabChecklistNote = driver.findElementById(BUTTON_FAB_CHECKLIST_NOTE_ID);
        mobileElementClick(buttonFabChecklistNote);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, "測試輸入標題");
        assertEquals("測試輸入標題", editDetailTitle.getText());

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.EditText");
        mobileElementClick(editTextList.get(1));
        mobileElementClear(editTextList.get(1));
        mobileElementSendKeys(editTextList.get(1), "測試輸入項目1內容");
        mobileElementClear(editTextList.get(1));
        assertEquals(EMPTY_STRING, editTextList.get(1).getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }
}
