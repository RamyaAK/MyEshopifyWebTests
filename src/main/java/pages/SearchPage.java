package pages;

import entities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.search-form__input-wrapper [name='q'][placeholder='Search']")
    private WebElement searchTextBox;

    @FindBy(className = "search-form__connected-submit")
    private WebElement search;

    @FindBy(css=".full-width-link")
    private List<WebElement> productList;

    public SearchPage searchForProduct(Product product) {
        writeText(searchTextBox, product.getProductName());
        searchTextBox.sendKeys(Keys.ENTER);
        click(search);
        return this;

    }
    public ProductDetailsPage selectProduct(Product product) {

        List<WebElement> productsList = driver.findElements(By.cssSelector(".full-width-link"));
        for (int i = 0; i < productsList.size(); i++){
            System.out.println(productList.get(i).getText());
           if (productList.get(i).getText().contains(product.getProductName())) {
                productsList.get(i).click();
                break;
            }
        }return getInstance(ProductDetailsPage.class);
    }
}
