package com.myshopify.automate.tests;

import driver.DriverIntializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.PageGenerator;
import properties.MyShopifyProperties;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;
    public String url;
    public String password;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        url = MyShopifyProperties.baseUrl;
        password= MyShopifyProperties.password;
        driver = new DriverIntializer("chrome").init();
        wait = new WebDriverWait(driver, 2000);
        driver.manage().window().fullscreen();
        page = new PageGenerator(driver);
        driver.get(url);

        page.getInstance(LoginPage.class).navigateToLoginPage(url);

    }

    @AfterMethod
    public void teardown() {

         driver.quit();

    }
}