package singletonTests;

import builders.ProductBuilder;
import com.myshopify.automate.tests.BaseTest;
import entities.Product;
import org.testng.annotations.Test;
import singletonPages.*;

public class IncreaseProductQuantityAndVerifyTest extends BaseTest {
    @Test(alwaysRun = true)
    public void shouldSearchForProductAddToCartAndIncreaseVerifyPrice() throws InterruptedException {

        Product product = new ProductBuilder().
                withNameAndQuantity("Round Neck Shirt", "3").build();

        LoginPage loginPage = LoginPage.getInstance();
        HomePage homePage = HomePage.getInstance();
        SearchPage searchPage = SearchPage.getInstance();
        ProductDetailsPage productDetailsPage= ProductDetailsPage.getInstance();
        CartPage cartPage = CartPage.getInstance();

        loginPage
                .navigateToLoginPage(baseUrl)
                .login(password);

        homePage
                .navigateToSearchPage();
        searchPage
                .searchForProduct(product)
                .selectProduct(product);
        productDetailsPage
                .addProductToCart()
                .navigateToCartPage();
        cartPage
                .increaseProductQuantity(product)
                .assertPriceOfProduct(product);

    }

}
