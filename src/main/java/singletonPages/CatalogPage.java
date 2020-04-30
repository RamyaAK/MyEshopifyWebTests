package singletonPages;

import entities.SearchByDropDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import java.util.List;

public class CatalogPage extends SingletonBasePage {

    private static CatalogPage catalogPage = null;

    public static CatalogPage getInstance() {
        if (catalogPage == null)
            catalogPage = new CatalogPage(driver);
        return catalogPage;
    }
    private CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#SortBy>option")
    private List<WebElement> sortByOptions;

    public CatalogPage selectFeaturedOption(SearchByDropDown searchByDropDownOption) {

        for (WebElement sortByOption : sortByOptions) {
            if (sortByOption.getText().equalsIgnoreCase(searchByDropDownOption.toString())) {
                wait.until(ExpectedConditions.elementToBeClickable(sortByOption));
                click(sortByOption);
                break;
            }
        }
        return this;
    }

    public void assertThatAddedProductIsFromFeaturedCollections(SearchByDropDown searchByDropDown) {
        String actualValue = "Featured";
        String expectedValue = searchByDropDown.toString();
        Assert.assertEquals(actualValue, expectedValue);

    }
}
