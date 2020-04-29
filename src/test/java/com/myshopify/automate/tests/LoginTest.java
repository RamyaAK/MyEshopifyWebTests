package com.myshopify.automate.tests;

import listener.CustomListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage login;

    @BeforeMethod(alwaysRun = true)
    public void initializeObjects() {
        login = new LoginPage(driver);
    }

    @Test(alwaysRun = true)
    public void shouldBeAbleToLogin() throws InterruptedException {
        page.getInstance(LoginPage.class).login(password);
        login.assertLoginSuccessful("ecom.optimus");
    }
}
