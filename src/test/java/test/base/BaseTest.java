package test.base;

import common.CommonActions;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.com.AndersenLab;
import pages.com.BBC;
import pages.ru.Diary;

public class BaseTest {
    protected static WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected AndersenLab andersenLabPage = new AndersenLab(driver);
    protected BBC bbcPage = new BBC(driver);
    protected Diary diaryPage = new Diary(driver);

    @AfterEach
    public void closePage() {
        driver.quit();
    }
}
