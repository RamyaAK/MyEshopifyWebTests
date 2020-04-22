package com.myshopify.automate.tests;

import builders.ProductBuilder;
import entities.Product;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FeaturedCollectionTest extends BaseTest {

    @Test
    public void shouldAddProductFromFeaturedCollections() throws InterruptedException {

        Product product = new ProductBuilder().build();

        page.getInstance(LoginPage.class)
                .login(password)
                .navigateToCatalogPage();
    }
}
