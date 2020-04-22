package com.myshopify.automate.tests;

import builders.ProductBuilder;
import entities.Product;
import entities.SearchByDropDown;
import pages.LoginPage;

public class FeaturedCollectionTest extends BaseTest {


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
