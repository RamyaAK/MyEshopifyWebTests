package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.btn--link.site-header__icon[type='button']")
    private WebElement searchIcon;

    @FindBy(xpath = "//span[contains(text(),'Catalog')]")
    private WebElement catalogLink;

    public SearchPage navigateToSearchPage() {
        click(searchIcon);
        return getInstance(SearchPage.class);
    }

    public CatalogPage navigateToCatalogPage() {
        click(catalogLink);
        return getInstance(CatalogPage.class);

    }
}
