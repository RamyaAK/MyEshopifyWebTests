package singletonTests;

import com.myshopify.automate.tests.BaseTest;
import org.testng.annotations.Test;
import singletonPages.LoginPage;

public class MyShopifyTests extends BaseTest {

    @Test
    public void shouldBeAbleToLogin(){

        LoginPage loginPage = LoginPage.getInstance();

        loginPage
                .navigateToLoginPage(baseUrl)
                .login(password)
                .assertLoginSuccessful("ecom.optimus");

    }

}
