package singletonPages;

import entities.Product;
import entities.ShirtSize;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ProductDetailsPage extends SingletonBasePage {

    private static ProductDetailsPage productDetailsPage = null;

    public static ProductDetailsPage getInstance() {
        if (productDetailsPage == null)
            productDetailsPage = new ProductDetailsPage(driver);
        return productDetailsPage;
    }

    @FindBy(css=".btn[name='add'][type='submit'][aria-label='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(className = "cart-popup__heading")
    private WebElement cartPopUpMessage;

    @FindBy(css = "div.cart-popup[data-cart-popup=''][tabindex='-1']")
    private WebElement popUp;

    @FindBy(css="a.btn.btn--secondary-accent")
    private WebElement viewCartButton;

    @FindBy(css = "#SingleOptionSelector-1 > option")
    private List<WebElement> shirtSizeSelected;

    private ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public ProductDetailsPage addProductToCart(){
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        click(addToCartButton);
        wait.until(ExpectedConditions.visibilityOf(popUp));
        return this;
    }

    public ProductDetailsPage assertThatProductAddedToCart(Product product) {
        wait.until(ExpectedConditions.visibilityOf(cartPopUpMessage));
        if (popUp.getText().contains(product.getProductName())) {
            Assert.assertEquals(cartPopUpMessage.getText(), "JUST ADDED TO YOUR CART");
        }
        return this;
    }

    public ProductDetailsPage selectSizeOfTheProduct(ShirtSize shirtSize) {
        for (WebElement webElement : shirtSizeSelected) {
            if (webElement.getText().equalsIgnoreCase(shirtSize.toString())) {
                wait.until(ExpectedConditions.visibilityOf(webElement));
                click(webElement);
                break;
            }
        }
        return this;
    }

    public ProductDetailsPage assertSizeOfTheProduct(ShirtSize shirtSize) {

        String actualShirtSize = null;
        for (WebElement webElement : shirtSizeSelected) {
            if (webElement.getText().equalsIgnoreCase(shirtSize.toString())) {
                actualShirtSize = webElement.getText();
            }
        }
        Assert.assertEquals(shirtSize.toString(), actualShirtSize);
        return this;
    }

    public ProductDetailsPage navigateToCartPage(){
        wait.until(ExpectedConditions.visibilityOf(viewCartButton));
        click(viewCartButton);
        return this;
    }
}
