package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasePage extends PageGenerator {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(this.driver, 100);

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
