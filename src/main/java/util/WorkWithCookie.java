package util;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.Cookie;

public class WorkWithCookie {

    public static void setCookie(String name, String value) {
        AqualityServices.getBrowser().getDriver().manage().addCookie(new Cookie(name, value));
    }

    public static Cookie returnCookieName(String value) {
        return AqualityServices.getBrowser().getDriver().manage().getCookieNamed(value);
    }

    public static boolean getCookieName(String value) {
        if (returnCookieName(value) != null) {
            return true;
        } else {
            return false;
        }
    }
}
