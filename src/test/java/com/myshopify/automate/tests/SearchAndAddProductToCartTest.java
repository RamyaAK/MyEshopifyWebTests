package com.myshopify.automate.tests;

import builders.ProductBuilder;
import entities.Product;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Categories;

public class SearchAndAddProductToCartTest extends BaseTest {

    @Test(groups = {Categories.SMOKE})
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
