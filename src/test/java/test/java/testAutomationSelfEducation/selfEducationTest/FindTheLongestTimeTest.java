package test.java.testAutomationSelfEducation.selfEducationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.testAutomationSelfEducation.base.BaseTest;
import test.java.testAutomationSelfEducation.pages.ProjectsPage;
import test.java.testAutomationSelfEducation.pages.RandomProjectPage;
import test.java.testAutomationSelfEducation.pages.TestInfoPage;
import util.*;

public class FindTheLongestTimeTest extends BaseTest {

    private final ProjectsPage projectsPage;
    private final RandomProjectPage randomProjectPage;
    private final TestInfoPage testInfoPage;

    public FindTheLongestTimeTest() {
        testInfoPage = new TestInfoPage();
        randomProjectPage = new RandomProjectPage();
        projectsPage = new ProjectsPage();
    }

    @Test()
    public void findTheLongestTimeTest() {
        String token = FluentApi.sendPostGetToken(PathsProperties.getProperty("variant.path"));
        Assert.assertNotNull(token, "token was not generated");
        MyLog.getLoggerInfo("token is =" + token);
        WorkWithCookie.setCookie("token", token);
        getBrowser().getDriver().navigate().refresh();
        MyLog.getLoggerInfo("page refreshed ");
        Assert.assertTrue(WorkWithCookie.isCookieExist("token"), "cookies are not as expected");
        MyLog.getLoggerInfo("cookie added ");
        String expectedText = PathsProperties.getProperty("variant.path");
        String actualText = projectsPage.getVersionName();
        Assert.assertEquals(expectedText, actualText, "version does not match ");
        MyLog.getLoggerInfo("this version matches the variant " + actualText);
        projectsPage.clickRandomProjectNames();
        String mostLongTime = randomProjectPage.getTimeText();
        MyLog.getLoggerInfo("the longest test has time " + mostLongTime);
        randomProjectPage.clickBigTimeTest(mostLongTime);
        String actual = testInfoPage.getInfoTimeTest();
        MyLog.getLoggerInfo("the actual test time on the information page is " + actual);
        Assert.assertEquals(mostLongTime, actual, "time does not correspond to the greatest");
    }
}
