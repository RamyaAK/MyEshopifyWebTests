package singletonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageGenerator;


public class SingletonBasePage {

    public static WebDriver driver;
    private static SingletonBasePage instance = null;

    SingletonBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static SingletonBasePage getInstance(WebDriver driver) {
        if (instance == null)
            instance = new SingletonBasePage(driver);
        return instance;
    }
    public WebDriverWait wait = new WebDriverWait(driver, 100);

    public <T> void click(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
    }

    public <T> void writeText(T elementAttr, String text) {
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(text);
        } else {
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public boolean verifyBasePageTitle() {
        String expectedPageTitle = "myshopify";
        return getPageTitle().contains(expectedPageTitle);
    }

}
