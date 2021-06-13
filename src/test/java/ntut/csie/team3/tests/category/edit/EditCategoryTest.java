package ntut.csie.team3.tests.category.edit;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditCategoryTest extends AbstractTest {

    private static boolean firstTime = true;

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        if(firstTime) {
            firstTime = false;
            createCategory();
        }
    }

    // TC17-1
    @Test
    @Order(1)
    public void editCategoryWithNoInputAndDefaultColor() throws InterruptedException {
        MobileElement ButtonDrawerOpenId = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(ButtonDrawerOpenId);

        MobileElement drawerCategory = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        longPress(drawerCategory);

        MobileElement categoryTitle = driver.findElementById("it.feio.android.omninotes:id/category_title");
        mobileElementClear(categoryTitle);

        MobileElement save = driver.findElementById("it.feio.android.omninotes:id/save");
        mobileElementClick(save);

        categoryTitle = driver.findElementById("it.feio.android.omninotes:id/category_title");
        assertEquals("標題", categoryTitle.getText());

        delay(2000);
    }


    // TC17-2
    @Test
    @Order(2)
    public void editCategoryWithNoInputAndCustomColor() throws InterruptedException {
        MobileElement ButtonDrawerOpenId = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(ButtonDrawerOpenId);

        MobileElement drawerCategory = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        longPress(drawerCategory);

        MobileElement categoryTitle = driver.findElementById("it.feio.android.omninotes:id/category_title");
        mobileElementClear(categoryTitle);

        MobileElement chooseColor = driver.findElementById("it.feio.android.omninotes:id/color_chooser");
        mobileElementClick(chooseColor);

        MobileElement custom = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultNeutral");
        mobileElementClick(custom);

        MobileElement done = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(done);

        MobileElement save = driver.findElementById("it.feio.android.omninotes:id/save");
        mobileElementClick(save);

        categoryTitle = driver.findElementById("it.feio.android.omninotes:id/category_title");
        assertEquals("標題", categoryTitle.getText());

        delay(2000);
    }

    // TC17-3
    @Test
    @Order(3)
    public void editCategoryWithDefaultColor() throws InterruptedException {
        MobileElement ButtonDrawerOpenId = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(ButtonDrawerOpenId);

        MobileElement drawerCategory = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        longPress(drawerCategory);

        MobileElement categoryTitle = driver.findElementById("it.feio.android.omninotes:id/category_title");
        mobileElementSendKeys(categoryTitle, CATEGORY_TITLE);

        MobileElement save = driver.findElementById("it.feio.android.omninotes:id/save");
        mobileElementClick(save);

        drawerCategory = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        assertEquals(CATEGORY_TITLE, drawerCategory.getText());

        delay(2000);
    }


    // TC17-4
    @Test
    @Order(4)
    public void editCategoryWithCustomColor() throws InterruptedException {
//        MobileElement ButtonDrawerOpenId = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
//        mobileElementClick(ButtonDrawerOpenId);

        MobileElement drawerCategory = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        longPress(drawerCategory);

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

        drawerCategory = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        assertEquals(CATEGORY_TITLE, drawerCategory.getText());

        delay(2000);
    }
}
