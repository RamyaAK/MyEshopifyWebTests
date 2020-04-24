package com.myshopify.automate.tests;

import builders.ProductBuilder;
import entities.Product;
import entities.SearchByDropDown;
import listener.CustomListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(CustomListener.class)
public class FeaturedCollectionTest extends BaseTest {

    @Test(alwaysRun = true)
    public void shouldAddProductFromFeaturedCollections() throws InterruptedException {

        Product product = new ProductBuilder().build();

        page.getInstance(LoginPage.class)
                .login(password)
                .navigateToCatalogPage()
                .selectFeaturedOption(SearchByDropDown.Featured)
                .selectProduct(product)
                .addProductToCart()
                .assertThatProductAddedToCart(product)
                .assertThatAddedProductIsFromFeaturedCollections(SearchByDropDown.Featured);
    }
}
