package ntut.csie.team3.tests.tag.add;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTag extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();
        createTag();
        createTextNote();
    }

    // TC22-1
    @Test
    @Order(1)
    public void addTagInNewTextNote() throws InterruptedException {

//        List<AndroidElement> tagList = driver.findElementsByClassName("android.widget.LinearLayout");
//        tagList.get(1).click();

        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement createTag = driver.findElementByAccessibilityId(BUTTON_NEW_TAG_ID);
        mobileElementClick(createTag);

        MobileElement checkbox = driver.findElementById("it.feio.android.omninotes:id/control");
        mobileElementClick(checkbox);
        MobileElement complete = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(complete);

        MobileElement editDetailContent = driver.findElementById(EDIT_DETAIL_CONTENT_ID);
        assertEquals("123456789\n" +
                "\n" +
                "#已完成", editDetailContent.getText());

        delay(2000);
    }


}
