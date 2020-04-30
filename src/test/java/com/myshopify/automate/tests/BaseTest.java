package com.myshopify.automate.tests;

import driver.DriverIntializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.PageGenerator;
import properties.MyShopifyProperties;


public class BaseTest {

    public static WebDriver driver = null;
    public WebDriverWait wait;
    public PageGenerator page;
    public String baseUrl;
    public String password;
    public String browserName;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        baseUrl = MyShopifyProperties.baseUrl;
        password = MyShopifyProperties.password;
        browserName = MyShopifyProperties.browserName;

        if(driver == null){
            driver = new DriverIntializer(browserName).init();
        }

        wait = new WebDriverWait(driver, 100);
        driver.manage().window().fullscreen();

        page = new PageGenerator(driver);
        page.getInstance(LoginPage.class).navigateToLoginPage(baseUrl);
 }

    @AfterMethod
    public void teardown() {
        driver.quit();
        driver = null;
    }
}