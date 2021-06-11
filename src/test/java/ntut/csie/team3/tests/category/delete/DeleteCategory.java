package ntut.csie.team3.tests.category.delete;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteCategory extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createCategory();
    }

    // TC18
    @Test
    @Order(1)
    public void deleteCategory() throws InterruptedException {
        MobileElement ButtonDrawerOpenId = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(ButtonDrawerOpenId);

        MobileElement drawerCategory = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        longPress(drawerCategory);

        MobileElement categoryTitle = driver.findElementById("it.feio.android.omninotes:id/category_title");
        mobileElementClear(categoryTitle);

        MobileElement delete = driver.findElementById("it.feio.android.omninotes:id/delete");
        mobileElementClick(delete);

        MobileElement defaultPositive = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultPositive");
        mobileElementClick(defaultPositive);

        try {
            drawerCategory = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            assertEquals("https://www.seleniumhq.org/exceptions/no_such_element.html", e.getSupportUrl());
        }

        delay(2000);
    }
}
