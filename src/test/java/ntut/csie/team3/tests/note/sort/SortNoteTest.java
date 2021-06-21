package ntut.csie.team3.tests.note.sort;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortNoteTest extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createTextNote("數學課", "考試");
        createTextNote("歷史課", "課程");
        createTextNote("榜單", "查詢");
    }

    // TC28-1
    @Test
    @Order(1)
    public void sortTextNoteWithTitle() throws InterruptedException {

        MobileElement sort = driver.findElementByAccessibilityId("排序");
        mobileElementClick(sort);

        List<AndroidElement> sortList = driver.findElementsByClassName("android.widget.LinearLayout");
        mobileElementClick(sortList.get(0));

        List<AndroidElement> textViewList = driver.findElementsByClassName("android.widget.TextView");
        assertEquals("數學課", textViewList.get(3).getText());
        assertEquals("榜單", textViewList.get(6).getText());
        assertEquals("歷史課", textViewList.get(9).getText());

        moveNotesToTrash();
        moveNotesToTrash();
        moveNotesToTrash();
    }

    // TC28-2
    @Test
    @Order(2)
    public void sortTextNoteWithCreateTime() throws InterruptedException {


        MobileElement sort = driver.findElementByAccessibilityId("排序");
        mobileElementClick(sort);

        List<AndroidElement> sortList = driver.findElementsByClassName("android.widget.LinearLayout");
        mobileElementClick(sortList.get(2));

        List<AndroidElement> textViewList = driver.findElementsByClassName("android.widget.TextView");
        assertEquals("榜單", textViewList.get(3).getText());
        assertEquals("歷史課", textViewList.get(6).getText());
        assertEquals("數學課", textViewList.get(9).getText());

        moveNotesToTrash();
        moveNotesToTrash();
        moveNotesToTrash();
    }

    // TC28-3
    @Test
    @Order(3)
    public void sortTextNoteWithLastEditTime() throws InterruptedException {
        MobileElement sort = driver.findElementByAccessibilityId("排序");
        mobileElementClick(sort);

        List<AndroidElement> sortList = driver.findElementsByClassName("android.widget.LinearLayout");
        mobileElementClick(sortList.get(4));

        List<AndroidElement> textViewList = driver.findElementsByClassName("android.widget.TextView");
        assertEquals("榜單", textViewList.get(3).getText());
        assertEquals("歷史課", textViewList.get(6).getText());
        assertEquals("數學課", textViewList.get(9).getText());

        moveNotesToTrash();
        moveNotesToTrash();
        moveNotesToTrash();
        gotoTrashPage();
        clickClearTrash();
        gotoHomePage();
    }


}
