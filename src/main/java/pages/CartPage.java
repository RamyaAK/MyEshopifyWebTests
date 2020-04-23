package pages;

import entities.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[data-quantity-input=''][name='updates[]']")
    private WebElement productQuantity;

    @FindBy(css = ".cart__final-price.text-right.small--hide")
    private WebElement productPrice;

    @FindBy(css="span.cart-subtotal__price[data-cart-subtotal='']")
    private WebElement totalPrice;

    public CartPage increaseProductQuantity(Product product) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(productQuantity));
        productQuantity.clear();
        productQuantity.sendKeys(product.getProductQuantity());
        TimeUnit.SECONDS.sleep(5);
        product.setProductPrice(productPrice.getText());

        return this;
    }

    private String getPriceAfterIncreasingQuantity() {
        return totalPrice.getText();
    }

    public void assertPriceOfProduct(Product product) {
        Assert.assertEquals(getPriceAfterIncreasingQuantity(), product.getProductPrice());
    }
}
