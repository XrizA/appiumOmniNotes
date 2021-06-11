package ntut.csie.team3.tests.tag.delete;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeleteTag extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();
        createTag();
    }

    // TC25-1
    @Test
    @Order(1)
    public void deleteTagInNewTextNote() throws InterruptedException {

        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement editDetailContent = driver.findElementById(EDIT_DETAIL_CONTENT_ID);
        String editDetailContentText = editDetailContent.getText();
        editDetailContentText =  editDetailContentText.substring(0, editDetailContentText.indexOf("#"));
        mobileElementSendKeys(editDetailContent, editDetailContentText);

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement createTag = driver.findElementByAccessibilityId(BUTTON_NEW_TAG_ID);
        mobileElementClick(createTag);

        MobileElement croutonHandle = driver.findElementById("it.feio.android.omninotes:id/crouton_handle");
        assertNotNull(croutonHandle);

        delay(2000);
    }
}
