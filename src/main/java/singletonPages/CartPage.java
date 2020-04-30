package singletonPages;

import entities.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public class CartPage extends SingletonBasePage {

    private static CartPage cartPage = null;

    public static CartPage getInstance() {
        if (cartPage == null)
            cartPage = new CartPage(driver);
        return cartPage;
    }

    private CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
        TimeUnit.SECONDS.sleep(3);
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
