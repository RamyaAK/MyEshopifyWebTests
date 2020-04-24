package driver;

import browserFactory.ChromeBrowser;
import browserFactory.FirefoxBrowser;
import browserFactory.IEBrowser;
import constants.Browsers;
import org.openqa.selenium.WebDriver;

public class DriverIntializer {

    private String browser;

    public DriverIntializer(String browser) {
        this.browser = browser;
    }

    public WebDriver init() {

        WebDriver webDriver = null;

        switch (browser) {

            case Browsers.CHROME:
                webDriver = new ChromeBrowser().getDriver();
                break;

            case Browsers.FIREFOX:
                webDriver = new FirefoxBrowser().getDriver();
                break;

            case Browsers.IE:
                webDriver = new IEBrowser().getDriver();
                break;

        }
        DriverProvider.setDriver(webDriver);
        return webDriver;
    }
}
