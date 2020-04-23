package com.myshopify.automate.tests;

import builders.ProductBuilder;
import entities.Product;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Categories;

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
