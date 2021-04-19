package util;

import aquality.selenium.browser.AqualityServices;

public class MyLog {

    public static void getLoggerInfo(String s) {
        AqualityServices.getLogger().info(s);
    }
}
