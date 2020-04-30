package properties;

public class MyShopifyProperties {

    private static final PropertiesReader propertiesReader = new PropertiesReader();

    public static final String baseUrl = propertiesReader.getBaseUrl();
    public static final String password = propertiesReader.getPassword();
    public static final String browserName = propertiesReader.getBrowserName();

}
