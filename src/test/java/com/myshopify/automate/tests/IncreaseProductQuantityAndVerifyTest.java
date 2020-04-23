package com.myshopify.automate.tests;

import builders.ProductBuilder;
import entities.Product;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Categories;

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
