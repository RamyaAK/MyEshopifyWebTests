package singletonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import javax.xml.ws.Holder;

public class HomePage extends SingletonBasePage {

    private static HomePage homePage = null;
    private SearchPage searchPage = SearchPage.getInstance();

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static HomePage getInstance() {
        if (homePage == null)
            homePage = new HomePage(driver);
        return homePage;
    }

    @FindBy(css = "button.btn--link.site-header__icon[type='button']")
    private WebElement searchIcon;

    @FindBy(xpath = "//span[contains(text(),'Catalog')]")
    private WebElement catalogLink;

    public HomePage navigateToSearchPage() {
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
        click(searchIcon);
        return this;
    }

    public void assertLoginSuccessful(String pageTitle) {
        verifyBasePageTitle();
        Assert.assertEquals(getPageTitle(), pageTitle);

    }

   public HomePage navigateToCatalogPage() {
        wait.until(ExpectedConditions.elementToBeClickable(catalogLink));
        click(catalogLink);
        return this;

    }
}
