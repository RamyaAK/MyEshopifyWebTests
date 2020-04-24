package com.myshopify.automate.tests;

import builders.ProductBuilder;
import entities.Product;
import entities.ShirtSize;
import listener.CustomListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(CustomListener.class)
public class AddMultipleSizeProductsTest extends BaseTest {
    @Test(alwaysRun = true)
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
