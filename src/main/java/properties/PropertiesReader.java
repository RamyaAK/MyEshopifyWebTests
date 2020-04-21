package properties;

import org.testng.Reporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    public PropertiesReader() {

        properties = new Properties();

        try {
            String env = SystemProperties.ENV;
            String language = SystemProperties.LANGUAGE;

            Reporter.log("ENV: " + env, true);
            Reporter.log("LANGUAGE: " + language, true);

            String propertiesFilePath = env + ".properties";
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);

            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public String getPassword(){
        return properties.getProperty("password");
    }

}
