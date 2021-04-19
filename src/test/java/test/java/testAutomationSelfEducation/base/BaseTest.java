package test.java.testAutomationSelfEducation.base;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.PathsProperties;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static final String DEFAULT_URL = PathsProperties.getProperty("default_url.path");

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }

    @BeforeMethod
    protected void beforeMethod() {
        AqualityServices.getBrowser().goTo(DEFAULT_URL);
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
