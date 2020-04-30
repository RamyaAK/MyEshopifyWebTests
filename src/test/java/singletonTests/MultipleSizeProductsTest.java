package singletonTests;

import builders.ProductBuilder;
import com.myshopify.automate.tests.BaseTest;
import entities.Product;
import entities.ShirtSize;
import org.testng.annotations.Test;
import singletonPages.HomePage;
import singletonPages.LoginPage;
import singletonPages.ProductDetailsPage;
import singletonPages.SearchPage;

public class MultipleSizeProductsTest extends BaseTest {

    @Test(alwaysRun = true)
    public void shouldAddMultipleSizedProductsToCartAndVerify() throws InterruptedException {

        Product product = new ProductBuilder().build();

        LoginPage loginPage = LoginPage.getInstance();
        HomePage homePage = HomePage.getInstance();
        SearchPage searchPage = SearchPage.getInstance();
        ProductDetailsPage productDetailsPage= ProductDetailsPage.getInstance();

        loginPage
                .navigateToLoginPage(baseUrl)
                .login(password);
        homePage
                .navigateToSearchPage();
        searchPage
                .searchForProduct(product)
                .selectProduct(product);

        productDetailsPage
                .selectSizeOfTheProduct(ShirtSize.S)
                .addProductToCart()
                .assertSizeOfTheProduct(ShirtSize.S)

                .selectSizeOfTheProduct(ShirtSize.L)
                .addProductToCart()
                .assertSizeOfTheProduct(ShirtSize.L)

                .selectSizeOfTheProduct(ShirtSize.M)
                .addProductToCart()
                .assertSizeOfTheProduct(ShirtSize.M)

                .assertThatProductAddedToCart(product);

    }
}
