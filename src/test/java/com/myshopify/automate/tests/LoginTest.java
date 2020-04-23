package com.myshopify.automate.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Categories;

public class LoginTest extends BaseTest {

    private LoginPage login;

    @BeforeMethod(alwaysRun = true)
    public void initializeObjects() {
        login = new LoginPage(driver);
    }

    @Test(groups = {Categories.SMOKE})
    public void shouldBeAbleToLogin() throws InterruptedException {
        page.getInstance(LoginPage.class).login(password);
        login.assertLoginSuccessful("ecom.optimus");
    }
}
