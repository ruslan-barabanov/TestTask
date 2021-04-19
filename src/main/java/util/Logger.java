package util;

import aquality.selenium.browser.AqualityServices;

public class Logger {

    public static void getLoggerInfo(String s) {
        AqualityServices.getLogger().info(s);
    }
}
