package ntut.csie.team3;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.jupiter.api.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class AbstractTest {

    public final static String DEVICE_NAME = "192.168.118.106:5555";
    public final static String APP_NAME = "app.apk";
    public static AndroidDriver<AndroidElement> driver;
    public final static String REMOTE_URL = "http://localhost:4723/wd/hub";

    public final static String MENU_ATTACHMENT_ID= "it.feio.android.omninotes:id/menu_attachment";
    public final static String MENU_CATEGORY_ID = "it.feio.android.omninotes:id/menu_category";
    public final static String TIMESTAMPS_ID = "it.feio.android.omninotes:id/timestamp";
    public final static String CARD_LAYOUT_ID = "it.feio.android.omninotes:id/card_layout";
    public final static String BUTTON_NEXT_ID = "it.feio.android.omninotes:id/next";
    public final static String BUTTON_DONE_ID = "it.feio.android.omninotes:id/done";
    public final static String BUTTON_MENU_ID = "it.feio.android.omninotes:id/fab_expand_menu_button";
    public final static String BUTTON_FAB_NOTE_ID = "it.feio.android.omninotes:id/fab_note";
    public final static String BUTTON_FAB_CHECKLIST_NOTE_ID = "it.feio.android.omninotes:id/fab_checklist";
    public final static String EDIT_DETAIL_TITLE_ID = "it.feio.android.omninotes:id/detail_title";
    public final static String EDIT_DETAIL_CONTENT_ID = "it.feio.android.omninotes:id/detail_content";
    public final static String TEXT_VIEW_NOTE_TITLE_ID = "it.feio.android.omninotes:id/note_title";
    public final static String TEXT_VIEW_NOTE_CONTENT_ID = "it.feio.android.omninotes:id/note_content";
    public final static String NOTE_TITLE = "歷史課";
    public final static String NOTE_CONTENT = "123456789";
    public final static String CATEGORY_TITLE = "課程";
    public final static String EMPTY_STRING = "";
    public final static String BUTTON_DRAWER_OPEN_ID = "開啟側邊欄";
    public final static String BUTTON_NEW_TAG_ID = "新增標籤";

    private final static String CURRENT_PATH = System.getProperty("user.dir");

    @BeforeEach
    public void init() throws InterruptedException {
        if (!driver.currentActivity().equals(".MainActivity")) {
            driver.startActivity(new Activity("it.feio.android.omninotes", ".MainActivity"));
        }
    }

    @BeforeAll
    public static void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, String.format("%s\\%s", CURRENT_PATH, APP_NAME));
//        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "*");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.ENSURE_WEBVIEWS_HAVE_PAGES, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, true);

        driver = new AndroidDriver<>(new URL(REMOTE_URL), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        if (driver.currentActivity().equals(".intro.IntroActivity")) {
            MobileElement buttonNext = driver.findElementById(BUTTON_NEXT_ID);
            for (int i = 0; i < 5; i++)
                mobileElementClick(buttonNext);

            MobileElement buttonDone = driver.findElementById(BUTTON_DONE_ID);
            mobileElementClick(buttonDone);
        }
    }

    public static void mobileElementClick(MobileElement mobileElement) throws InterruptedException {
        mobileElement.click();
        delay(1000);
    }

    public static void mobileElementSendKeys(MobileElement mobileElement, String input) throws InterruptedException {
        mobileElement.sendKeys(input);
        delay(1000);
    }

    public static void mobileElementClear(MobileElement mobileElement) throws InterruptedException {
        mobileElement.clear();
    }

    public static void longPress(MobileElement element) throws InterruptedException {
        MobileElement longPress = (MobileElement) new WebDriverWait(driver, 30).
                until(elementToBeClickable(element));
        new Actions(driver).clickAndHold(longPress).perform();
        delay(2000);
    }

    public static void createTextNote() throws InterruptedException {
        createTextNote(NOTE_TITLE, NOTE_CONTENT);
    }

    public static void createTextNote(String noteTitle, String noteContent) throws InterruptedException {
        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabNote = driver.findElementById(BUTTON_FAB_NOTE_ID);
        mobileElementClick(buttonFabNote);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, noteTitle);

        MobileElement editDetailContent = driver.findElementById(EDIT_DETAIL_CONTENT_ID);
        mobileElementSendKeys(editDetailContent, noteContent);

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    public static void createChecklistNote() throws InterruptedException {
        MobileElement buttonMenu = driver.findElementById(BUTTON_MENU_ID);
        mobileElementClick(buttonMenu);

        MobileElement buttonFabChecklistNote = driver.findElementById(BUTTON_FAB_CHECKLIST_NOTE_ID);
        mobileElementClick(buttonFabChecklistNote);

        MobileElement editDetailTitle = driver.findElementById(EDIT_DETAIL_TITLE_ID);
        mobileElementSendKeys(editDetailTitle, "測試輸入標題");

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.EditText");
        mobileElementClick(editTextList.get(1));
        mobileElementClear(editTextList.get(1));
        mobileElementSendKeys(editTextList.get(1), "測試輸入項目1內容");

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    public static void createCategory() throws InterruptedException {
        createTextNote();

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

        delay(2000);
    }

    public static void archiveNote() throws InterruptedException {
        MobileElement note = driver.findElementById("it.feio.android.omninotes:id/root");
        mobileElementClick(note);

        MobileElement moreOptions = driver.findElementByAccessibilityId("更多選項");
        mobileElementClick(moreOptions);

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.TextView");
        mobileElementClick(editTextList.get(2));

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        MobileElement archiveNote = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/drawer_nav_list']//android.widget.LinearLayout[2]");
        mobileElementClick(archiveNote);

        delay(2000);
    }

    public static void moveNotesToTrash() throws InterruptedException {
        MobileElement note = driver.findElementById("it.feio.android.omninotes:id/root");
        mobileElementClick(note);

        MobileElement moreOptions = driver.findElementByAccessibilityId("更多選項");
        mobileElementClick(moreOptions);

        List<AndroidElement> editTextList = driver.findElementsByClassName("android.widget.TextView");
        mobileElementClick(editTextList.get(3));

        MobileElement alertMessage = driver.findElementById("it.feio.android.omninotes:id/crouton_handle");
        assertNotNull(alertMessage);

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        MobileElement moveNotesToTrash = driver.findElementByXPath("//*[@resource-id='it.feio.android.omninotes:id/drawer_nav_list']//android.widget.LinearLayout[2]");
        mobileElementClick(moveNotesToTrash);

        delay(2000);
    }

    public static void createTag() throws InterruptedException {
        MobileElement cardLayout = driver.findElementById(CARD_LAYOUT_ID);
        mobileElementClick(cardLayout);

        MobileElement editDetailContent = (MobileElement) driver.findElementById(EDIT_DETAIL_CONTENT_ID);
        String editDetailContentText = editDetailContent.getText();
        mobileElementSendKeys(editDetailContent, editDetailContentText + "#已完成");

        MobileElement buttonDrawerOpen = driver.findElementByAccessibilityId(BUTTON_DRAWER_OPEN_ID);
        mobileElementClick(buttonDrawerOpen);

        delay(2000);
    }

    public static void delay(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    @AfterEach
    public void tearDown() {
//        driver.quit();
    }
}
