package singletonTests;

import builders.ProductBuilder;
import com.myshopify.automate.tests.BaseTest;
import entities.Product;
import entities.SearchByDropDown;
import org.testng.annotations.Test;
import singletonPages.*;

public class FeaturedCollectionProductTest extends BaseTest {

    @Test(alwaysRun = true)
    public void shouldAddProductFromFeaturedCollections() throws InterruptedException {

        Product product = new ProductBuilder().build();

        LoginPage loginPage = LoginPage.getInstance();
        HomePage homePage = HomePage.getInstance();
        SearchPage searchPage = SearchPage.getInstance();
        ProductDetailsPage productDetailsPage= ProductDetailsPage.getInstance();
        CatalogPage catalogPage = CatalogPage.getInstance();

        loginPage
                .navigateToLoginPage(baseUrl)
                .login(password);
        homePage
                .navigateToCatalogPage();
        catalogPage
                .selectFeaturedOption(SearchByDropDown.Featured);
        searchPage
                .selectProduct(product);
        productDetailsPage
                .addProductToCart()
                .assertThatProductAddedToCart(product);
        catalogPage
                .assertThatAddedProductIsFromFeaturedCollections(SearchByDropDown.Featured);
    }

}
