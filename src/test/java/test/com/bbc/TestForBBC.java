package test.com.bbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.base.BaseTest;

public class TestForBBC extends BaseTest {

    @Test
    public void enterValidLoginAndPassword() throws InterruptedException {
        basePage.open("https://www.bbc.com/");
        Assertions.assertEquals("Снова здравствуйте", bbcPage.clickOnSignIn());
        bbcPage .enteringLogin("li-ma@mail.ru")
                .enteringPassword("R4e3w2Q1")
                .clickSubmit();
        Assertions.assertEquals("https://www.bbc.com/", driver.getCurrentUrl());
        Assertions.assertEquals("Your account", bbcPage.checkIconYourAccount());
    }
    @Test
    public void enterValidLoginAndInvalidPassword() throws InterruptedException {
        basePage.open("https://www.bbc.com/");
        Assertions.assertEquals("Снова здравствуйте", bbcPage.clickOnSignIn());
        bbcPage .enteringLogin("li-ma@mail.ru")
                .enteringPassword("R4e3w2Q2")
                .clickSubmit();
        Assertions.assertEquals("Uh oh, that password doesn’t match that account. Please try again.", bbcPage.checkErrorText());
    }
}

