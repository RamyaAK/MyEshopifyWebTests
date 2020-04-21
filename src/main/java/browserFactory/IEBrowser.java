package browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser implements BrowserDriver {

    @Override
    public WebDriver getDriver() {
        setBinaryPath();
        return new InternetExplorerDriver();
    }

    @Override
    public void setBinaryPath() {
        WebDriverManager.iedriver().setup();
    }

}
