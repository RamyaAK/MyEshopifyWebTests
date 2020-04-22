package com.myshopify.automate.tests;

import BaseTest.BaseTest;
import builders.ProductBuilder;
import entities.Product;
import entities.ShirtSize;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AddMultipleSizeProductsTest extends BaseTest {
    @Test
    public void shouldAddMultipleSizedProductsToCartAndVerify() throws InterruptedException {

        Product product = new ProductBuilder().build();

        page.getInstance(LoginPage.class)
                .login(password)
                .navigateToSearchPage()
                .searchForProduct(product)
                .selectProduct(product)

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
