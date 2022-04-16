package test.com.andersenlab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.base.BaseTest;
import java.awt.*;

public class TestForAndersenlab extends BaseTest {

    @Test
    public void checkingRedirectAndCloseSkype() throws InterruptedException, AWTException {
        basePage.open("https://andersenlab.com/");
        andersenLabPage
                .clickAcceptCookies()
                .clickIconSkype();
        basePage.switchSecondTab();
        basePage.clickEnter();
        Assertions.assertEquals("https://join.skype.com/aM8R4P4dNJdy", driver.getCurrentUrl());
    }

    @Test
    public void checkingRedirectToJavaDevPage() throws InterruptedException {
        basePage.open("https://andersenlab.com/");
        andersenLabPage
                .clickAcceptCookies()
                .clickOnDropdownTechStackAndJava();
        Assertions.assertEquals("https://andersenlab.com/find-developers/java", driver.getCurrentUrl());
    }
}

