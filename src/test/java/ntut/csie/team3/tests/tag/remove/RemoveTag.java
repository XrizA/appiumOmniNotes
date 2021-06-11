package ntut.csie.team3.tests.tag.remove;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveTag extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();
        createTag();
        createTextNote();
    }

    // TC23-1
    @Test
    @Order(1)
    public void removeTagInNewTextNote() throws InterruptedException {

        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement createTag = driver.findElementByAccessibilityId(BUTTON_NEW_TAG_ID);
        mobileElementClick(createTag);


        MobileElement checkbox = driver.findElementById("it.feio.android.omninotes:id/control");
        mobileElementClick(checkbox);

        MobileElement complete = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(complete);

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        createTag = driver.findElementByAccessibilityId(BUTTON_NEW_TAG_ID);
        mobileElementClick(createTag);

        checkbox = driver.findElementById("it.feio.android.omninotes:id/control");
        mobileElementClick(checkbox);

        complete = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(complete);

        MobileElement editDetailContent = driver.findElementById(EDIT_DETAIL_CONTENT_ID);
        assertEquals("123456789 ", editDetailContent.getText());

        delay(2000);
    }

}
