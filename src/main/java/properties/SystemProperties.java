package properties;

import java.util.Random;

public class SystemProperties {

    public static final String ENV = System.getProperty("env", "qa");
    public static final String TAGS = System.getProperty("tags", "smoke");
    public static final String CLIENT = System.getProperty("client", "");
    public static final String LANGUAGE = System.getProperty("language", "en");
    public static final String REPORT_TO_TEST_RAIL = System.getProperty("reportToTestRail", "false");
    public static final String TEST_RAIL_PLAN_NAME = System.getProperty("testRailPlanName", "");
    public static final String SLACK_CHANNEL = System.getProperty("slackChannel", "");
    public static final boolean SCREENSHOT_ON_PAGE_CREATION =
            null != System.getProperty("screenshotOnPageCreation")
                    && Boolean.parseBoolean(System.getProperty("screenshotOnPageCreation"));

    public static final String TARGET = System.getProperty("target", "local");
    public static final String BROWSER = System.getProperty("browser", "chrome");
    public static final String JOB_ID = System.getProperty("ci_job_id", String.valueOf(new Random().nextInt()));


    public static class RemoteProperties {
        public static class BrowserStackProperties {
            public static final String BROWSERSTACK_LOCAL = System.getProperty("browserStackLocal","false");
        }
        public static final String URL = System.getenv("URL");
    }
}
