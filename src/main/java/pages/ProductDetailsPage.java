package pages;

import entities.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductDetailsPage extends BasePage {

    @FindBy(css="div .btn[name='add'][type='submit'][aria-label='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(className="cart-popup__heading")
    private WebElement cartPopUpMessage;

    @FindBy(css="div.cart-popup[data-cart-popup=''][tabindex='-1']")
    private WebElement popUp;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage addProductToCart() throws InterruptedException {
        click(addToCartButton);
        return getInstance(ProductDetailsPage.class);
    }

    public CatalogPage assertThatProductIsAddedToCart(Product product) {
        wait.until(ExpectedConditions.visibilityOf(cartPopUpMessage));
        if (popUp.getText().contains(product.getProductName())) {
            Assert.assertEquals(cartPopUpMessage.getText(), "JUST ADDED TO YOUR CART");
        }
        return getInstance(CatalogPage.class);
    }
}
