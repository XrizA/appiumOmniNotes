package ntut.csie.team3.note.edit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditChecklistNoteContent extends AbstractTest {
    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createChecklistNote();
    }

    // TC11-1
    @Test
    @Order(1)
    public void editChecklistNoteContentWithInputContent() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.EditText");
        mobileElementClick(editTextList.get(1));
        mobileElementClear(editTextList.get(1));
        String expected = "測試輸入項目100內容";
        mobileElementSendKeys(editTextList.get(1), expected);
        assertEquals(expected, editTextList.get(1).getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    // TC11-4
    @Test
    @Order(4)
    public void editChecklistNoteContentWithItemDelete() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.EditText");
        // 有一個是筆記標題，所以要減1
        int expected = editTextList.size() - 1;

        MobileElement editTextItemContent = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.EditText");
        mobileElementClick(editTextItemContent);

        MobileElement imageViewItemDelete = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.ImageView[2]");
        mobileElementClick(imageViewItemDelete);
        expected -= 1;

        editTextList = driver.findElementsByClassName("android.widget.EditText");
        // 有一個是筆記標題，所以要減1
        assertEquals(expected, editTextList.size() - 1);

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    // TC11-5
    @Test
    @Order(5)
    public void editChecklistNoteContentWithNewItem() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.EditText");
        mobileElementClick(editTextList.get(2));
        mobileElementClear(editTextList.get(2));
        String expected = "測試輸入項目2內容";
        mobileElementSendKeys(editTextList.get(2), expected);
        assertEquals(expected, editTextList.get(2).getText());

        expected = "測試輸入項目3內容";
        mobileElementClick(editTextList.get(2));
        mobileElementClear(editTextList.get(2));
        mobileElementSendKeys(editTextList.get(2), expected);
        assertEquals(expected, editTextList.get(2).getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    // TC11-6
    @Test
    @Order(6)
    public void editChecklistNoteWithNoInputContent() throws InterruptedException {

        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, "測試輸入標題");
        assertEquals("測試輸入標題", editDetailTitle.getText());

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.EditText");
        mobileElementClick(editTextList.get(1));
        mobileElementClear(editTextList.get(1));
        assertEquals(EMPTY_STRING, editTextList.get(1).getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }
}
