package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.btn--link.site-header__icon[type='button']")
    private WebElement searchIcon;

    @FindBy(xpath = "//span[contains(text(),'Catalog')]")
    private WebElement catalogLink;

    public SearchPage navigateToSearchPage() {
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
        click(searchIcon);
        return getInstance(SearchPage.class);
    }

    public CatalogPage navigateToCatalogPage() {
        wait.until(ExpectedConditions.elementToBeClickable(catalogLink));
        click(catalogLink);
        return getInstance(CatalogPage.class);

    }
}
