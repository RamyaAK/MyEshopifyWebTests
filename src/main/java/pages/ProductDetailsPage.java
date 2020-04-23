package pages;

import entities.Product;
import entities.ShirtSize;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductDetailsPage extends BasePage {

    @FindBy(css=".btn[name='add'][type='submit'][aria-label='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(className="cart-popup__heading")
    private WebElement cartPopUpMessage;

    @FindBy(css="div.cart-popup[data-cart-popup=''][tabindex='-1']")
    private WebElement popUp;

    @FindBy(css="a.btn.btn--secondary-accent")
    private WebElement viewCartButton;

    @FindBy(css = "#SingleOptionSelector-1 > option")
    private List<WebElement> shirtSizeSelected;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage addProductToCart(){
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        click(addToCartButton);
        wait.until(ExpectedConditions.visibilityOf(popUp));
        return this;
    }

    public CatalogPage assertThatProductAddedToCart(Product product) {
        wait.until(ExpectedConditions.visibilityOf(cartPopUpMessage));
        if (popUp.getText().contains(product.getProductName())) {
            Assert.assertEquals(cartPopUpMessage.getText(), "JUST ADDED TO YOUR CART");
        }
        return getInstance(CatalogPage.class);
    }

    public ProductDetailsPage selectSizeOfTheProduct(ShirtSize shirtSize){
        for(int i = 0; i< shirtSizeSelected.size(); i++){
            if (shirtSizeSelected.get(i).getText().equalsIgnoreCase(shirtSize.toString())){
                wait.until(ExpectedConditions.visibilityOf(shirtSizeSelected.get(i)));
                click(shirtSizeSelected.get(i));
                break;
            }
        }return this;
    }
    public ProductDetailsPage assertSizeOfTheProduct(ShirtSize shirtSize) throws InterruptedException {
        String actualShirtSize= null;

        for(int i = 0; i< shirtSizeSelected.size(); i++){
            if (shirtSizeSelected.get(i).getText().equalsIgnoreCase(shirtSize.toString())){
               actualShirtSize = shirtSizeSelected.get(i).getText(); }
            }

        Assert.assertEquals(shirtSize.toString(),actualShirtSize);
        return this;
    }

    public CartPage navigateToCartPage(){
        wait.until(ExpectedConditions.visibilityOf(viewCartButton));
        click(viewCartButton);
        return getInstance(CartPage.class);
    }
}
