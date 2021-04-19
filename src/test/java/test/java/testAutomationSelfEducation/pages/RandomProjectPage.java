package test.java.testAutomationSelfEducation.pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static java.lang.String.format;

public class RandomProjectPage extends Form {

    private final String listTime = "//table[@class='table']/tbody/tr/td[6]";
    private final String bigTimeNameTest = "//table[@class='table']/tbody/tr/td[6][contains(text(),'%s')]/parent::tr//td[1]/a";

    public RandomProjectPage() {
        super(By.xpath("//div[contains(@class,'main-container')]"), "RandomProject Page");
    }

    private List<WebElement> getListProjectNames() {
        return getBrowser().getDriver().findElements(By.xpath(listTime));
    }

    public String getTimeText() {
        List<WebElement> webElementList = getListProjectNames();
        List<String> str = new ArrayList<>();
        webElementList.forEach(element -> str.add(element.getText()));
        Collections.sort(str);
        return str.get(str.size() - 1);
    }

    public void clickBigTimeTest(String time) {
        getBrowser().getDriver().findElement(By.xpath(format(bigTimeNameTest, time))).click();
    }
}
