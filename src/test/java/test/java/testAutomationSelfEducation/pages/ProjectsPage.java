package test.java.testAutomationSelfEducation.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProjectsPage extends Form {

    private final ITextBox versionName = getElementFactory().getTextBox(By.xpath("//p[contains(text(),'Reporting')]/span"), "version Name");
    private final String listNames = "//a[@class='list-group-item']";

    public ProjectsPage() {
        super(By.xpath("//div[contains(@class,'main-container')]"), "Project Page");
    }

    public String getVersionName() {
        return versionName.getText().replace("Version: ", "");
    }

    private List<WebElement> getListProjectNames() {
        return AqualityServices.getBrowser().getDriver().findElements(By.xpath(listNames));
    }

    public void clickRandomProjectNames() {
        List<WebElement> webElementList = getListProjectNames();
        Random ran = new Random();
//        webElementList.get(ran.nextInt(webElementList.size())).click();        Random ran = new Random();
//        int x = ran.nextInt(4);
        int x =4;
        int counter = 0;
        for (WebElement element : webElementList) {
            if (counter == x) {
                element.click();
                break;
            }
            counter++;
        }
    }
}