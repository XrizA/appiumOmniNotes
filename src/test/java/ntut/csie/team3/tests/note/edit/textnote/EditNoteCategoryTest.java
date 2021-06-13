package ntut.csie.team3.tests.note.edit.textnote;

import io.appium.java_client.MobileElement;
import ntut.csie.team3.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditNoteCategoryTest extends AbstractTest {

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

        MobileElement categoryCount = driver.findElementById("it.feio.android.omninotes:id/count");
        assertEquals("1", categoryCount.getText());

        delay(2000);
    }
}
