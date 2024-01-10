package test.ru.diary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.base.BaseTest;

public class FirstClass extends BaseTest {

    @Test
    public void firstTest() throws InterruptedException {
        basePage.open("https://diary.ru/user/registration");
        diaryPage.enteringEMail("testnumberone@test.com")
                .clickSubmit();
        Assertions.assertEquals("Регистрация — @дневники: асоциальная сеть", driver.getTitle());
        Assertions.assertEquals("https://diary.ru/user/registration", driver.getCurrentUrl());
        Assertions.assertEquals("Нажимая кнопку «Зарегистрироваться», я принимаю правила ресурса", diaryPage.checkBoxText());
        Assertions.assertEquals("Необходимо заполнить «Логин».",diaryPage.checkErrorText());
     }
}
