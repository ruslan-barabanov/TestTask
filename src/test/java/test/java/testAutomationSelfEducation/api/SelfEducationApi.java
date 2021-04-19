package test.java.testAutomationSelfEducation.api;

import org.apache.http.client.fluent.Content;
import util.FluentApiUtil;

public class SelfEducationApi {

    public static String getToken(String variant) {
        Content response = FluentApiUtil.sendPostGetToken("/token/get?variant=", variant);
        return response.asString();
    }
}
