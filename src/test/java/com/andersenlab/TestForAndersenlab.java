package com.andersenlab;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class TestForAndersenlab {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void firstTest() throws InterruptedException, AWTException {
        // Зайти на главную страницу сайта
        driver.get("https://andersenlab.com/");
        // Кликнуть на кнопку принятия куки
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gatsby-focus-wrapper']/div/section/div/button"))).click();
        // Найти иконку скайпа и кликнуть на нее
        driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/footer/section/div/section[3]/div/div[3]/div/a[1]")).click();
        // Перейти на страницу, которая загрузилась после нажатия на иконку скайпа
        List<String> windowHandles = new ArrayList(driver.getWindowHandles());
        String secondTab = windowHandles.get(1);
        driver.switchTo().window(secondTab);
        // Так как сразу перенаправление происходит на модальное окно, к которому я не смогла привязаться, пришлось использовать Thread.sleep
        Thread.sleep(3000);
        // Нашла интересный вариант как кликнуть на кнопку Enter без привязки к элементу. При перенаправлении мы попадаем сразу на модальное окно
        // с активной кнопкой "Отмена", вот при помощи класса Robot я могу просто нажать на Enter. В классе Actions такого нет
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        // Здесь просто проверяем урл страницы, на которую мы перешли
        String str = driver.getCurrentUrl();
        Assert.assertEquals("https://join.skype.com/aM8R4P4dNJdy", str);
    }

    @Test
    public void secondTest() throws InterruptedException {
        // Зайти на главную страницу сайта
        driver.get("https://andersenlab.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gatsby-focus-wrapper']/div/section/div/button"))).click();
        // Кликнуть на выпадающий список и кликнуть в нем на сслылку для разработчиков Java
        driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/header//nav/ul/div[1]/div[1]/div")).click();
        driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/header//nav/ul/div[1]/div[2]/div[2]/div[2]/div/div/div/span[1]/a")).click();
        // Подождать пока страница загрузится
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gatsby-focus-wrapper']/header//div[2]/a")));
        // Проверяем, что перенапралены на нужную страницу
        String str = driver.getCurrentUrl();
        Assert.assertEquals("https://andersenlab.com/find-developers/java", str);
    }

    @After
    public void close() {
        driver.quit();
    }
}

