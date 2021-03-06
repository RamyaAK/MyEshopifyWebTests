package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='#LoginModal']")
    private WebElement loginLink;

    @FindBy(css = "#Password[name='password'][type='password'][placeholder='Your password']")
    private WebElement passwordValueEntryFeild;

    @FindBy(css = "button.btn--narrow[type='submit'][name='commit']")
    private WebElement enterButton;

    public LoginPage navigateToLoginPage(String url) {
        driver.get(url);
        return this;
    }

    public HomePage login(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        click(loginLink);
        writeText(passwordValueEntryFeild, password);
        wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        click(enterButton);
        return getInstance(HomePage.class);
    }

    public void assertLoginSuccessful(String pageTitle) {
        verifyBasePageTitle();
        Assert.assertEquals(getPageTitle(), pageTitle);

    }

}
