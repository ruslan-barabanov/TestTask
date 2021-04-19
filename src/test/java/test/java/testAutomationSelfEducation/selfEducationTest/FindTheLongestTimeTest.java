package test.java.testAutomationSelfEducation.selfEducationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import test.java.testAutomationSelfEducation.api.SelfEducationApi;
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
        String token = SelfEducationApi.getToken(PathsPropertiesUtil.getProperty("variant.path"));
        Assert.assertNotNull(token, "token was not generated");
        Logger.getLoggerInfo("token is =" + token);
        CookieUtil.setCookie("token", token);
        getBrowser().getDriver().navigate().refresh();
        Logger.getLoggerInfo("page refreshed ");
        Assert.assertTrue(CookieUtil.isCookieExist("token"), "cookies are not as expected");
        Logger.getLoggerInfo("cookie added ");
        String actualText = projectsPage.getVersionName();
        Assert.assertEquals(PathsPropertiesUtil.getProperty("variant.path"), actualText, "version does not match ");
        Logger.getLoggerInfo("this version matches the variant " + actualText);
        projectsPage.clickRandomProjectNames();
        String mostLongTime = randomProjectPage.getTimeText();
        Logger.getLoggerInfo("the longest test has time " + mostLongTime);
        randomProjectPage.clickBigTimeTest(mostLongTime);
        String actual = testInfoPage.getInfoTimeTest();
        Logger.getLoggerInfo("the actual test time on the information page is " + actual);
        Assert.assertEquals(mostLongTime, actual, "time does not correspond to the greatest");
    }
}
