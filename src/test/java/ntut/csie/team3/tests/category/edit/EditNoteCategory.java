package ntut.csie.team3.tests.category.edit;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditNoteCategory extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createCategory();
    }

    // TC19
    @Test
    @Order(1)
    public void editNoteCategory() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        longPress(cardLayout);

        MobileElement menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);

        MobileElement categoryList = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
        mobileElementClick(categoryList);

        cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        longPress(cardLayout);

        menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);

        MobileElement categoryCount = driver.findElementById("it.feio.android.omninotes:id/count");
        assertEquals("1", categoryCount.getText());

        delay(2000);
    }
}
