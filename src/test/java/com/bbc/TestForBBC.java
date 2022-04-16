package com.bbc;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;



public class TestForBBC {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test
    public void firstTest() {
        //Шаг 1. Зайти на главную страницу сайта
        driver.get("https://www.bbc.com/");

        /*
        Здесь я совместила ожидаемый результат к шагу 1 - ожидается
        вкладка  "Sign in"  в верхней части экрана на панели навигации - и выполнила сразу шаг 2 - кликнуть на него
        */
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='idcta-username']"))).click();
        //Ожидаемый результат к шагу 2 - нахождение на странице авторизации, привязалась к приветственной фразе
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='signin-page']//h1/span"), "Снова здравствуйте"));
        //Шаг 3 - ввести валидные данные и шаг 4 - кликнуть "Войти"
        driver.findElement(By.id("user-identifier-input")).sendKeys("li-ma@mail.ru");
        driver.findElement(By.id("password-input")).sendKeys("R4e3w2Q1");
        driver.findElement(By.id("submit-button")).click();
        // Ожидаемый результат - переход на главную страницу сайта и отображение вкладки "Your account"
        String str = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.bbc.com/", str);
        String s = driver.findElement(By.id("idcta-username")).getText();
        Assertions.assertEquals("Your account", s);
    }
    @Test
    public void secondTest() {
        //Шаг 1. Зайти на главную страницу сайта
        driver.get("https://www.bbc.com/");
        /*
        Опять же совместила ожидаемый результат к шагу 1 - ожидается
        вкладка  "Sign in"  в верхней части экрана на панели навигации - и выполнила сразу шаг 2 - кликнуть на него
        */
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='idcta-username']"))).click();
        //Ожидаемый результат к шагу 2 - нахождение на странице авторизации, привязалась к приветственной фразе
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='signin-page']//h1/span"), "Снова здравствуйте"));
        //Шаг 3 - ввести валидную почту и невалидный пароль и шаг 4 - кликнуть "Войти"
        driver.findElement(By.id("user-identifier-input")).sendKeys("li-ma@mail.ru");
        driver.findElement(By.id("password-input")).sendKeys("R4e3w2Q2");
        driver.findElement(By.id("submit-button")).click();
        /*
        Ожидаемый результат - под полем пароля отображается сообщение
        "Uh oh, that password doesn’t match that account. Please try again."
        */
        String str = driver.findElement(By.xpath("//*[@id='form-message-password']/p/span/span")).getText();
        Assertions.assertEquals("Uh oh, that password doesn’t match that account. Please try again.", str);
    }
    @AfterEach
    public void close() {
        driver.quit();
    }
}
