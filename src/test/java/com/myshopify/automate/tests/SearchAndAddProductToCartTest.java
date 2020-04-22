package com.myshopify.automate.tests;

import builders.ProductBuilder;
import entities.Product;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SearchAndAddProductToCartTest extends BaseTest {

    @Test
    public void shouldSearchForProductAndAddToCart() throws InterruptedException {

        Product product = new ProductBuilder().build();

        page.getInstance(LoginPage.class)
                .login(password)
                .navigateToSearchPage()
                .searchForProduct(product)
                .selectProduct(product)
                .addProductToCart()
                .assertThatProductIsAddedToCart(product);
    }
}
