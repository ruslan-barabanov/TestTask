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

public class SelfEducationTest extends BaseTest {

    private final ProjectsPage projectsPage;
    private final RandomProjectPage randomProjectPage;
    private final TestInfoPage testInfoPage;
    private MyLogger logger;

    public SelfEducationTest() {
        testInfoPage = new TestInfoPage();
        randomProjectPage = new RandomProjectPage();
        projectsPage = new ProjectsPage();
        logger = MyLogger.getLogger(SelfEducationTest.class);
    }

    @Test()
    public void mainSelfAducationTest() {

        String token = FluentApi.sendPostGetToken();
        Assert.assertNotNull(token, "token was not generated");
        WorkWithCookie.setCookie("token", token);
        getBrowser().getDriver().navigate().refresh();
        Assert.assertNotNull(WorkWithCookie.returnCookieName("token"), "cookies are not as expected");
        String expectedText = PathsProperties.getProperty("variant.path");
        String actualText = projectsPage.getVersionName();
        Assert.assertEquals(expectedText, actualText, "version does not match");
        projectsPage.clickRandomProjectNames();
        String mostLongTime = randomProjectPage.getTimeText();
        randomProjectPage.clickBigTimeTest(mostLongTime);

        String actual = testInfoPage.getInfoTimeTest();
        System.out.println(actual);
        Assert.assertEquals(mostLongTime, actual, "time does not correspond to the greatest");
        System.out.println();
    }
}
