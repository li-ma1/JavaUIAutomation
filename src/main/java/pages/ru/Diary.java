package pages.ru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class Diary extends BasePage {

    public Diary(WebDriver driver) {
        super(driver);
    }
    private final By enteringEMail = By.id("signupform-email");
    private final By signupButton = By.id("signup_btn");
    private final By checkBoxText = By.xpath("//*[@id='registration_form']/div[4]/label/small");
    private final By errorText = By.xpath("//*[@id='registration_form']/div[1]/p");

    public Diary enteringEMail(String email) {
        driver.findElement(enteringEMail).sendKeys(email);
        return this;
    }
    public Diary clickSubmit() {
        driver.findElement(signupButton).click();
        return this;
    }
    public String checkBoxText() {
        return driver.findElement(checkBoxText).getText();
    }
    public String checkErrorText() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(errorText).getText();
    }

}
