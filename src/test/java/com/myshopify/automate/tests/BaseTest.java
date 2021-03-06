package com.myshopify.automate.tests;

import driver.DriverIntializer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;
import pages.PageGenerator;
import properties.MyShopifyProperties;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;
    public String baseUrl;
    public String password;
    public String browserName;


    @BeforeMethod(alwaysRun = true)

    public void setup() {
        baseUrl = MyShopifyProperties.baseUrl;
        password = MyShopifyProperties.password;
        browserName = MyShopifyProperties.browser;
        driver = new DriverIntializer(browserName).init();
        wait = new WebDriverWait(driver, 100);
        driver.manage().window().fullscreen();

        page = new PageGenerator(driver);
        driver.get(baseUrl);
        page.getInstance(LoginPage.class).navigateToLoginPage(baseUrl);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}