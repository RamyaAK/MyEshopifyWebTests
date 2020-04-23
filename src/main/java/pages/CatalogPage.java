package pages;

import entities.SearchByDropDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CatalogPage extends BasePage {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#SortBy>option")
    private List<WebElement> sortByOptions;

    public SearchPage selectFeaturedOption(SearchByDropDown searchByDropDownOption) {

        for (WebElement sortByOption : sortByOptions) {
            if (sortByOption.getText().equalsIgnoreCase(searchByDropDownOption.toString())) {
                click(sortByOption);
                break;
            }
        }
        return getInstance(SearchPage.class);
    }

    public void assertThatAddedProductIsFromFeaturedCollections(SearchByDropDown searchByDropDown) {
        String actualValue = "Featured";
        String expectedValue = searchByDropDown.toString();
        Assert.assertEquals(actualValue, expectedValue);

    }
}
