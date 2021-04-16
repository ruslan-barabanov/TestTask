package test.java.testAutomationSelfEducation.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomProjectPage extends Form {

    private final String listTime = "//table[@class='table']/tbody/tr/td[6]";
    private final String bigTimeNameTest = "//table[@class='table']/tbody/tr/td[6][contains(text(),'%s')]/parent::td[1]/a";

    public RandomProjectPage(By locator, String name) {
        super(locator, name);
    }

    private List<WebElement> getListProjectNames() {
        return AqualityServices.getBrowser().getDriver().findElements(By.xpath(listTime));
    }

    public String getTimeText() {
        List<WebElement> webElementList = getListProjectNames();
        ArrayList<String> str = new ArrayList();
        webElementList.forEach(element-> str.add(element.getText()));
        Collections.sort(str);
        return str.get(str.size() - 1);
    }

    public void clickBigTimeTest(String time) {
        String fullLocator = String.format(bigTimeNameTest, time);
        AqualityServices.getBrowser().getDriver().findElement(By.xpath(fullLocator)).click();
    }
}
