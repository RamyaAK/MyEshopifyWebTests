package com.myshopify.automate.tests;

import builders.ProductBuilder;
import entities.Product;
import listener.CustomListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
@Listeners(CustomListener.class)
public class SearchAddProductToCartTest extends BaseTest {

    @Test(alwaysRun = true)
    public void shouldSearchForProductAndAddToCart() throws InterruptedException {

        Product product = new ProductBuilder().build();

        page.getInstance(LoginPage.class)
                .login(password)
                .navigateToSearchPage()
                .searchForProduct(product)
                .selectProduct(product)
                .addProductToCart()
                .assertThatProductAddedToCart(product);
    }
}
