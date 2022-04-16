package ru.diary;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstClass {
    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://diary.ru/user/registration");

        driver.findElement(By.id("signupform-email")).sendKeys("testnumberone@test.com");

        driver.findElement(By.id("signup_btn")).click();
        // проверка заголовка страницы
        String s = driver.getTitle();
        Assertions.assertEquals("Регистрация — @дневники: асоциальная сеть", s);
        // проверка url
        String s1 = driver.getCurrentUrl();
        Assertions.assertEquals("https://diary.ru/user/registration", s1);
        // проверка, что под полем чекбокс есть информационное сообщение "№"Нажимая кнопку..."
        WebElement checkbox = driver.findElement(By.id("chk_box_user_confirm"));
        WebElement checkboxParent = checkbox.findElement(By.xpath(".."));
        String str = checkboxParent.findElement(By.cssSelector("small")).getText();
        Assertions.assertEquals(str, "Нажимая кнопку «Зарегистрироваться», я принимаю правила ресурса");
        // проверка, что под полем логин появилось сообщение о необходимости его заполнить
        WebElement login = driver.findElement(By.id("signupform-username"));
        WebElement loginParent = login.findElement(By.xpath(".."));
        String st = loginParent.findElement(By.cssSelector("p")).getText();
        Assertions.assertEquals(st,"Необходимо заполнить «Логин».");
        driver.quit();
    }
}
