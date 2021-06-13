package ntut.csie.team3.tests.note.delete.textnote;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteNoteCategoryTest extends AbstractTest {

    @BeforeEach
    public void init() throws InterruptedException {
        super.init();
        createCategory();
    }

    // TC20
    @Test
    @Order(1)
    public void deleteNoteCategory() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        longPress(cardLayout);

        MobileElement menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);

        MobileElement deleteCategory = driver.findElementById("it.feio.android.omninotes:id/buttonDefaultNegative");
        mobileElementClick(deleteCategory);

        cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        longPress(cardLayout);

        menuCategory = driver.findElementById(MENU_CATEGORY_ID);
        mobileElementClick(menuCategory);

        MobileElement categoryCount = driver.findElementById("it.feio.android.omninotes:id/count");
        assertEquals("0", categoryCount.getText());

        delay(2000);
    }
}
