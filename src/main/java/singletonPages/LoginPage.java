package singletonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class LoginPage extends SingletonBasePage {
    public static WebDriver driver;
    private static LoginPage loginPage = null;

    private LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static LoginPage getInstance() {
        if (loginPage == null)
            loginPage = new LoginPage(driver);
        return loginPage;
    }

    @FindBy(css = "[href='#LoginModal']")
    private WebElement loginLink;

    @FindBy(css = "#Password[name='password'][type='password'][placeholder='Your password']")
    private WebElement passwordValueEntryFeild;

    @FindBy(css = "button.btn--narrow[type='submit'][name='commit']")
    private WebElement enterButton;

    public LoginPage navigateToLoginPage(String url) {
        driver.get(url);
        return LoginPage.getInstance();
    }

    public LoginPage login(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        click(loginLink);
        writeText(passwordValueEntryFeild, password);
        wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        click(enterButton);
        return LoginPage.getInstance();
    }

    public void assertLoginSuccessful(String pageTitle) {
        verifyBasePageTitle();
        Assert.assertEquals(getPageTitle(), pageTitle);
    }
}
