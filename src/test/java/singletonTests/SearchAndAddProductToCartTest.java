package singletonTests;

import builders.ProductBuilder;
import com.myshopify.automate.tests.BaseTest;
import entities.Product;
import org.testng.annotations.Test;
import singletonPages.HomePage;
import singletonPages.LoginPage;
import singletonPages.ProductDetailsPage;
import singletonPages.SearchPage;

public class SearchAndAddProductToCartTest extends BaseTest {

    @Test(alwaysRun = true)
    public void shouldSearchForProductAndAddToCart() throws InterruptedException {

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
                .addProductToCart()
                .assertThatProductAddedToCart(product);
    }
}
