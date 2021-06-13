package ntut.csie.team3.tests.note.edit.checklist;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditChecklistNoteContentTest extends AbstractTest {
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

        MobileElement checkbox = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.CheckBox");
        if (checkbox.isSelected()) {
            checkbox.click();
        }

        MobileElement editText = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.EditText");
        mobileElementClick(editText);
        mobileElementClear(editText);
        String expected = "測試輸入項目2內容";
        mobileElementSendKeys(editText, expected);
        assertEquals(expected, editText.getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    // TC11-2
    @Test
    @Order(2)
    public void editChecklistNoteContentWithInputContentAndCancelPartTheCheckbox() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement checkbox = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.CheckBox");
        if (checkbox.isSelected()) {
            checkbox.click();
        }

        MobileElement editText = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.EditText");
        mobileElementClick(editText);
        mobileElementClear(editText);
        String expected = "測試輸入項目3內容";
        mobileElementSendKeys(editText, expected);
        assertEquals(expected, editText.getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    // TC11-3
    @Test
    @Order(3)
    public void editChecklistNoteContentWithInputContentAndTickWholeTheCheckbox() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement checkbox = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.CheckBox");
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        MobileElement editText = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.EditText");
        mobileElementClick(editText);
        mobileElementClear(editText);
        String expected = "測試輸入項目3內容";
        mobileElementSendKeys(editText, expected);
        assertEquals(expected, editText.getText());

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

        MobileElement checkbox = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.CheckBox");
        if (checkbox.isSelected()) {
            checkbox.click();
        }

        List<AndroidElement> editTextList = driver.findElementsByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.EditText");
        int expected = editTextList.size();

        MobileElement editText = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.EditText");
        mobileElementClick(editText);

        MobileElement imageViewItemDelete = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.ImageView[2]");
        mobileElementClick(imageViewItemDelete);
        expected -= 1;

        editTextList = driver.findElementsByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.EditText");
        assertEquals(expected, editTextList.size());

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

        MobileElement checkbox = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.CheckBox");
        if (checkbox.isSelected()) {
            checkbox.click();
        }

        MobileElement editText = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.EditText");
        mobileElementClick(editText);
        mobileElementClear(editText);
        String expected = "測試輸入項目2內容";
        mobileElementSendKeys(editText, expected);
        assertEquals(expected, editText.getText());

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

        MobileElement editText = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/detail_content']//android.widget.LinearLayout[1]//android.widget.LinearLayout//android.widget.EditText");
        mobileElementClick(editText);
        mobileElementClear(editText);
        assertEquals(EMPTY_STRING, editText.getText());

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }
}
