package pages.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class AndersenLab extends BasePage {

    public AndersenLab(WebDriver driver) {
        super(driver);
    }
    private final By acceptCookies = By.xpath("//*[@id='gatsby-focus-wrapper']/div/section/div/button");
    private final By iconSkype = By.xpath("//*[@id='gatsby-focus-wrapper']/footer/section/div/section[3]/div/div[3]/div/a[1]");
    private final By listOfTechStack = By.xpath("//*[@id='gatsby-focus-wrapper']/header//nav/ul/div[1]/div[1]/div");
    private final By infoAboutJavaDev = By.xpath("//*[@id='gatsby-focus-wrapper']/header//nav/ul/div[1]/div[2]/div[2]/div[2]/div/div/div/span[1]/a");

    public AndersenLab clickAcceptCookies(){
        driver.findElement(acceptCookies).click();
        return this;
    }
    public AndersenLab clickIconSkype () {
        driver.findElement(iconSkype).click();
        return this;
    }
    public AndersenLab clickOnDropdownTechStackAndJava() throws InterruptedException {
        driver.findElement(listOfTechStack).click();
        driver.findElement(infoAboutJavaDev).click();
        Thread.sleep(3000);
        return this;
    }

}
