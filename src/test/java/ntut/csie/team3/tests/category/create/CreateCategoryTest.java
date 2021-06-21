package ntut.csie.team3.tests.category.create;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCategoryTest extends AbstractTest {

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

        goBack();
        clickMoveNotesToTrash();
        clickXY(200, 200);
    }

    // TC16-2
    @Test
    @Order(2)
    public void createCategoryWithNoInputAndCustomColor() throws InterruptedException {
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

        goBack();
        clickMoveNotesToTrash();
        clickXY(200, 200);
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

        cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        longPress(cardLayout);

        menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);
        MobileElement categoryName = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/contentListView']//*//*[@resource-id='it.feio.android.omninotes:id/title']");
        assertEquals(CATEGORY_TITLE, categoryName.getText());

        goBack();
        clickMoveNotesToTrash();
        removeCategory();
        goBack();
    }

    // TC16-4
    @Test
    @Order(4)
    public void createCategoryWithCustomColor() throws InterruptedException {
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

        cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        longPress(cardLayout);

        menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);
        MobileElement categoryName = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/contentListView']//*//*[@resource-id='it.feio.android.omninotes:id/title']");
        assertEquals(CATEGORY_TITLE, categoryName.getText());

        goBack();
        clickMoveNotesToTrash();
        removeCategory();
        clickGotoTrashPage();
        clickClearTrash();
        gotoHomePage();
    }
}
