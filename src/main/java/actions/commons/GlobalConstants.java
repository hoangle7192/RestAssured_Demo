package actions.commons;

import java.io.File;

public class GlobalConstants {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");

    public static final String ADBLOCK_EXTENSION_OF_CHROME = PROJECT_PATH + File.separator + "browserExtensions" + File.separator + "Ublock_Chrome.crx";
    public static final String ADBLOCK_EXTENSION_OF_FIREFOX = PROJECT_PATH + File.separator + "browserExtensions" + File.separator + "adblocker-firefox.xpi";
    public static final String API_TEST_DATA_FOLDER = PROJECT_PATH + File.separator + "src" + File.separator + "main" + File.separator + "java"
            + File.separator + "datatest" + File.separator;

    public static final int LONG_TIME_OUT = 30;
    public static final int SHORT_TIME_OUT = 10;
}
