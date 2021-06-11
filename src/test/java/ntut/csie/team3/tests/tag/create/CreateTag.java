package ntut.csie.team3.tests.tag.create;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateTag extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();
    }

    // TC21-1
    @Test
    @Order(1)
    public void createTagWithInputLongLessOne() throws InterruptedException {

        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement editDetailContent = (MobileElement) driver.findElementById(EDIT_DETAIL_CONTENT_ID);
        String editDetailContentText = editDetailContent.getText();
        editDetailContent.sendKeys(editDetailContentText + "#好");

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement createTag = driver.findElementByAccessibilityId(BUTTON_NEW_TAG_ID);
        mobileElementClick(createTag);

        MobileElement croutonHandle = driver.findElementById("it.feio.android.omninotes:id/crouton_handle");
        assertNotNull(croutonHandle);

        buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }


    // TC21-2
    @Test
    @Order(2)
    public void createTagWithInputLongMoreThanTwo() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement editDetailContent = (MobileElement) driver.findElementById(EDIT_DETAIL_CONTENT_ID);
        String editDetailContentText = editDetailContent.getText();
        mobileElementSendKeys(editDetailContent, editDetailContentText + "#已完成");

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement createTag = driver.findElementByAccessibilityId(BUTTON_NEW_TAG_ID);
        mobileElementClick(createTag);

        List<AndroidElement> tagList = driver.findElementsByClassName("android.widget.TextView");
        assertEquals("已完成 (1)", tagList.get(1).getText());

        MobileElement complete = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(complete);

        buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }
}