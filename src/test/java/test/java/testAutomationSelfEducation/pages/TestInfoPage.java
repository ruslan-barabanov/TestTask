package test.java.testAutomationSelfEducation.pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class TestInfoPage extends Form {

    private final String listNames = "//div/p[3][contains(text(),'Duration')]";

    public TestInfoPage() {
        super(By.xpath("//div[contains(@class,'main-container')]"), "Test Info Page");
    }

    public String getInfoTimeTest() {
        String str = getBrowser().getDriver().findElement(By.xpath(listNames)).getText();
        return str.replace("Duration (H:m:s.S): ", "");
    }
}
