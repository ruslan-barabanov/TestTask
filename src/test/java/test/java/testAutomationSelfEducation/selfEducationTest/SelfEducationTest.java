package test.java.testAutomationSelfEducation.selfEducationTest;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.testAutomationSelfEducation.base.BaseTest;
import test.java.testAutomationSelfEducation.pages.ProjectsPage;
import test.java.testAutomationSelfEducation.pages.RandomProjectPage;
import test.java.testAutomationSelfEducation.pages.TestInfoPage;
import util.FluentApi;
import util.WorkWithCookie;

import java.io.IOException;

public class SelfEducationTest extends BaseTest {

    private final ProjectsPage projectsPage;
    private final RandomProjectPage randomProjectPage;
    private final TestInfoPage testInfoPage;

    public SelfEducationTest() {
        testInfoPage = new TestInfoPage();
        randomProjectPage = new RandomProjectPage(By.xpath(""), "Random page");
        projectsPage = new ProjectsPage();
    }

    @Test()
    public void mainSelfAducationTest() {
        try {
            String token = FluentApi.sendPostGetToken();
            Assert.assertNotNull(token, "token was not generated");
            WorkWithCookie.setCookie("token", token);
            getBrowser().getDriver().navigate().refresh();
            Cookie expectedTokenCookie = getBrowser().getDriver().manage().getCookieNamed("token");
            Assert.assertEquals(actualTokenCookie, expectedTokenCookie, "cookies are not as expected");
        } catch (IOException e) {
            System.out.println("token was not generated");
        }
        String expectedText = "Version: 4";
        String actualText = projectsPage.getVersionName().getText();
        Assert.assertEquals(propertyutil.get(variatn.path), actualText, "version does not match");
        projectsPage.clickRandomProjectNames();
        String mostLongTime = randomProjectPage.getTimeText();
        randomProjectPage.clickBigTimeTest(mostLongTime);
        String str = testInfoPage.getInfoTimeTest(mostLongTime).getText();
        String actual = str.replace("Duration (H:m:s.S): ", "");
        System.out.println(actual);
        Assert.assertEquals(mostLongTime, actual, "time does not correspond to the greatest");
    }
}
