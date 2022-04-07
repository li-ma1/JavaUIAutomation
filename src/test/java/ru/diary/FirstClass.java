package ru.diary;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

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
        Assert.assertTrue(s.equals("Регистрация — @дневники: асоциальная сеть"));
        // проверка url
        String s1 = driver.getCurrentUrl();
        Assert.assertTrue(s1.equals("https://diary.ru/user/registration"));
        // проверка, что под полем чекбокс есть информационное сообщение "№"Нажимая кнопку..."
        WebElement checkbox = driver.findElement(By.id("chk_box_user_confirm"));
        WebElement checkboxParent = checkbox.findElement(By.xpath(".."));
        String str = checkboxParent.findElement(By.cssSelector("small")).getText();
        Assert.assertEquals(str, "Нажимая кнопку «Зарегистрироваться», я принимаю правила ресурса");
        // проверка, что под полем логин появилось сообщение о необходимости его заполнить
        WebElement login = driver.findElement(By.id("signupform-username"));
        WebElement loginParent = login.findElement(By.xpath(".."));
        String st = loginParent.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(st,"Необходимо заполнить «Логин».");
        driver.quit();
    }
}
