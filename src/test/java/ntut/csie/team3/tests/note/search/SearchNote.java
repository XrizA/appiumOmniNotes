package ntut.csie.team3.tests.note.search;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchNote extends AbstractTest {

    private static boolean firstTime = true;

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        if(firstTime){
            firstTime = false;
            createTextNote("歷史課", "課程");
            createTextNote("數學課", "考試");
            createTextNote("榜單", "查詢");
        }
    }

    // TC27-1
    @Test
    @Order(1)
    public void searchTextNoteWithOKInput() throws InterruptedException {

        MobileElement search = driver.findElementByAccessibilityId("搜尋");
        mobileElementClick(search);
        MobileElement searchContent = (MobileElement) driver.findElementById("it.feio.android.omninotes:id/search_src_text");
        mobileElementSendKeys(searchContent, "榜\\n");
        MobileElement noteTitle = driver.findElementById("it.feio.android.omninotes:id/note_title");
        assertEquals("榜單", noteTitle.getText());

        MobileElement close = (MobileElement) driver.findElementByAccessibilityId("收合");
        mobileElementClick(close);

        delay(2000);
    }

    // TC27-2 ???
    @Test
    @Order(2)
    public void searchTextNoteWithNOInput() throws InterruptedException {

        MobileElement search = driver.findElementByAccessibilityId("搜尋");
        mobileElementClick(search);
        MobileElement searchContent = (MobileElement) driver.findElementById("it.feio.android.omninotes:id/search_src_text");
        mobileElementSendKeys(searchContent, "\\n");
        MobileElement noteTitle = driver.findElementById("it.feio.android.omninotes:id/note_title");
        assertEquals("數學課", noteTitle.getText());

        MobileElement close = (MobileElement) driver.findElementByAccessibilityId("收合");
        mobileElementClick(close);

        delay(2000);
    }

}