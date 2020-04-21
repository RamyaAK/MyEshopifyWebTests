package browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements BrowserDriver {

    @Override
    public WebDriver getDriver() {
        setBinaryPath();
        return new ChromeDriver();
    }

    @Override
    public void setBinaryPath() {
        WebDriverManager.chromedriver().setup();
    }

}
