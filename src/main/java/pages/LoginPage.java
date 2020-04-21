package pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /*@FindBy(id = "loginId")
    private WebElement loginTextBox;
    @FindBy(id = "password")
    private WebElement passwordTextBox;
    @FindBy(id = "loginbutton")
    private WebElement loginButton;*/

    @FindBy(css="[href='#LoginModal']")
    private WebElement loginLink;

    @FindBy(css="#Password[name='password'][type='password'][placeholder='Your password']")
    private WebElement passwordValueEntryFeild;

    @FindBy(css="button.btn--narrow[type='submit'][name='commit']")
    private WebElement enterButton;


    public LoginPage navigateToLoginPage(String url) {
        driver.get(url);
        return this;
    }

    public void login(String password) {
        click(loginLink);
        writeText(passwordValueEntryFeild, password);
        click(enterButton);

        try {
            driver.switchTo().alert().accept();

        } catch (NoAlertPresentException e) {
        }

    }
}
