package com.myshopify.automate.tests;

import builders.ProductBuilder;
import entities.Product;
import listener.CustomListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(CustomListener.class)
public class IncreaseProductQuantityAndVerifyTest extends BaseTest{
    @Test(alwaysRun = true)
    public void shouldSearchForProductAddToCartAndIncreaseVerifyPrice() throws InterruptedException {

        Product product = new ProductBuilder().
                withNameAndQuantity("Round Neck Shirt", "3").build();

        page.getInstance(LoginPage.class)
                .login(password)
                .navigateToSearchPage()
                .searchForProduct(product)
                .selectProduct(product)
                .addProductToCart()
                .navigateToCartPage()
                .increaseProductQuantity(product)
                .assertPriceOfProduct(product);

    }
}
