package pages;

import entities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.search-form__input-wrapper [name='q'][placeholder='Search']")
    private WebElement searchTextBox;

    @FindBy(className = "search-form__connected-submit")
    private WebElement searchButton;

    public SearchPage searchForProduct(Product product) {
        wait.until(ExpectedConditions.visibilityOf(searchTextBox));
        writeText(searchTextBox, product.getProductName());
        searchTextBox.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        click(searchButton);
        return this;

    }

    public ProductDetailsPage selectProduct(Product product) {

        List<WebElement> productsList = driver.findElements(By.cssSelector(".full-width-link"));
        for (WebElement webElement : productsList) {
            if (webElement.getText().contains(product.getProductName())) {
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
                webElement.click();
                break;
            }
        }
        return getInstance(ProductDetailsPage.class);
    }
}
