package ntut.csie.team3.category.create;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCategory extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote();
    }

    // TC16-1
    @Test
    @Order(1)
    public void createCategoryWithNoInputAndDefaultColor() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);

        longPress(cardLayout);

        MobileElement menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);

        MobileElement createCategory = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(createCategory);

        MobileElement save = driver.findElementById("it.feio.android.omninotes:id/save");
        mobileElementClick(save);

        MobileElement categoryTitle = driver.findElementById("it.feio.android.omninotes:id/category_title");
        assertEquals("標題", categoryTitle.getText());

        delay(2000);
    }

    // TC16-2
    @Test
    @Order(2)
    public void createCategoryWithNoInputAndCustomtColor() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);

        longPress(cardLayout);

        MobileElement menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);

        MobileElement createCategory = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(createCategory);

        MobileElement chooseColor = driver.findElementById("it.feio.android.omninotes:id/color_chooser");
        mobileElementClick(chooseColor);

        MobileElement custom = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultNeutral");
        mobileElementClick(custom);

        MobileElement done = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(done);

        MobileElement save = driver.findElementById("it.feio.android.omninotes:id/save");
        mobileElementClick(save);

        MobileElement categoryTitle = driver.findElementById("it.feio.android.omninotes:id/category_title");
        assertEquals("標題", categoryTitle.getText());

        delay(2000);
    }

    // TC16-3
    @Test
    @Order(3)
    public void createCategoryWithDefaultColor() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);

        longPress(cardLayout);

        MobileElement menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);

        MobileElement createCategory = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(createCategory);

        MobileElement categoryTitle = driver.findElementById("it.feio.android.omninotes:id/category_title");
        mobileElementSendKeys(categoryTitle, CATEGORY_TITLE);

        MobileElement save = driver.findElementById("it.feio.android.omninotes:id/save");
        mobileElementClick(save);

        longPress(cardLayout);

        menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);
        MobileElement categoryName = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
        assertEquals(categoryName.getText(), CATEGORY_TITLE);

        delay(2000);
    }

    // TC16-4
    @Test
    @Order(4)
    public void createCategoryWithCustomtColor() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);

        longPress(cardLayout);

        MobileElement menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);

        MobileElement createCategory = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(createCategory);

        MobileElement categoryTitle = driver.findElementById("it.feio.android.omninotes:id/category_title");
        mobileElementSendKeys(categoryTitle, CATEGORY_TITLE);

        MobileElement chooseColor = driver.findElementById("it.feio.android.omninotes:id/color_chooser");
        mobileElementClick(chooseColor);

        MobileElement custom = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultNeutral");
        mobileElementClick(custom);

        MobileElement done = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(done);

        MobileElement save = driver.findElementById("it.feio.android.omninotes:id/save");
        mobileElementClick(save);

        longPress(cardLayout);

        menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);
        MobileElement categoryName = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
        assertEquals(categoryName.getText(), CATEGORY_TITLE);

        delay(2000);
    }
}
