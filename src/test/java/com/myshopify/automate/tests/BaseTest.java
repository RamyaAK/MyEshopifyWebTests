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
    public String url;
    public String password;

    @BeforeTest

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        url = MyShopifyProperties.baseUrl;
        password = MyShopifyProperties.password;
        driver = new DriverIntializer("chrome").init();
        wait = new WebDriverWait(driver, 100);
        driver.manage().window().fullscreen();
        page = new PageGenerator(driver);
        driver.get(url);

        page.getInstance(LoginPage.class).navigateToLoginPage(url);

    }
    public String getFailedScreenshot() {
        String path;
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            path = "/Users/ramyaakulkarni/Downloads/myShopify/screenshot/" + this.getClass().getName() + "_" + ".png";
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

    @AfterMethod
    public void teardown() {

        driver.quit();

    }
}