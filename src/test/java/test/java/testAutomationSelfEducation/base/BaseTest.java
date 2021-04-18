package test.java.testAutomationSelfEducation.base;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.PathsProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }
    private static final String default_url = PathsProperties.getProperty("default_url.path");

    @BeforeMethod
    protected void beforeMethod() {
        AqualityServices.getBrowser().goTo(default_url);
        getBrowser().maximize();
        AqualityServices.getBrowser().getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterTest() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }
}
