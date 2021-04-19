package test.java.testAutomationSelfEducation.selfEducationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.testAutomationSelfEducation.base.BaseTest;
import test.java.testAutomationSelfEducation.pages.ProjectsPage;
import test.java.testAutomationSelfEducation.pages.RandomProjectPage;
import test.java.testAutomationSelfEducation.pages.TestInfoPage;
import util.FluentApi;
import util.MyLogger;
import util.PathsProperties;
import util.WorkWithCookie;

public class FindTheLongestTimeTest extends BaseTest {

    private final ProjectsPage projectsPage;
    private final RandomProjectPage randomProjectPage;
    private final TestInfoPage testInfoPage;
    private MyLogger logger;

    public FindTheLongestTimeTest() {
        testInfoPage = new TestInfoPage();
        randomProjectPage = new RandomProjectPage();
        projectsPage = new ProjectsPage();
        logger = MyLogger.getLogger(FindTheLongestTimeTest.class);
    }

    @Test()
    public void findTheLongestTimeTest() {
        String token = FluentApi.sendPostGetToken();
        Assert.assertNotNull(token, "token was not generated");
        logger.info("token is =" + token);
        WorkWithCookie.setCookie("token", token);
        getBrowser().getDriver().navigate().refresh();
        logger.info("page refreshed ");
        Assert.assertTrue(WorkWithCookie.getCookieName("token"), "cookies are not as expected");
        logger.info("cookie added ");
        String expectedText = PathsProperties.getProperty("variant.path");
        String actualText = projectsPage.getVersionName();
        Assert.assertEquals(expectedText, actualText, "version does not match ");
        logger.info("this version matches the variant " + actualText);
        projectsPage.clickRandomProjectNames();
        String mostLongTime = randomProjectPage.getTimeText();
        logger.info("the longest test has time " + mostLongTime);
        randomProjectPage.clickBigTimeTest(mostLongTime);
        String actual = testInfoPage.getInfoTimeTest();
        logger.info("the actual test time on the information page is " + actual);
        Assert.assertEquals(mostLongTime, actual, "time does not correspond to the greatest");
    }
}
