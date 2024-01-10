package pages.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class BBC extends BasePage {

    public BBC(WebDriver driver) {
        super(driver);
    }

    private final By iconSignIn = By.xpath("//*[@id='idcta-username']");
    private final By greeting = By.xpath("//*[@id='signin-page']//h1/span");
    private final By fieldLogin = By.id("user-identifier-input");
    private final By fieldPassword = By.id("password-input");
    private final By submitButton = By.id("submit-button");
    private final By iconYourAccount = By.id("idcta-username");
    private final By errorText = By.xpath("//*[@id='form-message-password']/p/span/span");

    public String clickOnSignIn() throws InterruptedException {
        driver.findElement(iconSignIn).click();
        Thread.sleep(3000);
        ExpectedConditions.textToBe(By.xpath("//*[@id='signin-page']//h1/span"), "Снова здравствуйте");
        return driver.findElement(greeting).getText();
    }

    public BBC enteringLogin(String login) {
        driver.findElement(fieldLogin).sendKeys(login);
        return this;
    }

    public BBC enteringPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
        return this;
    }

    public BBC clickSubmit(){
        driver.findElement(submitButton).click();
        return this;
    }

    public String checkIconYourAccount() {
        return driver.findElement(iconYourAccount).getText();
    }
    public String checkErrorText() {
        return driver.findElement(errorText).getText();
    }
}
