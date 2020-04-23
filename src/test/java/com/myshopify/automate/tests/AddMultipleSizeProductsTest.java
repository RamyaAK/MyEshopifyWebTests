package com.myshopify.automate.tests;

import builders.ProductBuilder;
import entities.Product;
import entities.ShirtSize;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Categories;

public class AddMultipleSizeProductsTest extends BaseTest {
    @Test(groups = {Categories.SMOKE})
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
